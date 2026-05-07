/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadesomativaana;

/**
 *
 * @author anadl
 */
public class BubbleSort {
    public static long comparacoes = 0;

    public static String[] ordenar(String[] oldArr) {

        comparacoes = 0;

        String[] arr = oldArr.clone();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                comparacoes++;

                if (arr[j].compareTo(arr[j + 1]) > 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
