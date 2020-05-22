package com.example.crud_mvp_retrofit.data.network;

import com.example.crud_mvp_retrofit.data.network.response.FilmesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {
    @GET("movie/popular")
    Call<FilmesResult> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
