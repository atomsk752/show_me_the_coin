package org.coin.coin.data;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONService {

    @GET("/nowon.jsp")
    Call<List<Store>> getNowon();

    @GET("/eunpyeong.jsp")
    Call<List<Store>> getEunpyeong();

    @GET("/onnuri_market.jsp")
    Call<List<Store>> getOnnurimarket();

    @GET("/moa.jsp")
    Call<List<Store>> getMoa();

    @GET("/onnuri.jsp")
    Call<List<Store>> getOnnuri();

    @GET("/tongin.jsp")
    Call<List<Store>> getTongin();

}
