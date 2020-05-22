package com.example.crud_mvp_retrofit.ui.lista_filmes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.crud_mvp_retrofit.R;
import com.example.crud_mvp_retrofit.data.mapper.FilmeMapper;
import com.example.crud_mvp_retrofit.data.model.Filme;
import com.example.crud_mvp_retrofit.data.network.ApiService;
import com.example.crud_mvp_retrofit.data.network.response.FilmesResult;
import com.example.crud_mvp_retrofit.ui.detalhes_filmes.DetalhesFilmeActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements ListaFilmeContrato.ListaFilmesView, ListaFilmesAdapter.ItemFilmeClickListener{

    //ListaFilmesAdapter adapter;
    private RecyclerView recyclerFilmes;
    private ListaFilmesAdapter filmesAdapter;
    private ListaFilmeContrato.ListaFilmePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        configuraAdapter();
        presenter = new ListaFilmesPresenter(this);
        presenter.obtemFilmes();

    }

    private void configuraAdapter(){

        recyclerFilmes = findViewById(R.id.recyclerFilmes);
        filmesAdapter = new ListaFilmesAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerFilmes.setLayoutManager(gridLayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);

    }

    @Override
    public void mostraFilmes(List<Filme> filmes) {
      filmesAdapter.setFilmes(filmes);
    }

    @Override
    public void mostraErros() {
        Toast.makeText(getApplicationContext(), "ERRO AO CARREGAR FILMES", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemFilmeClicado(Filme filme) {
        Intent intent = new Intent(this, DetalhesFilmeActivity.class);
        intent.putExtra(DetalhesFilmeActivity.EXTRA_FILME, filme);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destruirView();
    }
}
