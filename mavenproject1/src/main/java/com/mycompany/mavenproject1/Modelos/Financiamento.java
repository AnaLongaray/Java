package com.mycompany.mavenproject1.Modelos;

public abstract class Financiamento {
    protected double valorImovel;
    protected int duracaoMeses;
    protected double taxaJurosAnual;

    public Financiamento(double valorImovel, int duracaoMeses, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.duracaoMeses = duracaoMeses;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Método abstrato que deve ser implementado por subclasses
    public abstract double calcularParcelaMensal();

    public void exibirDetalhesFinanciamento() {
        double parcela = calcularParcelaMensal();
        System.out.printf("Valor do imóvel: R$ %.2f\n", valorImovel);
        System.out.println("Duração: " + duracaoMeses + " meses");
        System.out.println("Taxa de juros anual: " + (taxaJurosAnual * 100) + "%");
        System.out.printf("Valor aproximado da parcela: R$ %.2f\n", parcela);
    }

    // Getters opcionais
    public double getValorImovel() {
        return valorImovel;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
}
