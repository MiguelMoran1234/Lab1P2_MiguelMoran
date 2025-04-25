/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_miguelmoran;

import java.util.Scanner;
import java.util.Random;

public class Lab1P2_MiguelMoran {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir) {
            System.out.println("-----Menu Principal-----");
            System.out.println("1. Jugar Numberly");
            System.out.println("2. Verificar Palindromo");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1 -> {
                    System.out.println("---Seleccion de Dificultad---");
                    System.out.println("1. Facil (Intentos 8, Longitud 3, Rango 1-6)");
                    System.out.println("2. Medio (Intentos 6 Longitud 4, Rango 1-8)");
                    System.out.println("3. Dificil (Intentos 5, Longitud 5, Rango 1-9)");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextInt();
                    System.out.println("");
                    System.out.println(Numberly(opcion));
                }
                case 2 -> {
                    System.out.print("Ingrese una palabra o frase: ");
                    sc.nextLine();
                    String palabra = sc.nextLine();
                    String string = "";
                    string = Recursivo(palabra, string, palabra.length() - 1);
                    palabra = palabra.replace(" ", "");
                    if (string.equalsIgnoreCase(palabra)) {
                        System.out.println("La palabra/frase es un palindromo.");
                    } else {
                        System.out.println("La palabra/frase no es un palindromo.");
                    }
                    System.out.println("");
                }
                case 3 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Opcion ingresada no valida.");
                    System.out.println("");
                }
            }
        }
    }

    public static String Numberly(int dificultad) {
        String historial = "";
        historial += "Historial:\n";
        Random rng = new Random();
        switch (dificultad) {
            case 1 -> {
                String numero = "";
                for (int i = 0; i < 3; i++) {
                    int digito = 1 + rng.nextInt(6);
                    numero += Integer.toString(digito);
                }
                for (int i = 0; i < 8; i++) {
                    System.out.print("Intento #" + (i + 1) + ": ");
                    String guess = sc.next();
                    if (NumeroValido(guess, 3, 6)) {
                        String string = "";
                        for (int j = 0; j < guess.length(); j++) {
                            if (guess.charAt(j) == numero.charAt(j)) {
                                string += "+";
                            } else if (numero.contains(Character.toString(guess.charAt(j)))) {
                                string += "-";
                            } else {
                                string += "x";
                            }
                        }
                        System.out.println("Resultado: " + string);
                        historial += guess + " ? " + string + "\n";
                        if (guess.equals(numero)) {
                            System.out.println("Ha acertado el numero era: " + numero);
                            break;
                        } else if (!guess.equals(numero) && i == 7){
                            System.out.println("No ha acertado el nuero era: " + numero);
                        }
                    } else {
                        System.out.println("Guess no valido.");
                        i -= 1;
                    }
                }
                System.out.println("");
            }
            case 2 -> {
                String numero = "";
                for (int i = 0; i < 4; i++) {
                    int digito = 1 + rng.nextInt(8);
                    numero += Integer.toString(digito);
                }
                for (int i = 0; i < 6; i++) {
                    System.out.print("Intento #" + (i + 1) + ": ");
                    String guess = sc.next();
                    if (NumeroValido(guess, 4, 8)) {
                        String string = "";
                        for (int j = 0; j < guess.length(); j++) {
                            if (guess.charAt(j) == numero.charAt(j)) {
                                string += "+";
                            } else if (numero.contains(Character.toString(guess.charAt(j)))) {
                                string += "-";
                            } else {
                                string += "x";
                            }
                        }
                        System.out.println("Resultado: " + string);
                        historial += guess + " ? " + string + "\n";
                        if (guess.equals(numero)) {
                            System.out.println("Ha acertado el numero era: " + numero);
                            break;
                        } else if (!guess.equals(numero) && i == 5){
                            System.out.println("No ha acertado el nuero era: " + numero);
                        }
                    } else {
                        System.out.println("Guess no valido.");
                        i -= 1;
                    }
                }
                System.out.println("");
            }
            case 3 -> {
                String numero = "";
                for (int i = 0; i < 5; i++) {
                    int digito = 1 + rng.nextInt(9);
                    numero += Integer.toString(digito);
                }
                for (int i = 0; i < 5; i++) {
                    System.out.print("Intento #" + (i + 1) + ": ");
                    String guess = sc.next();
                    if (NumeroValido(guess, 5, 9)) {
                        String string = "";
                        for (int j = 0; j < guess.length(); j++) {
                            if (guess.charAt(j) == numero.charAt(j)) {
                                string += "+";
                            } else if (numero.contains(Character.toString(guess.charAt(j)))) {
                                string += "-";
                            } else {
                                string += "x";
                            }
                        }
                        System.out.println("Resultado: " + string);
                        historial += guess + " ? " + string + "\n";
                        if (guess.equals(numero)) {
                            System.out.println("Ha acertado el numero era: " + numero);
                            break;
                        } else if (!guess.equals(numero) && i == 4){
                            System.out.println("No ha acertado el nuero era: " + numero);
                        }
                    } else {
                        System.out.println("Guess no valido.");
                        i -= 1;
                    }
                }
                System.out.println("");
            }
            default -> {
                System.out.println("Opcion ingresada no valida");
                System.out.println("");
            }
        }
        return historial;
    }

    public static String Recursivo(String palabra, String string, int posicion) {
        if(posicion > -1){
            if(palabra.charAt(posicion) != ' '){
                string += palabra.charAt(posicion);
            }
            return Recursivo (palabra, string, posicion - 1);
        } else {
            return string;
        }
    }

    public static boolean NumeroValido(String string, int size, int range) {
        boolean valido = true;
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if (ascii < 49 || ascii > 48 + range) {
                valido = false;
            }
        }
        if (string.length() != size) {
            valido = false;
        }
        return valido;
    }
}
