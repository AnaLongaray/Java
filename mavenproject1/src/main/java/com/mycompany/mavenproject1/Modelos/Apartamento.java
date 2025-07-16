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
 
public class Apartamento extends Imovel {
    private int andar;

    @JsonCreator 
    public Apartamento(
        @JsonProperty("endereco") String endereco,
        @JsonProperty("preco") double preco,
        @JsonProperty("andar") int andar
    ) {
        super(endereco, preco);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        if (andar > 0) {
            this.andar = andar;
        } else {
            System.out.println("Número de quartos inválido!");
        }
   }
    @Override
    public void exibirDetalhes() {
        System.out.println("Apartamento localizado em: " + getEndereco());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Andar: " + andar);
    }
    
    @Override
    public String toString() {
        return String.format("Endereço: %s | Preço: R$ %.2f | Andar: %d", 
            getEndereco(), getPreco(), andar);
    }
 }