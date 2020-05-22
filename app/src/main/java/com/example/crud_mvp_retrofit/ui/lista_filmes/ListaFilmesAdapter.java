package com.example.crud_mvp_retrofit.ui.lista_filmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud_mvp_retrofit.R;
import com.example.crud_mvp_retrofit.data.model.Filme;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.myViewHolder> {


    private List<Filme> filmes;

    private static ItemFilmeClickListener itemFilmeClickListener;

    public ListaFilmesAdapter(ItemFilmeClickListener itemFilmeClickListener) {
        this.itemFilmeClickListener = itemFilmeClickListener;
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
      holder.bind(filmes.get(position));

    }

    @Override
    public int getItemCount() {
        return (filmes != null & filmes.size() > 0) ? filmes.size() : 0;
    }

    static class myViewHolder extends RecyclerView.ViewHolder{

        TextView txtNomeFilme;
        ImageView image_poster_filme;
        private Filme filme;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeFilme = itemView.findViewById(R.id.text_titulo_filme);
            image_poster_filme = itemView.findViewById(R.id.image_poster_filme);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemFilmeClickListener != null) {
                        itemFilmeClickListener.onItemFilmeClicado(filme);
                    }
                }
            });

        }
        public void bind(Filme filme){
            this.filme = filme;
            txtNomeFilme.setText(filme.getTitulo());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/" + filme.getCaminhoPoster())
                    .into(image_poster_filme);
        }
    }

    public void setFilmes(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }

    public interface ItemFilmeClickListener {

        void onItemFilmeClicado(Filme filme);
    }


}
