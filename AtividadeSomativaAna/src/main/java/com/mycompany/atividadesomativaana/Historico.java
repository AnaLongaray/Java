/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */
import java.util.Stack;

public class Historico {
    private Stack<String> pilha;

    public Historico() {
        pilha = new Stack<>();
    }

    public void visualizarLivro(String titulo) {
        pilha.push(titulo);
        System.out.println("Visualizado: " + titulo);
    }
    
    
    public void mostrarHistorico() {
        if (pilha.isEmpty()) {
            System.out.println("Histórico vazio.");
        } else {
            System.out.println("Histórico de navegação:");
            for (int i = pilha.size() - 1; i >= 0; i--) {
                System.out.println(pilha.get(i));
            }
        }
    }
    public int tamanho() {
    return pilha.size();
    }

    public String get(int index) {
    return pilha.get(index);
    }
    public String ultimoVisualizado() {
    if (pilha.isEmpty()) {
        return null;
    }
    return pilha.peek(); // retorna o topo sem remover
    }
    
    public void voltar() {
        if (!pilha.isEmpty()) {
            pilha.pop();
            System.out.println("Voltou uma navegação.");
        }
    }
}

