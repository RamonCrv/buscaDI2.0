package com.example.gs.buscadi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDoc extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextCpf;
    EditText editTextContato;
    Button btnAdd;

    DatabaseReference databaseDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doc);

        databaseDoc = FirebaseDatabase.getInstance().getReference("Documentos");

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextCpf = (EditText) findViewById(R.id.editTextCpf);
        editTextContato = (EditText) findViewById(R.id.editTextContato);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDoc();
            }
        });
    }

    private void addDoc (){
        String nome = editTextNome.getText().toString().trim();
        String Cpf = editTextCpf.getText().toString().trim();
        String Contato = editTextContato.getText().toString().trim();

        if (!TextUtils.isEmpty(nome)||!TextUtils.isEmpty(nome) || !TextUtils.isEmpty(nome) ){
         String id = databaseDoc.push().getKey();

         Documento documento = new Documento(id, nome, Cpf, Contato);
         databaseDoc.child(id).setValue(documento);

            Toast.makeText(this, "Documento adicionado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "É necessario preencher todos os campos", Toast.LENGTH_LONG).show();
        }
    }
}
