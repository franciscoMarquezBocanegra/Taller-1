/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.punto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class punto2 {
    public static void main(String[] args) {
        String nombreArchivo = "ruta/al/archivo.java";
        int contadorLineas = contarLineas(nombreArchivo);
        System.out.println("El archivo " + nombreArchivo + " tiene " + contadorLineas + " líneas de código.");
    }

    public static int contarLineas(String nombreArchivo) {
        int contador = 0;
        boolean enBloqueComentario = false;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    if (!enBloqueComentario && !linea.startsWith("//") && !linea.matches("/\\*.*\\*/.*")) {
                        contador++;
                    }
                    if (linea.startsWith("/*") && !linea.endsWith("*/")) {
                        enBloqueComentario = true;
                    } else if (linea.endsWith("*/")) {
                        enBloqueComentario = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }
}