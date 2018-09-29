package org.coin.coin.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreDAO {

    private static List<Store> eunpyeong, moa, onnuri, nowon, onnurimarket, tongin;
    private static String str;
    private Retrofit retrofit;
    private JSONService jsonService;

    public static List<Store> getTongin() {
        return tongin;
    }

    public static List<Store> getEunpyeong() {
        return eunpyeong;
    }

    public static List<Store> getMoa() {
        return moa;
    }

    public static List<Store> getOnnuri() {
        return onnuri;
    }

    public static List<Store> getNowon() {
        return nowon;
    }

    public static List<Store> getOnnurimarket() {
        return onnurimarket;
    }

    public StoreDAO() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-13-58-155-121.us-east-2.compute.amazonaws.com:8090")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonService = retrofit.create(JSONService.class);
    }

    public void EunpyeongData() {
        Call<List<Store>> call = jsonService.getEunpyeong();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    eunpyeong = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

    public void TonginData() {
        Call<List<Store>> call = jsonService.getTongin();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    tongin = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

    public void MoaData() {
        Call<List<Store>> call = jsonService.getMoa();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    moa = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

    public void OnnurimarketData() {
        Call<List<Store>> call = jsonService.getOnnurimarket();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    onnurimarket = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

    public void OnnuriData() {
        Call<List<Store>> call = jsonService.getOnnuri();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    onnuri = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

    public void NowonData() {
        Call<List<Store>> call = jsonService.getNowon();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new GsonBuilder().create();
                    str = gson.toJson(response.body());

                    Type listType = new TypeToken<List<Store>>() {
                    }.getType();
                    nowon = gson.fromJson(str, listType);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });
    }

}
