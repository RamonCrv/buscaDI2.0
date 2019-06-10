package com.example.gs.buscadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Perfil extends AppCompatActivity {

    private EditText  editBusca;
    private Button btnLogOut;
    private Button btadd;
    private Button btnBusca;

    private FirebaseAuth auth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        inicializarComponentes();
        eventoClick();

        }

    private void eventoClick() {
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logOut();
                finish();
            }
        });
        btadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent i = new Intent (getApplicationContext(),AddDoc.class);
                startActivity(i);

            }

        });
    }



    private void inicializarComponentes() {
        editBusca = (EditText) findViewById(R.id.textBuscar)  ;
        btnLogOut = (Button) findViewById(R.id.btnPerfilLogout);
        btadd = (Button) findViewById(R.id.btnAdd);



    }


    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        VerificaUser();
    }

    private void VerificaUser() {
        if (user==null){
            finish();
        }else {

        }
    }
}
