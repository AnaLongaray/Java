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


public class TerrenoContainer {
    public List<Terreno> imoveis;

    public TerrenoContainer() {
    }

    public TerrenoContainer(List<Terreno> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Terreno> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Terreno> imoveis) {
        this.imoveis = imoveis;
    }
}