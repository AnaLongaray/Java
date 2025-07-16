package com.mycompany.mavenproject1.Modelos;

public class FinanciamentoPadrao extends Financiamento {

    public FinanciamentoPadrao(double valorImovel, int duracaoMeses, double taxaJurosAnual) {
        super(valorImovel, duracaoMeses, taxaJurosAnual);
    }

    @Override
    public double calcularParcelaMensal() {
        double taxaMensal = (taxaJurosAnual / 100) / 12;
        return (valorImovel * taxaMensal) /
               (1 - Math.pow(1 + taxaMensal, -duracaoMeses));
    }
}
