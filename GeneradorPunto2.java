import java.util.Random;

public final class GeneradorPunto2 {

	public static void main(String[] args) {// el uso sera $java GeneradorPunto2 cantidadEscritores cantidadLibros

		if(args.length != 2){
			System.out.println("Recuerde que se usa es $java GeneradorPunto2 cantidadEscritores cantidadLibros");
			System.exit(0);
		}
		
		GeneradorPunto2 normalR = new GeneradorPunto2();
		int cantidadEscritores; //Cantidad de Datos a generar en ese caso la cantidad de libros
		int cantidadLibros;

		cantidadEscritores = Integer.parseInt(args[0]);

		cantidadLibros = Integer.parseInt(args[1]); // con esto tomo por consola la cantidade Datos a generar

		log(cantidadEscritores + " "+ cantidadLibros);
		//Se generan los datos
		for (int i=1; i<=cantidadLibros; i++) {
			//Para optener las horas de forma random
			//normalR.getHoras();
			// Ejemplo NombreTarea hI hF
			//log("Nombre" + i + " " + normalR.getNormal(1, 7) + " " + normalR.horaI + " " + normalR.horaF);
			log("Libro" + i + " " + normalR.getNormal(1, 100));	// el formato seria libroN panginasX para un contexto el libro sera de maximo 100			
		}

	}

	private int horaI, horaF;

	private Random fRandom = new Random(); // Creo el objeto para hacer el random

	private static void log(Object aMensajito){
		System.out.println(String.valueOf(aMensajito));
	}

	private int getNormal(int inicioRango, int finRango){
		Random dNormal = new Random();

		return (int)(((((long)finRango) - (long)inicioRango + 1) * dNormal.nextDouble()) + inicioRango);
	}

	private void getHoras(){
		int h1, h2;
		h1 = this.getNormal(0,23);
		this.horaI = h1;

		h2 = h1 + this.getNormal(1,12);
		if (h2 < 24) {
			this.horaF = h2;			
		}
		else
			this.horaF = 24; // hasta 24 dado que finaliza el día.
		
	}
	
}