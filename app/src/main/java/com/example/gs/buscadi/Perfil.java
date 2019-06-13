package com.example.gs.buscadi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import io.opencensus.tags.Tag;

public class Perfil extends AppCompatActivity {




    private Button btnLogOut;
    private Button btadd;
    private Button  butBusc;

    private FirebaseAuth auth;
    private FirebaseUser user;

    Documento documento;


    DatabaseReference databaseDoc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        System.out.println("eae");





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
                Intent i = new Intent (getApplicationContext(),AddDocTest.class);
                startActivity(i);

            }

        });

        butBusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ib = new Intent (getApplicationContext(),TestFind.class);
                startActivity(ib);
            }
        });
    }



    private void inicializarComponentes() {

        btnLogOut = (Button) findViewById(R.id.btnPerfilLogout);
        btadd = (Button) findViewById(R.id.btnAdd);
        butBusc = (Button) findViewById(R.id.btnBusca);




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
/*
    public void BuscarDoc(){




        final String CpfTxt = txtBusc.getText().toString().trim();

        databaseDoc = FirebaseDatabase.getInstance().getReference();

       // mTextViewData = (TextView) findViewById(R.id.textViewData);
        tl1 = (TextView) findViewById(R.id.l1);
       // tl2 = (TextView) findViewById(R.id.l2);

       databaseDoc.child("Documento").orderByChild("cpf").equalTo(CpfTxt).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    //Documento doc = dataSnapshot.getValue(Documento.class);
                    String Cpf = dataSnapshot.child(CpfTxt).child("contatoDoAcha").getValue().toString();

                    if(Cpf == null){

                        tl1.setText("Não achoy");
                    }else{
                        tl1.setText(Cpf);

                    }



                    }else {
                    mTextViewData.setText("nao achou");
                    }
               // for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {


                  //  Log.e("Dados:",""+childSnapshot.getValue());

                   // System.out.println(doc);


                    //if (doc != null){
                   //     System.out.println("o objetyo ta salvo");
                  //  }else{
                  //      System.out.println("tA NUZAÇO");
                 //   }
            }


           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
           //
                //System.out.println(doc);
                //System.out.println("cupameupaui");
            });


        // Toast.makeText(this, documento.getContatoDoAcha(), Toast.LENGTH_LONG).show();
        /*
        if (!TextUtils.isEmpty(Cpf)){

            if (databaseDoc.child("cpf").toString().equals(Cpf)){
                Toast.makeText(this, "Documento encontrado", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Documento não encontrado", Toast.LENGTH_LONG).show();
            }

        }
        */



}
