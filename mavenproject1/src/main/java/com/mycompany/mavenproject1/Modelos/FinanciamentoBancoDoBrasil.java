package com.mycompany.mavenproject1.Modelos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FinanciamentoBancoDoBrasil extends Financiamento {
    private static final double TAXA_JUROS_ANUAL = 0.12; // 12% ao ano

    @JsonCreator
    public FinanciamentoBancoDoBrasil(
        @JsonProperty("preco") double preco,
        @JsonProperty("duracaoMeses") int duracaoMeses
    ) {
        super(preco, duracaoMeses, TAXA_JUROS_ANUAL);
    }

    @Override
    public double calcularParcelaMensal() {
        double taxaMensal = Math.pow(1 + taxaJurosAnual, 1.0 / 12) - 1;
        return (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -duracaoMeses));
    }

    @Override
    public String toString() {
        return String.format("Valor Total: R$ %.2f | Duração: %d meses | Prestação Mensal: R$ %.2f",
                valorImovel, duracaoMeses, calcularParcelaMensal());
    }
}
