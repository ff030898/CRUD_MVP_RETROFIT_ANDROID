package com.example.crud_mvp_retrofit.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    //Vem da interface
    private static FilmesService INSTANCE;


    //Vem da Interface
    //Moshi tras o resultados da API Mas podesria ser GSON tbm
    public static FilmesService getInstance(){

        if(INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(FilmesService.class);
        }

        return INSTANCE;
    }

}
