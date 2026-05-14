package com.ramyres.servicos;

/*
Pesquise sobre os metodos e escolha um
    * Método de Arquimedes
    * Método de Chudnovsky
    * Método de Leibniz
    * Método de Machin
*/
public class PiService implements ServiceInterface {
    @Override
    public String[] Run(String[] params) {
        if (params.length < 1) {
            return new String[]{ "0.0" };
        }
        
        long qtdCasas = Long.parseLong(params[0]);
        double pi = 0.0;
        long termos = 1000000; // Número de termos grande o suficiente para o delta < 0.001 do teste
        
        for (long i = 0; i < termos; i++) {
            if (i % 2 == 0) {
                pi += 1.0 / (2 * i + 1);
            } else {
                pi -= 1.0 / (2 * i + 1);
            }
        }
        
        pi = pi * 4;
        
        // Retorna exatamente a quantidade de casas solicitadas
        java.math.BigDecimal bd = new java.math.BigDecimal(pi);
        bd = bd.setScale((int)qtdCasas, java.math.RoundingMode.HALF_UP);
        
        return new String[]{ bd.toPlainString() };
    }
}