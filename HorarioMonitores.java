import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class HorarioMonitores {


	private int tiempoDisponible = 0;
	private int cantidadMonitores = 0;
	private int[] respuestaTemporal;// este lo uso para guardar la posición de los proibles monnitreos que puede servir

	private Monitores[] monitoresTurnos;

	private String nombreArSalida, salidaTexto; // para almacenar el archivo de salida
	public static void main(String argEntrada[]){// la manera de usarlo es java HorarioMonitores entrada.txt lo cuales es que recibe el nombre en argEntrada

		if(argEntrada.length == 0){
			System.out.println("No puede ser vacío");
			System.exit(0);
		}

		if(argEntrada.length > 1){
			System.out.println("Muchos argumentos");
			System.exit(0);
		}

		String nombreArchivo = argEntrada[0];

		//System.out.println(nombreArchivo);

		HorarioMonitores arrancar = new HorarioMonitores();

		arrancar.leerArchivo(nombreArchivo);
		//arrancar.permutarEntrada();

		arrancar.ingenua();
		arrancar.avara();
		arrancar.dinamica();
		arrancar.sumaPermutaciones();

	}

	public void leerArchivo(String nEntrada){ //aquí le paso el nombre que recibí como parametro
			try (BufferedReader bufersito = new BufferedReader(new FileReader(nEntrada))){

				String sCurrentLine;// String Línea actual

				/*while
				((sCurrentLine = bufersito.readLine()) != null) {
					System.out.println(sCurrentLine);
				}*/
				cantidadMonitores = Integer.parseInt(bufersito.readLine());// lo convierto en entero para poder usarlo
				//System.out.println("La Cantidad de monitores leída es: " + cantidadMonitores);

				//Crear el array de Monitores
				monitoresTurnos = new Monitores[cantidadMonitores];

				//ahora para leer las siguiente n líneas con los monitores
				for (int i=0; i< cantidadMonitores; i++) {
					sCurrentLine = bufersito.readLine();
					//System.out.println("El monitor leído es: " + sCurrentLine);

					//Ingresando los datos del monitor
					String[] partesLines = sCurrentLine.split(" ");


					Monitores objetoTemporal = new Monitores();
					objetoTemporal.setNombre(partesLines[0]);
					objetoTemporal.setHoraInicio(Integer.parseInt(partesLines[1]));
					objetoTemporal.setHoraFin(Integer.parseInt(partesLines[2]));
					objetoTemporal.setTotalTurno();

					monitoresTurnos[i] = objetoTemporal;


					//Se finaliza el procezamiento del archivo
					//System.out.println("El nombre es: "+ monitoresTurnos[i].getNombre() + " Empieza a las " + monitoresTurnos[i].getHoraInicio() + "h y dura " +  monitoresTurnos[i].getTotalTurno());
				}


			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public boolean verificarCruce(int[] entradaEvaluar){// aquí tengo que verificar si en la permutación sin repetir hay un cruce

		for (int i=0; i<24; i++) {//esto hace el recorrido por la parte de ocupación y si hay un lugar que sume mas de 1 se cruza

			if(entradaEvaluar[i] > 1){
				return true;
			}
		}

		return false;
	}

	public int[] sumarEntradas(int[] entradaUno, int[] entradaDos){
		int[] tmpSuma = new int[24];

		for (int i=0; i<24; i++) {
			tmpSuma[i] = entradaUno[i] + entradaDos[i];
		}

		return tmpSuma;
	}

	public void permutarEntrada(){//hay que generar una permutación n!
		//System.out.println("La cantidad a permutar es: " + cantidadMonitores);

		List<String> lista=new ArrayList<String>();
		for (int m=1; m<=cantidadMonitores; m++) {

			lista.add(Integer.toString(m));
		}
		Combinar comb=new Combinar(lista);
		//System.out.println(comb.Ar());

	}

	public void ingenua(){
		this.permutarEntrada();
		nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de Ingenua ");
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

		int costoMayor = 0;
		int monitorMayor = 0;

		for (int i=0; i < cantidadMonitores; i++){
			System.out.println("Mejor tiempo ahora: " + costoMayor);
			if (monitoresTurnos[i].getTotalTurno() > costoMayor) {
				monitorMayor = i;
				costoMayor = monitoresTurnos[i].getTotalTurno();
				System.out.println("Después de cosito " + monitoresTurnos[i].getTotalTurno());
			}

		}

		salidaTexto = "1";
		salidaTexto += "\n";
		salidaTexto += monitoresTurnos[monitorMayor].getTotalTurno();
		salidaTexto += "\n";
		salidaTexto += monitoresTurnos[monitorMayor].getNombre();
		//salidaTexto = JOptionPane.showInputDialog(null, "Escriba lo que quiere que este en la salida del texto");
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

	public void sumaPermutaciones(){

		List<String> listaTmp = new ArrayList<String>(); //para almacenar la permutaci temp

		for (int i=0; i < cantidadMonitores; i++) {//el principal

			for (int j=0; j< cantidadMonitores-1; j++) {//cantidad que le voy a sumar

				while( )

				for (int k=i+1; k < cantidadMonitores; k++) {//lo que le voy a sumar

					System.out.println(" El i " + i + " el j " + j + " el k " + k);
				}

			}
		}

	}

}
