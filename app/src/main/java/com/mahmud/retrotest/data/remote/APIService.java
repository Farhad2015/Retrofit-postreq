package com.mahmud.retrotest.data.remote;

import com.mahmud.retrotest.data.model.ProductListModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @POST("/api/about.php")
    @FormUrlEncoded
    Call<ProductListModel> showProductList(@Field("category") String categorys);
}
