package com.example.threadsapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mostrador extends AppCompatActivity {

    Button dolar;
    Button euro;
    Button libra;

    TextView valorcotado;
    float valor;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrador);

        Intent intent = getIntent();
        String informacao = intent.getStringExtra("Nome");
        int imageResourceId = intent.getIntExtra("Image", 0);
        valor = intent.getFloatExtra("Valor",0);
        dolar = findViewById(R.id.dolar);
        euro = findViewById(R.id.euro);
        libra = findViewById(R.id.libra);
        valorcotado = findViewById(R.id.valorcotado);

        TextView textView = findViewById(R.id.textView1);
        textView.setText(informacao);
        TextView textV = findViewById(R.id.textView3);
        String valorFormatado = String.format("%.4f", valor);
        textV.setText(valorFormatado);

        if (imageResourceId != 0) {
            ImageView image = findViewById(R.id.imageView);
            image.setImageResource(imageResourceId);
        }


        dolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://economia.awesomeapi.com.br/last/USD-BRL";
                new FetchJsonTask ().execute(url,"USDBRL");
            }
        });

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://economia.awesomeapi.com.br/last/EUR-BRL";
                new FetchJsonTask ().execute(url,"EURBRL");
            }
        });

        libra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://economia.awesomeapi.com.br/last/GBP-BRL";
                new FetchJsonTask ().execute(url, "GBPBRL");
            }
        });
    }
        /*ApiRequest api = new ApiRequest();
        api.execute();*/
        public class FetchJsonTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... strings) {
                try {
                    // URL da API
                    URL url = new URL(strings[0]);

                    // Abra uma conexão HTTP
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    // Leia a resposta da API
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    // Analise a resposta JSON
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String bid = jsonObject.getJSONObject(strings[1]).getString("bid");

                    return bid;

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String json) {
                if (json != null) {
                    float flo = valor/Float.parseFloat(json);
                    valorcotado.setText(Float.toString(flo));
                } else {
                    valorcotado.setText("Erro ao buscar os dados JSON.");
                }
            }
        }
    }
