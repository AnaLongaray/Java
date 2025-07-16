/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Modelos;

/**
 *
 * @author anadl
 */
import java.util.List;

public class ApartamentoContainer {
    public List<Apartamento> imoveis;

    public ApartamentoContainer() {
    }

    public ApartamentoContainer(List<Apartamento> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Apartamento> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Apartamento> imoveis) {
        this.imoveis = imoveis;
    }
}