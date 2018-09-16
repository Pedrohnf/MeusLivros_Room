package com.example.phnf2014.meuslivros_room;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int codigo = 1;
    private ConstraintLayout x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Cadastrar = findViewById(R.id.Cadastrar);
        Button Listar = findViewById(R.id.Listar);
        x = findViewById(R.id.x);


        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent c = new Intent(getApplicationContext(),Cadastrar.class);
                startActivityForResult(c,codigo);

            }
        });

        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent c1 = new Intent(getApplicationContext(),Listar.class);
                startActivity(c1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {

        if(requestCode == codigo && resultCode == RESULT_OK){
            //Snackbar

            Snackbar s = Snackbar.make(x,"Livro Cadastrado com Sucesso", Snackbar.LENGTH_SHORT);
            s.show();
        }

    }

}
