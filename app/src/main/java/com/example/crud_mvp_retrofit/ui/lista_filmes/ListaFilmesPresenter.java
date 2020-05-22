package com.example.crud_mvp_retrofit.ui.lista_filmes;

import com.example.crud_mvp_retrofit.data.mapper.FilmeMapper;
import com.example.crud_mvp_retrofit.data.model.Filme;
import com.example.crud_mvp_retrofit.data.network.ApiService;
import com.example.crud_mvp_retrofit.data.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmeContrato.ListaFilmePresenter {

    ListaFilmeContrato.ListaFilmesView view;

    ListaFilmesPresenter(ListaFilmeContrato.ListaFilmesView view) {
        this.view = view;
    }


    @Override
    public void obtemFilmes() {
        ApiService.getInstance().obterFilmesPopulares("fe7beb95e44b152f6870b38d494575b2")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                        if(response.isSuccessful()){
                            final List<Filme> listaFilmes = FilmeMapper.deResponseParaDominio(response.body().getResultadoFilmes());
                            view.mostraFilmes(listaFilmes);
                        }else{
                            view.mostraErros();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErros();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }


}
