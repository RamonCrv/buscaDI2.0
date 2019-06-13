package com.example.gs.buscadi;

public class Documento {

   private String DocId;
    private String nomeDoPro;
    private String cpf;
    private String contatoDoAcha;
    private String IdUsuario;
    private String EmailDoAcho;
    private  String nomeAcha;



    public String getEmailDoAcho() {
        return EmailDoAcho;
    }

    public  Documento (){

    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public Documento(String docId, String nomeDoPro, String cpf, String contatoDoAcha, String idUsuario, String emailDoAcho, String nomeAcha ) {
        DocId = docId;
        this.cpf = cpf;
        this.contatoDoAcha = contatoDoAcha;
        IdUsuario = idUsuario;
        EmailDoAcho = emailDoAcho;
        this.nomeDoPro = nomeDoPro;
        this.nomeAcha = nomeAcha;
    }

    public String getNomeAcha() {
        return nomeAcha;
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

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }
}
