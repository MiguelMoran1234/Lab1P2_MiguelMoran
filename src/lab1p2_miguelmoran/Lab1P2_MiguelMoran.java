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
            switch (opcion) {
                case 1 -> {
                    System.out.println("---Seleccion de Dificultad---");
                    System.out.println("1. Facil (Intentos 8, Longitud 3, Rango 1-6)");
                    System.out.println("2. Medio (Intentos 6 Longitud 4, Rango 1-8)");
                    System.out.println("3. Medio (Intentos 5, Longitud 5, Rango 1-9)");
                    System.out.print("Ingrese una opcion: ");
                    opcion = sc.nextInt();
                    Numberly(opcion);
                }
            }
        }
    }

    public static String Numberly(int dificultad) {
        String historial = "";
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
                    if (Numero(guess) && guess.length() == 3) {
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
                        historial += guess + " ? " + string + "\n";
                    } else {
                        System.out.println("El texto ingresado no es un numero o su longitud es mayor a la maxima.");
                        i -= 1;
                    }
                }
            }
            case 2 -> {
                String numero = "";
                for (int i = 0; i < 3; i++) {
                    int digito = 1 + rng.nextInt(8);
                    numero += Integer.toString(digito);
                }
                for (int i = 0; i < 8; i++) {
                    System.out.print("Intento #" + (i + 1) + ": ");
                    String guess = sc.next();
                    if (Numero(guess) && guess.length() == 4) {
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
                        historial += guess + " ? " + string + "\n";
                    } else {
                        System.out.println("El texto ingresado no es un numero o su longitud es mayor a la maxima.");
                        i -= 1;
                    }
                }
            }
            case 3 -> {
                String numero = "";
                for (int i = 0; i < 3; i++) {
                    int digito = 1 + rng.nextInt(9);
                    numero += Integer.toString(digito);
                }
                for (int i = 0; i < 8; i++) {
                    System.out.print("Intento #" + (i + 1) + ": ");
                    String guess = sc.next();
                    if (Numero(guess) && guess.length() == 5) {
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
                        historial += guess + " ? " + string + "\n";
                    } else {
                        System.out.println("El texto ingresado no es un numero o su longitud es mayor a la maxima.");
                        i -= 1;
                    }
                }
            }
            default -> {
                System.out.println("Opcion ingresada no valida");
            }
        }
        return historial;
    }

    public static boolean Numero(String string) {
        boolean valido = true;
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if (ascii < 48 || ascii > 57) {
                valido = false;
            }
        }
        return valido;
    }
}
