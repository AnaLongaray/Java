/*
 * Relembrando: o uso de Java e LinkedList é obrigatório neste projeto, pois são ferramentas fundamentais que ajudarão a construir uma base sólida para os desafios futuros no desenvolvimento de software.
 */

package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */

import java.util.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) {
        try {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        }
        
        Scanner sc = new Scanner(System.in);

        GrafosLivro grafo = new GrafosLivro();
        Biblioteca biblioteca = new Biblioteca();
        Historico historico = new Historico();

        // Carregar livros
        List<Livro> listaLivros = SalvarJson.carregarLivros();

        if (listaLivros == null || listaLivros.isEmpty()) {
            System.out.println("Nenhum livro encontrado no JSON.");
            return;
        }

        // Cria a árvore
        ArvoreBinaria arvore = new ArvoreBinaria();

        // insere os livros na árvore
        for (Livro l : listaLivros) {
        biblioteca.adicionar(l.titulo, l.autor, l.anoPublicacao);
        grafo.adicionarLivro(l);
        arvore.inserir(l);
        }
        
        // Teste de Ordenação
        String[] nomes = GeradorDeNomesDeLivros.gerarNomes(10000);

        // Bubble
        long inicioBubble = System.currentTimeMillis();
        BubbleSort.ordenar(nomes);
        long tempoBubble = System.currentTimeMillis() - inicioBubble;

        // Merge
        long inicioMerge = System.currentTimeMillis();
        MergeSort.ordenar(nomes);
        long tempoMerge = System.currentTimeMillis() - inicioMerge;

        // Resultados
        System.out.println("\n=== COMPARAÇÃO DE ALGORITMOS ===");

        System.out.println("Bubble Sort:");
        System.out.println("Comparações: " + BubbleSort.comparacoes);
        System.out.println("Tempo: " + tempoBubble + " ms");

        System.out.println("\nMerge Sort:");
        System.out.println("Comparações: " + MergeSort.comparacoes);
        System.out.println("Tempo: " + tempoMerge + " ms");

        // Popular grafo
        for (Livro l : listaLivros) {
            grafo.adicionarLivro(l);
        }

        grafo.gerarRecomendacoesPorAutor(listaLivros);
        grafo.completarRecomendacoes(listaLivros);

        int opcao;

        do {
            System.out.println("\n=== MENU ===");

            // Último livro
            String ultimo = historico.ultimoVisualizado();
            if (ultimo != null) {
                System.out.println("Último livro visto: " + ultimo);
            } else {
                System.out.println("Nenhum livro visualizado ainda.");
            }

            System.out.println("1 - Ver livros (títulos)");
            System.out.println("2 - Ver detalhes do livro");
            System.out.println("3 - Ver recomendações (baseado no histórico)");
            System.out.println("4 - Ver histórico");
            System.out.println("5 - Recomendações por distância (Dijkstra)");
            System.out.println("6 - Mostrar livros em ordem (árvore)");
            System.out.println("7 - Buscar livro na árvore");
            System.out.println("8 - Buscar livro (DFS e BFS)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                // Só títulos
                case 1: {
                    System.out.println("\nLista de livros:");
                    for (Livro l : listaLivros) {
                        System.out.println("- " + l.titulo);
                    }
                    break;
                }

                // Detalhes + salvar histórico
                case 2: {
                    System.out.print("Digite o título do livro: ");
                    String titulo = sc.nextLine();

                    Livro livro = biblioteca.buscar(titulo);

                    if (livro != null) {
                        System.out.println("\n📚 Detalhes do livro:");
                        System.out.println("Título: " + livro.titulo);
                        System.out.println("Autor: " + livro.autor);
                        System.out.println("Ano: " + livro.anoPublicacao);

                        // salvar histórico
                        historico.visualizarLivro(livro.titulo);

                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                }

                // Recomendações baseadas no histórico
                case 3: {

                    List<Livro> historicoLivros = new ArrayList<>();

                    // converter String -> Livro
                    for (int i = 0; i < historico.tamanho(); i++) {
                        String tituloHist = historico.get(i);
                        Livro l = biblioteca.buscar(tituloHist);

                        if (l != null) {
                            historicoLivros.add(l);
                        }
                    }

                    if (historicoLivros.isEmpty()) {
                        System.out.println("Nenhum histórico para gerar recomendações.");
                    } else {
                        grafo.sugerirComBaseNoHistorico(historicoLivros);
                    }

                    break;
                }

                // Histórico
                case 4: {
                    historico.mostrarHistorico();
                    break;
                }

                case 0: {
                    System.out.println("Saindo...");
                    break;
                }

                default:
                    System.out.println("Opção inválida!");
                    
               // Recomendação
                case 5: {
                    System.out.print("Digite o título do livro base: ");
                    String tituloBase = sc.nextLine();

                    Livro livroBase = biblioteca.buscar(tituloBase);

                    if (livroBase != null) {
                        grafo.recomendarPorDistancia(livroBase);
                    } else {
                    System.out.println("Livro não encontrado.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("\nLivros em ordem (árvore binária):");
                    arvore.emOrdem();
                    break;
                }
                    
                case 7: {
                    System.out.print("Digite o título: ");
                    String busca = sc.nextLine();

                    Livro resultado = arvore.buscar(busca);

                    if (resultado != null) {
                        System.out.println("Encontrado: " + resultado);
                        historico.visualizarLivro(resultado.titulo);
                    } else {
                    System.out.println("Livro não encontrado.");
                    }
                    break;
                }
                
                case 8: {
                    System.out.print("Digite o título do livro: ");
                    String busca = sc.nextLine();

                    arvore.buscarDFS(busca);
                    // pega o livro encontrado
                    Livro resultado = biblioteca.buscar(busca);

                    if (resultado != null) {
                        System.out.println("\n📚 Detalhes do livro:");
                        System.out.println("Título: " + resultado.titulo);
                        System.out.println("Autor: " + resultado.autor);
                        System.out.println("Ano: " + resultado.anoPublicacao);
                    
                        historico.visualizarLivro(resultado.titulo);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    
                    break;
                }
            }

        } while (opcao != 0);

        sc.close();
    }
}
