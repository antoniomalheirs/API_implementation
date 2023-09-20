package com.example.threadsapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);
        ImageView image5 = findViewById(R.id.image5);
        ImageView image6 = findViewById(R.id.image6);
        TextView timage1 = findViewById(R.id.timage1);
        TextView timage2 = findViewById(R.id.timage2);
        TextView timage3 = findViewById(R.id.timage3);
        TextView timage4 = findViewById(R.id.timage4);
        TextView timage5 = findViewById(R.id.timage5);
        TextView timage6 = findViewById(R.id.timage6);
        TextView timage7 = findViewById(R.id.timage7);
        TextView timage8 = findViewById(R.id.timage8);
        TextView timage9 = findViewById(R.id.timage9);
        TextView timage10 = findViewById(R.id.timage10);
        TextView timage11 = findViewById(R.id.timage11);
        TextView timage12 = findViewById(R.id.timage12);

        View.OnClickListener imageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.image1)
                {
                    int uriString = R.drawable.relogio1;
                    abrirAtividade(Mostrador.class,timage1.getText().toString(), timage2.getText().toString(), uriString,10.000f);
                }
                else if (v.getId() == R.id.image2)
                {
                    int uriString = R.drawable.relogio2;
                    abrirAtividade(Mostrador.class,timage3.getText().toString(), timage4.getText().toString(), uriString,15.000f);
                }
                else if (v.getId() == R.id.image3)
                {
                    int uriString = R.drawable.relogio3;
                    abrirAtividade(Mostrador.class,timage5.getText().toString(), timage6.getText().toString(), uriString,20.000f);
                }
                else if (v.getId() == R.id.image4)
                {
                    int uriString = R.drawable.relogio4;
                    abrirAtividade(Mostrador.class,timage7.getText().toString(), timage8.getText().toString(), uriString, 25.000f);
                }
                else if (v.getId() == R.id.image5)
                {
                    int uriString = R.drawable.relogio5;
                    abrirAtividade(Mostrador.class,timage9.getText().toString(), timage10.getText().toString(), uriString, 30.000f);
                }
                else if (v.getId() == R.id.image6)
                {
                    int uriString = R.drawable.relogio6;
                    abrirAtividade(Mostrador.class,timage11.getText().toString(), timage12.getText().toString(), uriString, 35.000f);
                }
            }
        };

        image1.setOnClickListener(imageClickListener);
        image2.setOnClickListener(imageClickListener);
        image3.setOnClickListener(imageClickListener);
        image4.setOnClickListener(imageClickListener);
        image5.setOnClickListener(imageClickListener);
        image6.setOnClickListener(imageClickListener);
    }

    private void abrirAtividade(Class<?> activityClass, String nome, String descri, int image, float valor) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        intent.putExtra("Nome", nome);
        intent.putExtra("Descrição", descri);
        intent.putExtra("Image", image);
        intent.putExtra("Valor", valor);
        startActivity(intent);
    }
}

