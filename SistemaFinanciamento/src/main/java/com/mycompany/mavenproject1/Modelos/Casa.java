/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Modelos;

/**
 *
 * @author anadl
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
 
public class Casa extends Imovel {
    private int numQuartos;

    @JsonCreator 
    public Casa(
        @JsonProperty("endereco") String endereco,
        @JsonProperty("preco") double preco,
        @JsonProperty("numQuartos") int numQuartos
    ) {
        super(endereco, preco);
        this.numQuartos = numQuartos;
    }

    public int getNumQuartos() {
        return numQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        if (numQuartos > 0) {
            this.numQuartos = numQuartos;
        } else {
            System.out.println("Número de quartos inválido!");
        }
   }
    @Override
    public void exibirDetalhes() {
        System.out.println("Casa localizada em: " + getEndereco());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Número de Quartos: " + numQuartos);
    }
    
    @Override
    public String toString() {
    return String.format("Endereço: %s | Preço: R$ %.2f | Quartos: %d", 
                          getEndereco(), getPreco(), numQuartos);
    }
 }