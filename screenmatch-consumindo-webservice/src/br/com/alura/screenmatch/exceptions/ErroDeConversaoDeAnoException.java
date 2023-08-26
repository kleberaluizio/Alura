package br.com.alura.screenmatch.exceptions;

public class ErroDeConversaoDeAnoException extends RuntimeException {

    private String messagem;

    public ErroDeConversaoDeAnoException(String messagem){
        this.messagem = messagem;
    }

    @Override
    public String getMessage(){
        return this.messagem;
    }

}
