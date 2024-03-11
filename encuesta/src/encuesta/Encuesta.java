/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encuesta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Elena Guijarro
 * @nick guirod
 * @email elenaguiro@gmail.com
 * @creationDate 6 mar 2024 - 17:50:03
 *
 */
public class Encuesta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Variables
        FileWriter encuesta;
        PrintWriter pw;
        String cadena;
        String consumir = "";
        String frecuencia = "";
        String cuanto = "";
        int respConsumir;
        int respFrecuencia;
        int respCuanto;
        try {
            // Creamos el archivo
            encuesta = new FileWriter("encuesta.txt", true);
            BufferedWriter bw = new BufferedWriter(encuesta);
            pw = new PrintWriter(bw);
            // Creamos el bucle que generará aleatoriamente 100 respuestas a las preguntas
            for (int i = 1; i < 101; i++) {
                // Genero números aleatorios para responder cada pregunta
                Random r = new Random();
                // Para si consume alcohol o no
                respConsumir = r.nextInt(3) + 1;  // Entre 0 y 3 excluido, más 1, es decir, del 1 al 3 ambos incluidos.
                switch (respConsumir) {
                    case 1 ->
                        consumir = "Sí.";
                    case 2 ->
                        consumir = "No, nunca.";
                    case 3 ->
                        consumir = "No, pero he consumido en algún momento.";
                }
                // Para la frecuencia de consumo
                respFrecuencia = r.nextInt(4) + 1;  // Entre 0 y 4 excluido, más 1, es decir, del 1 al 4 ambos incluidos.
                switch (respFrecuencia) {
                    case 1 ->
                        frecuencia = "Nunca.";
                    case 2 ->
                        frecuencia = "En ocasiones.";
                    case 3 ->
                        frecuencia = "Los fines de semana.";
                    case 4 ->
                        frecuencia = "A diario.";
                }
                // Para la frecuencia de consumo
                respCuanto = r.nextInt(3) + 1;  // Entre 0 y 3 excluido, más 1, es decir, del 1 al 3 ambos incluidos.
                switch (respCuanto) {
                    case 1 ->
                        cuanto = "Una o dos.";
                    case 2 ->
                        cuanto = "Tres o cuatro.";
                    case 3 ->
                        cuanto = "Cinco más.";
                }
                cadena = "Persona " + i + "\n"
                        + "a) ¿Consumes alcohol? " + consumir + "\n"
                        + "b) ¿Con qué frecuencia consumes una bebida \"alcohólica?\" " + frecuencia + "\n"
                        + "c) Cuando consumes alcohol ¿Cuántas consumicioneshaces al día? " + cuanto + "\n\n";
                pw.println(cadena);
            }
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }       
    }
}
