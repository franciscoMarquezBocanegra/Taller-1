/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.punto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Punto1 {
    
    public static int contarLineas(String filePath, String Linetype){
    Path file =Paths.get(filePath);
    int numberOfLines=0;
    
    Charset charset = Charset.forName("UTF-8");
    try(BufferedReader reader = Files.newBufferedReader(file, charset)){
    String line=null;
    while((line=reader.readLine()) != null) {
        numberOfLines+=1;
    
        }
    }catch(IOException x){
        System.err.format("IOException: %$%n", x);
    }
    
    return numberOfLines;
        }

}
