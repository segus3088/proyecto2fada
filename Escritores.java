import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Escritores {



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
	}

	public void leerArchivo(String nEntrada){ //aqu´i le paso el nombre que recibi como parametro
			try (BufferedReader bufercito = new BufferedReader(new FileReader(nEntrada))){
 
				String sCurrentLine;//String Linea Actual
				int largoLinea;
	 
				while ((sCurrentLine = bufercito.readLine()) != null) {
					System.out.println(sCurrentLine);
					largoLinea = sCurrentLine.length();

					System.out.println(largoLinea);
				}
 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

}