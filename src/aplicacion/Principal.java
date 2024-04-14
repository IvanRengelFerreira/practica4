package aplicacion;
import java.util.Scanner;

import dominio.CalculadoraDeDistacias;

public class Principal{

   //En principal damos entrada a dos palabras y salida a la distancia minima de edicion
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese una palabra: ");
    String palabra1 = sc.nextLine();
    
    System.out.println("Ingrese otra palabra: ");
    String palabra2 = sc.nextLine();

    System.out.println("La distancia minima de edicion es  " +CalculadoraDeDistacias.CalculadoradeDistacias(palabra1, palabra2));
    }
}