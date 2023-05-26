package com.appscloud.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    TextView campoUno;
    TextView campoDos;
    TextView campoTres;

    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        campoUno = findViewById(R.id.tV_campo_uno_Seg);
        campoDos = findViewById(R.id.tV_campo_dos_Seg);
        campoTres = findViewById(R.id.tV_campo_tres_Seg);
        btnRegresar = findViewById(R.id.btn_regresar);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        String bUno = bundle.getString("cUno");
        String bDos = bundle.getString("cDos");
        String bTres = bundle.getString("cTres");

        campoUno.setText(bUno);
        campoDos.setText(bDos);
        campoTres.setText(bTres);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });


    }
}