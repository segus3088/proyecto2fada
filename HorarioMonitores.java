import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class HorarioMonitores {


	private int tiempoDisponible = 0;
	private int cantidadMonitores = 0;
	private int[] respuestaTemporal;// este lo uso para guardar la posición de los proibles monnitreos que puede servir

	private Monitores[] monitoresTurnos;

	public static void main(String argEntrada[]){// la manera de usarlo es java HorarioMonitores entrada.txt lo cuales es que recive el nombre de en argEntrada

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

		HorarioMonitores arrancar = new HorarioMonitores();	

		arrancar.leerArchivo(nombreArchivo);
	}

	public void leerArchivo(String nEntrada){ //aqu´i le paso el nombre que recibi como parametro
			try (BufferedReader bufersito = new BufferedReader(new FileReader(nEntrada))){
 
				String sCurrentLine;// String Linea actual
	 
				/*while 
				((sCurrentLine = bufersito.readLine()) != null) {
					System.out.println(sCurrentLine);
				}*/
				cantidadMonitores = Integer.parseInt(bufersito.readLine());// lo convierto en entero para poder usarlo
				System.out.println("La Cantidad de monitores leida es: " + cantidadMonitores);

				//Crear el array de Monitores
				monitoresTurnos = new Monitores[cantidadMonitores];

				//ahora para leer las siguiente n lineas con los monitores
				for (int i=0; i< cantidadMonitores; i++) {
					sCurrentLine = bufersito.readLine();
					//System.out.println("El monitor leido es: " + sCurrentLine);	

					//Ingresando los datos del monitor
					String[] partesLines = sCurrentLine.split(" ");
					monitoresTurnos[i].setNombre(partesLines[0]);
					monitoresTurnos[i].setHoraInicio(Integer.parseInt(partesLines[1]));
					monitoresTurnos[i].setHoraFin(Integer.parseInt(partesLines[2]));
					monitoresTurnos[i].setTotalTurno();
					//Se finaliza el procezamiento del archivo		
				}

 
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

	public boolean verifciarCruce(){// aquí tengo que verificar si en la permutación sin repetir hay un cruce

		return false;
	}

	public void permutarEntrada(){//hay que generar una permutación n!

	}

}
