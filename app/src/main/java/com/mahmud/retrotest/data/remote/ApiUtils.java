package com.mahmud.retrotest.data.remote;

public class ApiUtils {
    public static final String BASE_URL = "http://artificial-soft.com";

    public static APIService getApiService(){
        return RetroClient.getClient(BASE_URL).create(APIService.class);
    }
}
