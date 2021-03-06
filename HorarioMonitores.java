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
	private String resputaIngenua;

	private int[] tiempoTemporalOcupado = new int[24];

	private Monitores[] monitoresTurnos;

	private String nombreArSalida, salidaTexto; // para almacenar el arvhio de salida
	public static void main(String argEntrada[]){// la manera de usarlo es java HorarioMonitores entrada.txt lo cuales es que recive el nombre de en argEntrada

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

	public void leerArchivo(String nEntrada){ //aqu´i le paso el nombre que recibi como parametro
			try (BufferedReader bufersito = new BufferedReader(new FileReader(nEntrada))){

				String sCurrentLine;// String Linea actual

				/*while
				((sCurrentLine = bufersito.readLine()) != null) {
					System.out.println(sCurrentLine);
				}*/
				cantidadMonitores = Integer.parseInt(bufersito.readLine());// lo convierto en entero para poder usarlo
				//System.out.println("La Cantidad de monitores leida es: " + cantidadMonitores);

				//Crear el array de Monitores
				monitoresTurnos = new Monitores[cantidadMonitores];

				//ahora para leer las siguiente n lineas con los monitores
				for (int i=0; i< cantidadMonitores; i++) {
					sCurrentLine = bufersito.readLine();
					//System.out.println("El monitor leido es: " + sCurrentLine);

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

	public boolean verifciarCruce(int[] entradaEvaluar){// aquí tengo que verificar si en la permutación sin repetir hay un cruce

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
		//this.permutarEntrada();
		nombreArSalida= JOptionPane.showInputDialog(null, "Escriba como quiere llamar el archivo de salida de Ingenua ");
		EscribirTxt resultado = new EscribirTxt();

		// Inicio Algoritmo

		//inicializandoTemporalOcupado
		/*for (int t=0; t<24 ; t++) {//incializando en ceros la respuesta temporal
			tiempoTemporalOcupado[t] = 0;
			
		}*/

		/*for (int k= 0; k< cantidadMonitores ; k++) {
			
		System.out.println("Cambiando k" + k);

			for (int i = k; i<= cantidadMonitores; i++) {
				System.out.println("Como va i "+ i);
				this.combinaciones(cantidadMonitores, i, k);
				
			}

		}*/

		int[] monitorePermutado = new int[cantidadMonitores];

		for (int i=0; i< cantidadMonitores; i++) {
			monitorePermutado[i]=i;
			
		}

		//empiezo lo de la permutation
		int r = monitorePermutado.length;

		//for (int n=1; n<cantidadMonitores; n++) {//esto es la cantidad que va ir eligiendo, primero 1 hasta la totoralidad
			permutaRepitiendo(monitorePermutado, "", cantidadMonitores, r);
			
		//}

		//fin la permutation

		//trabando ya con la major salida
		String[] tmpRespustaIngenua = resputaIngenua.split(" ");
		int cantidadMonitoresParaIngenua = tmpRespustaIngenua.length;

		salidaTexto = Integer.toString(cantidadMonitoresParaIngenua);
		salidaTexto += "\n";
		salidaTexto += Integer.toString(tiempoDisponible);
		salidaTexto += "\n";

		for (int i=0; i<cantidadMonitoresParaIngenua; i++) {
			int nombreMoni = Integer.parseInt(tmpRespustaIngenua[i]);
			//System.out.println(monitoresTurnos[nombreMoni].getNombre());
			salidaTexto += monitoresTurnos[nombreMoni].getNombre();
			salidaTexto += "\n";			
		}

		


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

	public void sumaPermutaciones(){//tener en cuenta que puedo hace la combinatoria de a grupos

		/*List<String> listaTmp = new ArrayList<String>(); //para almacenar la permutaci temp

		for (int i=0; i < cantidadMonitores; i++) {//el principal

			for (int j=0; j< cantidadMonitores-1; j++) {//cantidad que le voy a sumar

				while( )

				for (int k=i+1; k < cantidadMonitores; k++) {//lo que le voy a sumar

					System.out.println(" El i " + i + " el j " + j + " el k " + k);					
				}

			}			
		}*/

		//Inicio combinatoria
		//formula n!(n-i)

		/*int i = 0, j = 0, ci = 0;
        int v[] = new int[n];
        double p1=0;


        for(i = 0; i < n; i++)
        { v[i]=i; }

        escribe(v, r);
        ci++;
        while(ci < p1)
        {
            i = r - 1;
            while (v[i] == n - r + i) { i--; }
                   
            v[i] = v[i] + 1;
            for (j = i + 1; j < r; j++) { v[j] = v[i] + j - i; }
            escribe(v,r);
            ci++;
        }*/

		//Fin

	}

	public void combinaciones(int n, int r){
        int i = 0, j = 0, ci = 0;
        double p1=0;

        int v[] = new int[n];

        for(i = 0; i < n; i++)
        { v[i]=i; }

        escribe(v, r);
        ci++;
        while(ci < p1)
        {
            i = r - 1;
            while (v[i] == n - r + i) { i--; }
                   
            v[i] = v[i] + 1;
            for (j = i + 1; j < r; j++) { v[j] = v[i] + j - i; }
            escribe(v,r);
            ci++;
        }
	}

	public void escribe(int v[],int r){
		for(int i=0;i<r;i++) {
			System.out.println(v[i]);
		}
		System.out.println("-");
	}

	public void permutaRepitiendo(int[] elem, String act, int n, int r){
		//System.out.println(act);

		for (int t=0; t<24 ; t++) {//incializando en ceros la respuesta temporal
			tiempoTemporalOcupado[t] = 0;
			
		}

		if (act!="") {
			
			//System.out.println("si esta entrando");

	        String[] partecitas = act.split(" ");
	        int[] tmpParaEvaluar = new int[partecitas.length];

	        //colocando las parte

	        for (int k=0; k<partecitas.length; k++) {
	        	tmpParaEvaluar[k]= Integer.parseInt(partecitas[k]);
	        }

	        for (int y=0; y<partecitas.length; y++) {//para hacer las suma de lo que esta dentro
	        	int elMonitor = Integer.parseInt(partecitas[y]);
	        	tiempoTemporalOcupado = this.sumarEntradas(tiempoTemporalOcupado, monitoresTurnos[elMonitor].getHoraOcupada());
	        }

	        //tiempoTemporalOcupado = this.sumarEntradas(tiempoTemporalOcupado + monitoresTurnos[y].getHoraOcupada());
	        if (!(this.verifciarCruce(tiempoTemporalOcupado))) {
	        	System.out.println("Se puede usar este: " + act); 
	        	//System.out.println(act);
	        	//deberia colocar para que verifique desde este parte

	        	int tmpTiempoDisponible = sumarDisponibilidad(tiempoTemporalOcupado);

	        	if(tmpTiempoDisponible > tiempoDisponible){
	        		tiempoDisponible = tmpTiempoDisponible;

	        		resputaIngenua = act;
	        	}       	
	        }

	        /*for (int i=0; i < 24 ; i++) {//para verificar lo que esta en tiempoTemporal
	        	System.out.println(tiempoTemporalOcupado[i] + "en la hora");
	        	
	        }*/

	    }

        //fin de colocar las partes

        //System.out.println(partecitas.length + "tamaño");

        //done deveria ccolora
        if (n == 0) {
            //System.out.println(act + "hola");
        } else {
            //System.out.println(act + " yo");
            for (int i = 0; i < r; i++) {
                if (!act.contains(Integer.toString(elem[i]))) { // Controla que no haya repeticiones
                    permutaRepitiendo(elem, act + elem[i] + " ", n - 1, r);
                }
            }
        }

    	
	}

	public int sumarDisponibilidad(int[] laSuma){
		int salida = 0;
		for (int i=0; i<24; i++) {
			salida += laSuma[i]; 
		}

		return salida;
	}


}
