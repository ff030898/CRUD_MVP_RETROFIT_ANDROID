package com.example.crud_mvp_retrofit.data.mapper;
//Classe responsável por fazer o parse

import com.example.crud_mvp_retrofit.data.model.Filme;
import com.example.crud_mvp_retrofit.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    //Passa da Requisição Para o Modelo
    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse){

     List<Filme> listsFilme = new ArrayList<>();

     for (FilmeResponse filmeResponse : listaFilmeResponse){
         final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
         listsFilme.add(filme);
     }

     return listsFilme;
    }
}
