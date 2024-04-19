/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_miguelmoran;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author flash
 */
public class Lab1P2_MiguelMoran {

    static Scanner sc = new Scanner(System.in);
    static int[][] matriz = new int[0][0];
    static ArrayList<Integer> medianas = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Ingrese el tamaño de la matriz: ");
        int size = sc.nextInt();
        matriz = new int[size][size];
        Llenado();
        System.out.println("Matriz Generada:");
        Impresion();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                Ordenadomatriz(i, 0);
            }
        }
        System.out.println("");
        System.out.println("Matriz Ordenada:");
        Impresion();
        if(matriz.length % 2 == 1){
            for (int i = 0; i < matriz.length; i++) {
                medianas.add(matriz[i][matriz.length/2]);
            }
        } else {
            for (int i = 0; i < matriz.length; i++) {
                medianas.add((matriz[i][matriz.length/2] + matriz[i][(matriz.length/2)-1])/2); 
            }
        }
        System.out.println("");
        System.out.println("Arreglo de medianas:");
        for (int i = 0; i < medianas.size(); i++) {
            System.out.print("["+medianas.get(i)+"]");
        }
        Ordenadoarreglo(0);
        System.out.println("");
        System.out.println("");
        System.out.println("Arreglo de medianas ordenado:");
        for (int i = 0; i < medianas.size(); i++) {
            System.out.print("["+medianas.get(i)+"]");
        }
        int mediana = 0;
        if(matriz.length % 2 == 1){
                mediana = medianas.get(matriz.length/2);
        } else {
                mediana = (medianas.get(matriz.length/2) + medianas.get(matriz.length/2)-1)/2; 
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Mediana de las medianas: "+mediana);
    }

    public static void Llenado() {
        Random rng = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rng.nextInt(10);
            }
        }
    }

    public static void Impresion() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
    public static void Ordenadomatriz(int i, int j){
        int num1 = matriz[i][j];
        int num2 = matriz[i][j+1];
        if(num1 > num2){
            matriz[i][j] = num2;
            matriz[i][j+1] = num1;
        } 
        j+= 1;
        if(j < matriz.length - 1){
            Ordenadomatriz(i, j);
        }
    }
    
    public static void Ordenadoarreglo(int i){
        int num1 = medianas.get(i);
        int num2 = medianas.get(i+1);
        if(num1 > num2){
            medianas.set(i, num2);
            medianas.set(i+1, num1);
        } 
        i+= 1;
        if(i < medianas.size() - 1){
            Ordenadoarreglo(i);
                    
        }
    }
}
