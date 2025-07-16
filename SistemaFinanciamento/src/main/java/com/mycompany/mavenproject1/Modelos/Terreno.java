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
 
public class Terreno extends Imovel {
    private double area;

    @JsonCreator 
    public Terreno(
        @JsonProperty("endereco") String endereco,
        @JsonProperty("preco") double preco,
        @JsonProperty("area") double area
    ) {
        super(endereco, preco);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        } else {
            System.out.println("Número da área é inválido!");
        }
   }
    @Override
    public void exibirDetalhes() {
        System.out.println("Terreno localizado em: " + getEndereco());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Área: " + area);
    }

    @Override
    public String toString() {
        return String.format("Endereço: %s | Preço: R$ %.2f | Área: %.2f m²", 
                              getEndereco(), getPreco(), area);
    }
 }