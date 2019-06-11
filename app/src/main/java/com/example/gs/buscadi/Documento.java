package com.example.gs.buscadi;

public class Documento {

    String DocId;
    String nomeDoPro;
    String cpf;
    String contatoDoAcha;

    public  Documento (){

    }

    public Documento(String docId, String nomeDoPro, String cpf, String contatoDoAcha) {
        DocId = docId;
        this.nomeDoPro = nomeDoPro;
        this.cpf = cpf;
        this.contatoDoAcha = contatoDoAcha;
    }

    public String getDocId() {
        return DocId;
    }

    public String getNomeDoPro() {
        return nomeDoPro;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContatoDoAcha() {
        return contatoDoAcha;
    }
}
