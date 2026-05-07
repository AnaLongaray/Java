/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */
public class Biblioteca {
    private Livro inicio;

    public void adicionar(String titulo, String autor, int ano) {
        Livro novoLivro = new Livro(titulo, autor, ano);

        if (inicio == null) {
            inicio = novoLivro;
        } else {
            Livro atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoLivro;
        }
    }

    public void mostrarTodos() {
        Livro atual = inicio;

        if (atual == null) {
            System.out.println("A biblioteca está vazia.");
            return;
        }

        while (atual != null) {
            System.out.println("Título: " + atual.titulo +
                    " | Autor: " + atual.autor +
                    " (" + atual.anoPublicacao + ")");
            atual = atual.proximo;
        }
    }

    // Buscar livro 
    public Livro buscar(String titulo) {
        Livro atual = inicio;

        while (atual != null) {
            if (atual.titulo.equalsIgnoreCase(titulo)) {
                return atual;
            }
            atual = atual.proximo;
        }

        return null;
    }
}