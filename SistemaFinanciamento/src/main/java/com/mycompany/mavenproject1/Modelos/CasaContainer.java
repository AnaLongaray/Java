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

public class CasaContainer {
    public List<Casa> imoveis;

    public CasaContainer() {
    }

    public CasaContainer(List<Casa> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Casa> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Casa> imoveis) {
        this.imoveis = imoveis;
    }
}