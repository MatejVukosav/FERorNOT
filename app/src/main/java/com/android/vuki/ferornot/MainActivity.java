package com.android.vuki.ferornot;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn0)
    Button zapocni;
    @Bind({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7})
    List<TextView> textovi;
    static int brojac = 0;
    Handler handler = new Handler();
    Runnable r;
    static boolean prvi = true;
    static boolean drugi;
    static boolean treci;
    static boolean cetvrti;
    static boolean peti;
    static boolean sesti;
    static boolean sedmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        r = new Runnable() {
            @Override
            public void run() {
                ispis(textovi);
                if (brojac + 1 > 100) {
                    Toast.makeText(getApplicationContext(), "odi na faks", Toast.LENGTH_SHORT).show();
                    brojac = 0;
                }
            }
        };

        zapocni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 100; i++) {
                    handler.postDelayed(r, 50 * i);
                }
            }
        });
    }

    private static void ispis(List<TextView> textovi) {
        brojac++;
        if (brojac > 6) {
            textovi.get(0).setText("Racunam " + (brojac - 6));
            textovi.get(1).setText("Racunam " + (brojac - 5));
            textovi.get(2).setText("Racunam " + (brojac - 4));
            textovi.get(3).setText("Racunam " + (brojac - 3));
            textovi.get(4).setText("Racunam " + (brojac - 2));
            textovi.get(5).setText("Racunam " + (brojac - 1));
            textovi.get(6).setText("Racunam " + (brojac));
        } else {
            if (prvi) {
                textovi.get(0).setText("Racunam " + (brojac));
                prvi = false;
                drugi = true;
            } else if (drugi) {
                textovi.get(1).setText("Racunam " + (brojac));
                drugi = false;
                treci = true;
            } else if (treci) {
                textovi.get(2).setText("Racunam " + (brojac));
                treci = false;
                cetvrti = true;
            } else if (cetvrti) {
                textovi.get(3).setText("Racunam " + (brojac));
                cetvrti = false;
                peti = true;
            } else if (peti) {
                textovi.get(4).setText("Racunam " + (brojac));
                peti = false;
                sesti = true;
            } else if (sesti) {
                textovi.get(5).setText("Racunam " + (brojac));
                sesti = false;
                sedmi = true;
            } else if (sedmi) {
                textovi.get(6).setText("Racunam " + (brojac));
                sedmi = false;
                prvi = true;
            }
        }
    }
}
