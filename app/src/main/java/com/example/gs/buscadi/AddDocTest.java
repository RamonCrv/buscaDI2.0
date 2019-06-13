package com.example.gs.buscadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDocTest extends AppCompatActivity {

    EditText etNome;
    EditText yourName;
    EditText etCpf;
    EditText etContato;
    Button butAdd;

    DatabaseReference databaseDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doc_test);

        databaseDoc = FirebaseDatabase.getInstance().getReference("Documento");
        etNome = (EditText) findViewById(R.id.editTextNome);
        etCpf = (EditText) findViewById(R.id.editTextCpf);
        etContato = (EditText) findViewById(R.id.editTextContato);
        yourName = (EditText) findViewById(R.id.myNome) ;

        butAdd = (Button) findViewById(R.id.btnAdd);

        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDoc();


            }
        });
    }

    private void addDoc (){
        String nome = etNome.getText().toString().trim();
        String Cpf = etCpf.getText().toString().trim();
        String Contato = etContato.getText().toString().trim();
        String nomeAcha = yourName.getText().toString().trim();
        String userId = FirebaseAuth.getInstance().getUid();
        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();


        if (!TextUtils.isEmpty(nome)||!TextUtils.isEmpty(Cpf) || !TextUtils.isEmpty(Contato)|| !TextUtils.isEmpty(nomeAcha) ){
            String id = databaseDoc.push().getKey();
            Documento documento;
            documento = new Documento(id, nome, Cpf, Contato, userId, userEmail, nomeAcha);
            databaseDoc.child(Cpf).setValue(documento);
            finish();

            Toast.makeText(this, "Documento adicionado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "É necessario preencher todos os campos", Toast.LENGTH_LONG).show();
        }
    }
}
