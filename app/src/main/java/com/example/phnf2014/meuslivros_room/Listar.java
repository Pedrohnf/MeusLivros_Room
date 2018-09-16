package com.example.phnf2014.meuslivros_room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Listar extends AppCompatActivity {

    TextView titulolistar;
    TextView autorlistar;
    TextView anolistar;
    TextView notalistar;
    AppDatabase db;
    LivroDao MylivroDao;
    List<Livro> listaLivros;
    Livro livro;
    int livro_atual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        db = AppDatabase.getDatabase(this);
        MylivroDao = db.livroDao();

        final Button anterior = findViewById(R.id.anterior);
        final Button proximo = findViewById(R.id.proximo);
        titulolistar = findViewById(R.id.titulolistar);
        autorlistar = findViewById(R.id.autorlistar);
        anolistar = findViewById(R.id.anolistar);
        notalistar = findViewById(R.id.notalistar);

        MylivroDao.listAll();

        livro_atual = 0;

        //inicializar o contador para paginar
        livro_atual = 0;

        //preencher a lista com o livro de acordo com o contador, no caso o primeiro livro
        titulolistar.setText(listaLivros.get(livro_atual).getTitulo());
        autorlistar.setText(listaLivros.get(livro_atual).getAutor());
        anolistar.setText(String.valueOf(listaLivros.get(livro_atual).getAno()));
        notalistar.setText(String.valueOf(listaLivros.get(livro_atual).getNota()));

        //desabilitar o botao anterior, já que o primeiro livro
        anterior.setEnabled(false);

        //botao para paginar para o proximo livro da lista
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(livro_atual >= listaLivros.size() - 1){

                    Toast.makeText(Listar.this, "Último Livro da Lista", Toast.LENGTH_SHORT).show();
                    proximo.setEnabled(false);//desabilitar o botao

                }else{

                    proximo.setEnabled(true);
                    anterior.setEnabled(true);
                    livro_atual++;

                    //mudar o livro
                    titulolistar.setText(listaLivros.get(livro_atual).getTitulo());
                    autorlistar.setText(listaLivros.get(livro_atual).getAutor());
                    anolistar.setText(String.valueOf(listaLivros.get(livro_atual).getAno()));
                    notalistar.setText(String.valueOf(listaLivros.get(livro_atual).getNota()));

                }

            }
        });

        //botao para paginar para o livro anterior da lista
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(livro_atual < 1){
                    Toast.makeText(Listar.this, "Primeiro Livro da Lista", Toast.LENGTH_SHORT).show();
                    anterior.setEnabled(false);//desabilitar o botao
                }else{

                    proximo.setEnabled(true);
                    anterior.setEnabled(true);
                    livro_atual--;

                    //mudar o livro
                    titulolistar.setText(listaLivros.get(livro_atual).getTitulo());
                    autorlistar.setText(listaLivros.get(livro_atual).getAutor());
                    anolistar.setText(String.valueOf(listaLivros.get(livro_atual).getAno()));
                    notalistar.setText(String.valueOf(listaLivros.get(livro_atual).getNota()));

                }
            }
        });
    }

}
