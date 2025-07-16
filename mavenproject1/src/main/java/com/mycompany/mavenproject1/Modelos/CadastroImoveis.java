/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Modelos;

/**
 *
 * @author anadl
 */

import java.util.ArrayList;
import java.util.List;

public class CadastroImoveis {
    private List<Imovel> imoveis = new ArrayList<>();

    public void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    public <T extends Imovel> List<T> listarImoveisPorTipo(Class<T> tipo) {
        List<T> imoveisDoTipo = new ArrayList<>();
        for (Imovel imovel : this.imoveis) {
            if (tipo.isInstance(imovel)) {
                imoveisDoTipo.add(tipo.cast(imovel));
            }
        }
        return imoveisDoTipo;
    }

    public List<Imovel> getImoveis() {
        return this.imoveis;
    }
}