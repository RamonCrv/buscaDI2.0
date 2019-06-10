package com.example.gs.buscadi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText editEmail,editSenha;
    private Button btLogar,btNovo;

            private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializarComponentes();
        eventoClicks();


    }

    private void eventoClicks() {
        btNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (getApplicationContext(),Cadastro.class);
                startActivity(i);
            }
        });
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();
                login(email,senha);
            }
        });
    }

    private void login(String email, String senha) {
        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(Login.this,Perfil.class);
                    startActivity(i);
                }else{
                    alert("Email ou senha incorreto");
                }
            }
        });
    }
    private void alert(String s){
        Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("WrongViewCast")
    private void inicializarComponentes() {
     editEmail = (EditText) findViewById(R.id.editLoginEmail);
     editSenha = (EditText) findViewById(R.id.editLoginSenha);
     btLogar = (Button) findViewById(R.id.btnLoginLogar);
     btNovo =  (Button) findViewById(R.id.btnLoginNovo);


    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();

    }
}

