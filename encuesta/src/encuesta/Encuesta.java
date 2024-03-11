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
        String cadena1, cadena2;
        String consumir = "";
        String frecuencia = "";
        String cuanto = "";
        int respConsumir;
        int respFrecuencia;
        int respCuanto;
        int contadorConsumirSi=0, contadorConsumirNo=0, contadorConsumirAlguna=0,
                contadorFrecuenciaNunca=0, contadorFrecuenciaOcasiones=0, contadorFrecuenciaFindes=0, contadorFrecuenciaDiario=0,
                contadorCuanto12=0, contadorCuanto34=0, contadorCuanto5=0;
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
                    case 1:
                        consumir = "Sí.";
                        contadorConsumirSi++;
                        break;
                    case 2:
                        consumir = "No, nunca.";
                        contadorConsumirNo++;
                        break;
                    case 3:
                        consumir = "No, pero he consumido en algún momento.";
                        contadorConsumirAlguna++;
                }
                // Para la frecuencia de consumo
                respFrecuencia = r.nextInt(4) + 1;  // Entre 0 y 4 excluido, más 1, es decir, del 1 al 4 ambos incluidos.
                switch (respFrecuencia) {
                    case 1:
                        frecuencia = "Nunca.";
                        contadorFrecuenciaNunca++;
                        break;
                    case 2:
                        frecuencia = "En ocasiones.";
                        contadorFrecuenciaOcasiones++;
                        break;
                    case 3:
                        frecuencia = "Los fines de semana.";
                        contadorFrecuenciaFindes++;
                        break;
                    case 4:
                        frecuencia = "A diario.";
                        contadorFrecuenciaDiario++;
                        break;
                }
                // Para la frecuencia de consumo
                respCuanto = r.nextInt(3) + 1;  // Entre 0 y 3 excluido, más 1, es decir, del 1 al 3 ambos incluidos.
                switch (respCuanto) {
                    case 1:
                        cuanto = "Una o dos.";
                        contadorCuanto12++;
                        break;
                    case 2:
                        cuanto = "Tres o cuatro.";
                        contadorCuanto34++;
                        break;
                    case 3:
                        cuanto = "Cinco más.";
                        contadorCuanto5++;
                        break;
                }
                cadena1 = "Persona " + i + "\n"
                        + "a) ¿Consumes alcohol? " + consumir + "\n"
                        + "b) ¿Con qué frecuencia consumes una bebida \"alcohólica?\" " + frecuencia + "\n"
                        + "c) Cuando consumes alcohol ¿Cuántas consumiciones haces al día? " + cuanto + "\n\n";
                pw.println(cadena1);
            }
            cadena2 = "TOTALES:\n"
                    + "Personas que consumen alcohol:\n"
                    + "Si: "+contadorConsumirSi+"\n"
                    + "No: "+contadorConsumirNo+"\n"
                    + "A veces: "+contadorConsumirAlguna+"\n"
                    + "Frecuencian de consumo:\n"
                    + "Nunca: "+contadorFrecuenciaNunca+"\n"
                    + "En ocasiones: "+contadorFrecuenciaOcasiones+"\n"
                    + "Findes: "+contadorFrecuenciaFindes+"\n"
                    + "A diario: "+contadorFrecuenciaDiario+"\n"
                    + "Consumiciones al días:\n"
                    + "Una o dos: "+contadorCuanto12+"\n"
                    + "Tres o cuatro: "+contadorCuanto34+"\n"
                    + "Cinco o más: "+contadorCuanto5+"\n\n";
            pw.println(cadena2);
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }       
    }
}
