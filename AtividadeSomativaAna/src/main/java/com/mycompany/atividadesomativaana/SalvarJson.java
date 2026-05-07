/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */

import com.google.gson.Gson;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SalvarJson {

    // SALVAR 
    public static void salvarLivros(List<Livro> livros) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("livros.json")) {
            gson.toJson(livros, writer);
            System.out.println("Livros salvos em JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CARREGAR 
    public static List<Livro> carregarLivros() {
        Gson gson = new Gson();

        // pega 
        try (InputStream is = SalvarJson.class.getClassLoader().getResourceAsStream("livros.json")) {
            if (is == null) {
                System.out.println("Arquivo livros.json não encontrado em resources!");
                return new ArrayList<>();
            }

            InputStreamReader reader = new InputStreamReader(is);
            Livro[] livrosArray = gson.fromJson(reader, Livro[].class);
            return Arrays.asList(livrosArray);

        } catch (IOException e) {
            System.out.println("Erro ao ler livros.json");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}