package com.example.grzegorz.rysownik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public float czcionk = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Rysuj rysuj = (Rysuj) findViewById(R.id.viewRusowanie);
        Button kasujButton = (Button) findViewById(R.id.Kasuj);
        Button zielonyButton = (Button) findViewById(R.id.Zielony);
        Button zoltyButton = (Button) findViewById(R.id.Pomaranczowy);
        Button niebieskiButton = (Button) findViewById(R.id.Niebieski);
        Button czerwonyButton = (Button) findViewById(R.id.Czerwony);
        Button czarnyButton = (Button) findViewById(R.id.Czarny);
        Button zmniejszButton = (Button) findViewById(R.id.Zmniejsz);
        Button zwiekszButton = (Button) findViewById(R.id.Zwieksz);
        kasujButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Wykasowany rysunek", Toast.LENGTH_SHORT).show();
                rysuj.kasujNarysowanie();
            }
        });
        czerwonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Czerwony", Toast.LENGTH_SHORT).show();
                rysuj.czerwonyRysuj();
            }
        });
        niebieskiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Niebieski", Toast.LENGTH_SHORT).show();
                rysuj.niebieskiRysuj();
            }
        });
        zielonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Zielony", Toast.LENGTH_SHORT).show();
                rysuj.zielonyRysuj();
            }
        });
        zoltyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pomarańczowy", Toast.LENGTH_SHORT).show();

                rysuj.zoltyRysuj();
            }
        });
        czarnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Czarny", Toast.LENGTH_SHORT).show();
                rysuj.czarnyRysuj();
            }
        });
        zmniejszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //        Rysuj.getRozmiarCzcionki();
                if (czcionk > 1) {
                    {
                        --czcionk;
                        rysuj.zmniejszRysuj();
                        Toast.makeText(MainActivity.this, "Zmniejszenie czcionki " + String.valueOf(czcionk), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Czcionka jest minimalana " + String.valueOf(czcionk), Toast.LENGTH_SHORT).show();

                }

            }
        });
        zwiekszButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (czcionk < 40) {
                    {
                        ++czcionk;
                        rysuj.zwiekszRysuj();
                        Toast.makeText(MainActivity.this, "Zwieksz czcionki " + String.valueOf(czcionk), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Czcionka jest maksymalna " + String.valueOf(czcionk), Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
