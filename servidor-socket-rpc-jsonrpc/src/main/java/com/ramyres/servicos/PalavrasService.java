package com.ramyres.servicos;

public class PalavrasService implements ServiceInterface {

    @Override
    public String[] Run(String[] params) {
        if(params.length < 1 || params[0] == null) {
             return new String[]{ "0", "0", "0", "0", "0", "0", "0", "0", "0" };
        }
        String texto = params[0];
        
        int qtdLetras = 0;
        int qtdVogal = 0;
        int qtdVogalAcentuada = 0;
        int qtdConsoantes = 0;
        int qtdEspacos = 0;
        int qtdDeLinhas = 1;
        
        String vogais = "aeiouAEIOU";
        String vogaisAcentuadas = "áéíóúâêôãõàÁÉÍÓÚÂÊÔÃÕÀ";
        String consoantes = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZçÇ";
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                qtdLetras++;
                if (vogais.indexOf(c) != -1) {
                    qtdVogal++;
                } else if (vogaisAcentuadas.indexOf(c) != -1) {
                    qtdVogalAcentuada++;
                } else if (consoantes.indexOf(c) != -1) {
                    qtdConsoantes++;
                }
            } else if (c == ' ') {
                qtdEspacos++;
            } else if (c == '\n') {
                qtdDeLinhas++;
            }
        }
        
        int qtdPalavras = 0;
        int qtdPalavrasPar = 0;
        int qtdPalavrasImpar = 0;
        
        String[] palavras = texto.split("\\s+");
        for (String p : palavras) {
            String palavraLimpa = p.replaceAll("[^a-zA-ZáéíóúâêôãõàÁÉÍÓÚÂÊÔÃÕÀçÇ]", "");
            if (palavraLimpa.length() > 0) {
                qtdPalavras++;
                if (palavraLimpa.length() % 2 == 0) {
                    qtdPalavrasPar++;
                } else {
                    qtdPalavrasImpar++;
                }
            }
        }
        
        return new String[]{
            String.valueOf(qtdLetras),
            String.valueOf(qtdPalavras),
            String.valueOf(qtdVogal),
            String.valueOf(qtdVogalAcentuada),
            String.valueOf(qtdConsoantes),
            String.valueOf(qtdEspacos),
            String.valueOf(qtdPalavrasPar),
            String.valueOf(qtdPalavrasImpar),
            String.valueOf(qtdDeLinhas)
        };
    }
}
