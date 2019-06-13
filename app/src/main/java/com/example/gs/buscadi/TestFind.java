package com.example.gs.buscadi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;


public class TestFind extends AppCompatActivity {

    private DatabaseReference databaseDoc;
    private FirebaseDatabase firebaseDatabase;
    private TextView contatoAcha;
    private TextView cpfDoDoc;
    private TextView nomeDoDoc;
    private TextView nomeAcha;
    private TextView alerto;
    private Button btBuscarFD;
    private EditText busc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_find);
        busc = (EditText) findViewById(R.id.editBusc) ;
        contatoAcha = (TextView) findViewById(R.id.txtContatoID);
        cpfDoDoc = (TextView) findViewById(R.id.txtCpfID);
        nomeDoDoc = (TextView) findViewById(R.id.txtProplD);
        alerto = (TextView) findViewById(R.id.txtAlertalD);
        nomeAcha = (TextView) findViewById(R.id.nomeDoProID);
        btBuscarFD = (Button) findViewById(R.id. btnBuscarFD);



        eventoClick();



    }

    private void eventoClick() {
        btBuscarFD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpfDoDoc.setText("");
                contatoAcha.setText("");
                nomeDoDoc.setText("");
                nomeAcha.setText("");

                BuscarDoc();

            }
        });
    }

    public void BuscarDoc(){




        final String CpfTxt = busc.getText().toString().trim();

        databaseDoc = FirebaseDatabase.getInstance().getReference();

        // mTextViewData = (TextView) findViewById(R.id.textViewData);

        // tl2 = (TextView) findViewById(R.id.l2);

        databaseDoc.child("Documento").orderByChild("cpf").equalTo(CpfTxt).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){

                    //Documento doc = dataSnapshot.getValue(Documento.class);
                    String contAcha = dataSnapshot.child(CpfTxt).child("contatoDoAcha").getValue().toString();


                    if(contAcha == null){

                        alerto.setText("Não achoy");
                    }else{
                         contatoAcha.setText(dataSnapshot.child(CpfTxt).child("contatoDoAcha").getValue().toString());
                         contatoAcha.setText("Contato de Quem o Encontrou:\n"+contAcha);
                         cpfDoDoc.setText("Numero do CPF Que Foi Encontrado:\n"+dataSnapshot.child(CpfTxt).child("cpf").getValue().toString());
                        nomeDoDoc.setText("Nome do Proprietario do Documeto:\n"+dataSnapshot.child(CpfTxt).child("nomeDoPro").getValue().toString());
                         nomeAcha.setText("Nome de Quem Emcontrou:\n"+dataSnapshot.child(CpfTxt).child("nomeAcha").getValue().toString());
                        busc.setText("");
                    }



                }else {
                    alerto.setText("CPF Não Registrado!");
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



}























