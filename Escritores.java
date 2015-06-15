import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class Escritores {

	private int cantidadEscritores = 0;
	private int cantidadLibros = 0;

	private Libro[] librosRedactar;

	private String nombreArSalida, salidaTexto;



	public static void main(String argEntrada[]){// la manera de usarlo es java Escritores entrada.txt lo cuales es que recive el nombre de en argEntrada

		if(argEntrada.length == 0){
			System.out.println("No puede ser vacio");
			System.exit(0);
		}

		if(argEntrada.length > 1){
			System.out.println("Muchos argumentos");
			System.exit(0);
		}

		String nombreArchivo = argEntrada[0];

		//System.out.println(nombreArchivo);

		Escritores arrancar = new Escritores();	

		arrancar.leerArchivo(nombreArchivo);

		arrancar.ingenua();
		arrancar.dinamica();
		arrancar.avara();
	}

	public void leerArchivo(String nEntrada){ //aqu´i le paso el nombre que recibi como parametro
			try (BufferedReader bufersito = new BufferedReader(new FileReader(nEntrada))){
 
				String sCurrentLine;//String Linea Actual
				int largoLinea;

				String primeraLinea = bufersito.readLine();
				String[] partesPrimeraLinea = primeraLinea.split(" ");

				cantidadEscritores = Integer.parseInt(partesPrimeraLinea[0]);
				cantidadLibros = Integer.parseInt(partesPrimeraLinea[1]);

				librosRedactar = new Libro[cantidadLibros];

				for (int i=0; i<cantidadLibros; i++) {
					sCurrentLine = bufersito.readLine();

					Libro libroTmp = new Libro();
					String[] partesLines = sCurrentLine.split(" ");
					libroTmp.setNombre(partesLines[0]);
					libroTmp.setPaginas(Integer.parseInt(partesLines[1]));
					librosRedactar[i] = libroTmp;

				}

				/*
	 
				while ((sCurrentLine = bufercito.readLine()) != null) {
					System.out.println(sCurrentLine);
					largoLinea = sCurrentLine.length();

					//System.out.println(largoLinea);
				}*/
 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

	public void ingenua(){
		nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de ingenua ");
		EscribirTxt resultado = new EscribirTxt();

		// Inicio Algoritmo


		//Fin Algoritmo


		//Esta parte es la que escribe el txt
		resultado.setCampoSalida(salidaTexto);
		resultado.escribirArchivo(nombreArSalida);

	}

	public void avara(){
		nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de Avara ");
		EscribirTxt resultado = new EscribirTxt();

		// Inicio Algoritmo


		//Fin Algoritmo


		//Esta parte es la que escribe el txt
		resultado.setCampoSalida(salidaTexto);
		resultado.escribirArchivo(nombreArSalida);

	}

	public void dinamica(){
		nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de Dinamica ");
		EscribirTxt resultado = new EscribirTxt();

		// Inicio Algoritmo


		//Fin Algoritmo


		//Esta parte es la que escribe el txt
		resultado.setCampoSalida(salidaTexto);
		resultado.escribirArchivo(nombreArSalida);

	}

	public void respuestaMuchosEscritores(){nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de muchosEscritores ");
		EscribirTxt resultado = new EscribirTxt();

		// Inicio Algoritmo


		//Fin Algoritmo


		//Esta parte es la que escribe el txt
		resultado.setCampoSalida(salidaTexto);
		resultado.escribirArchivo(nombreArSalida);

	}

}