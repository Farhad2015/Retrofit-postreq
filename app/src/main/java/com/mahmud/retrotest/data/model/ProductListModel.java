package com.mahmud.retrotest.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductListModel {
    @SerializedName("logo")
 //   @Expose
    private String logo;
    @SerializedName("company_name")
//    @Expose
    private String companyName;
    @SerializedName("about_us")
//    @Expose
    private String aboutUs;
    @SerializedName("error")
//    @Expose
    private Integer error;
    @SerializedName("error_report")
//    @Expose
    private String errorReport;
    @SerializedName("products")
//    @Expose
    private List<Product> products = null;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
