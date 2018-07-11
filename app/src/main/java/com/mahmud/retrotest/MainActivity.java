package com.mahmud.retrotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.mahmud.retrotest.adapters.ProductListAdapter;
import com.mahmud.retrotest.data.model.Product;
import com.mahmud.retrotest.data.model.ProductListModel;
import com.mahmud.retrotest.data.remote.APIService;
import com.mahmud.retrotest.data.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewLogoUrl, textViewCompanyName, textViewCompanyDescription, textViewErorr, textViewErrorReport;
    private RecyclerView recyclerViewProductList;
    private List<Product> plModel;
    private ProductListAdapter plAdapter;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAPIService = ApiUtils.getApiService();
        initializedFields();
    }

    private void initializedFields() {
        textViewLogoUrl = (TextView) findViewById(R.id.txt_LogoURL);
        textViewCompanyName = (TextView) findViewById(R.id.txt_CompanyName);
        textViewCompanyDescription = (TextView) findViewById(R.id.txt_AboutCompany);
        textViewErorr = (TextView) findViewById(R.id.txt_Error);
        textViewErrorReport = (TextView) findViewById(R.id.txt_ErrorReport);
        downLoadAboutUsData();
    }

    private void downLoadAboutUsData() {
        mAPIService.showProductList("Teacher").enqueue(new Callback<ProductListModel>() {
            @Override
            public void onResponse(Call<ProductListModel> call, Response<ProductListModel> response) {
                if (response.isSuccessful()) {
                    recyclerViewProductList = (RecyclerView) findViewById(R.id.rv_ProductList);
                    plModel = new ArrayList<>();
                    plModel.addAll(response.body().getProducts());

                    textViewLogoUrl.setText(response.body().getLogo());
                    textViewCompanyName.setText(response.body().getCompanyName());
                    textViewCompanyDescription.setText(response.body().getAboutUs());
                    textViewErorr.setText("Error: " + response.body().getError());
                    textViewErrorReport.setText("Error Report: " + response.body().getErrorReport());

                    setProductList();
                }
            }

            @Override
            public void onFailure(Call<ProductListModel> call, Throwable t) {
                Log.e("ErrorHappened", "Error");
            }
        });
    }

    private void setProductList() {
        plAdapter = new ProductListAdapter(plModel, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewProductList.setLayoutManager(layoutManager);
        recyclerViewProductList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewProductList.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        recyclerViewProductList.setAdapter(plAdapter);
    }
}
