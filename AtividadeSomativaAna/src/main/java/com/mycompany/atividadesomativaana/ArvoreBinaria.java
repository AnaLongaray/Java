/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */

import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinaria {

    class No {
        Livro livro;
        No esquerda;
        No direita;

        public No(Livro livro) {
            this.livro = livro;
        }
    }

    private No raiz;

    // INSERIR
    public void inserir(Livro livro) {
        raiz = inserirRec(raiz, livro);
    }

    private No inserirRec(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }

        if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) < 0) {
            atual.esquerda = inserirRec(atual.esquerda, livro);
        } else if (livro.titulo.compareToIgnoreCase(atual.livro.titulo) > 0) {
            atual.direita = inserirRec(atual.direita, livro);
        }

        return atual;
    }

    // BUSCAR
    public Livro buscar(String titulo) {
        return buscarRec(raiz, titulo);
    }

    private Livro buscarRec(No atual, String titulo) {
        if (atual == null) return null;

        if (titulo.equalsIgnoreCase(atual.livro.titulo)) {
            return atual.livro;
        }

        if (titulo.compareToIgnoreCase(atual.livro.titulo) < 0) {
            return buscarRec(atual.esquerda, titulo);
        } else {
            return buscarRec(atual.direita, titulo);
        }
    }
    // Busca profundidade 
    public void buscarDFS(String titulo) {
        System.out.println("\nBusca DFS:");

        if (!dfsRec(raiz, titulo)) {
            System.out.println("Livro não encontrado.");
        }
    }
    
    private boolean dfsRec(No atual, String titulo) {
        if (atual == null) return false;

        // mostra o caminho
        System.out.println("Visitando: " + atual.livro);

        if (atual.livro.titulo.equalsIgnoreCase(titulo)) {
            System.out.println("Encontrado!");
            return true;
        }

        // esquerda  direita (profundidade)
        return dfsRec(atual.esquerda, titulo) ||
            dfsRec(atual.direita, titulo);
    }
    
    //Buscar BFS
    public void buscarBFS(String titulo) {
        System.out.println("\nBusca BFS:");

        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            System.out.println("Visitando: " + atual.livro);

            if (atual.livro.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado!");
                return;
            }

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }

        System.out.println("Livro não encontrado.");
    }   
    
    // EM ORDEM (ordenado)
    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No atual) {
        if (atual != null) {
            emOrdemRec(atual.esquerda);
            System.out.println(atual.livro);
            emOrdemRec(atual.direita);
        }
    }
}