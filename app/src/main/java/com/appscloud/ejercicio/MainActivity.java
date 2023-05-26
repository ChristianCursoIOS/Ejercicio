package com.appscloud.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campoUno;
    EditText campoDos;
    EditText campoTres;

    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUno = findViewById(R.id.eT_campo_uno);
        campoDos = findViewById(R.id.eT_campo_dos);
        campoTres = findViewById(R.id.eT_campo_tres);
        btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setEnabled(false);
        campoUno.addTextChangedListener(textWatcher);
        campoDos.addTextChangedListener(textWatcher);
        campoTres.addTextChangedListener(textWatcher);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sCampo = campoUno.getText().toString();
                String sCampoDos = campoDos.getText().toString();
                String sCampoTres = campoTres.getText().toString();

                if (sCampo != null && sCampoDos != null && sCampoTres != null) {
                    Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                    intent.putExtra("cUno", sCampo);
                    intent.putExtra("cDos", sCampoDos);
                    intent.putExtra("cTres", sCampoTres);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String sCampo = campoUno.getText().toString();
            String sCampoDos = campoDos.getText().toString();
            String sCampoTres = campoTres.getText().toString();

            btnEnviar.setEnabled(!sCampo.isEmpty() && !sCampoDos.isEmpty() && !sCampoTres.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}