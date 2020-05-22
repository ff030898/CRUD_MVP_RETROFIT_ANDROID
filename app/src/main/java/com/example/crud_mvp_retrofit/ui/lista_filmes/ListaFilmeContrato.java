package com.example.crud_mvp_retrofit.ui.lista_filmes;

import com.example.crud_mvp_retrofit.data.model.Filme;

import java.util.List;

public interface ListaFilmeContrato {

    interface ListaFilmesView{
      void mostraFilmes(List<Filme> filmes);
      void mostraErros();
    }

    interface ListaFilmePresenter{

      void obtemFilmes();
      void destruirView();

    }
}
