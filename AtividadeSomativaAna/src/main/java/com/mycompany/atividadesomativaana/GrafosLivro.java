/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */
import java.util.*;

public class GrafosLivro {

    private HashMap<Livro, Set<Livro>> grafo;

    public GrafosLivro() {
        grafo = new HashMap<>();
    }

    // Adicionar livro ao grafo
    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>());
    }

    // Criar recomendação (ligação)
    public void adicionarRecomendacao(Livro livro, Livro recomendado) {
        grafo.get(livro).add(recomendado);
    }

    // Mostrar recomendações
    public void mostrarRecomendacoes(Livro livro) {
        Set<Livro> recomendados = grafo.get(livro);

        if (recomendados == null || recomendados.isEmpty()) {
            System.out.println("Sem recomendações para este livro.");
            return;
        }

        System.out.println("Se você gostou de: " + livro);
        System.out.println("Você também pode gostar de:");

        for (Livro l : recomendados) {
            System.out.println("- " + l);
        }
    }
    public void gerarRecomendacoesPorAutor(List<Livro> livros) {
        for (Livro l1 : livros) {
            for (Livro l2 : livros) {
                if (!l1.equals(l2) && l1.autor.equalsIgnoreCase(l2.autor)) {
                adicionarRecomendacao(l1, l2);
                }
            }
        }
}
    public void completarRecomendacoes(List<Livro> livros) {
    Random rand = new Random();

    for (Livro livro : livros) {
        Set<Livro> recomendados = grafo.get(livro);

        if (recomendados == null) {
            recomendados = new HashSet<>();
            grafo.put(livro, recomendados);
        }

        while (recomendados.size() < 2) {
            Livro aleatorio = livros.get(rand.nextInt(livros.size()));

            if (!aleatorio.equals(livro)) {
                recomendados.add(aleatorio);
            }
        }
    }
}
    // Sistema simples de sugestão
    public void sugerirComBaseNoHistorico(List<Livro> historico) {
        Set<Livro> sugestoes = new HashSet<>();

        for (Livro livro : historico) {
            Set<Livro> recs = grafo.get(livro);
            if (recs != null) {
                sugestoes.addAll(recs);
            }
        }

        System.out.println("\nSugestões para você:");

        for (Livro l : sugestoes) {
            System.out.println("- " + l);
        }
    }
    
    public Map<Livro, Integer> dijkstraSimples(Livro origem) {

    Map<Livro, Integer> distancias = new HashMap<>();
    Queue<Livro> fila = new LinkedList<>();

    distancias.put(origem, 0);
    fila.add(origem);

    while (!fila.isEmpty()) {
        Livro atual = fila.poll();
        int distanciaAtual = distancias.get(atual);

        for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {

            if (!distancias.containsKey(vizinho)) {
                distancias.put(vizinho, distanciaAtual + 1);
                fila.add(vizinho);
            }
        }
    }

    return distancias;
    }
    
    public void recomendarPorDistancia(Livro origem) {

    Map<Livro, Integer> distancias = dijkstraSimples(origem);

    System.out.println("\nRecomendações baseadas em distância para: " + origem);

    distancias.entrySet().stream()
        .filter(e -> !e.getKey().equals(origem))
        .sorted(Map.Entry.comparingByValue())
        .limit(5)
        .forEach(e -> {
            System.out.println("- " + e.getKey() + " | distância: " + e.getValue());
        });
    }
    
    
}