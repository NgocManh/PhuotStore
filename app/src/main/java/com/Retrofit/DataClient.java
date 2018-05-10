package com.Retrofit;

import com.model.LoaiSanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {

    @GET("loaisanpham")
    Call<List<LoaiSanPham>> getList();

  /*  @GET("loaisanpham/test")
    Call<String> getTest();*/
}
