import java.util.Random;

public final class GeneradorPunto1 {

	public static void main(String[] args) {
		
		GeneradorPunto1 normalR = new GeneradorPunto1();
		int n; //Cantidad de Datos a generar

		n = Integer.parseInt(args[0]); // con esto tomo por consola la cantidade Datos a generar

		log(n);
		//Se generan los datos
		for (int i=1; i<=n; i++) {
			//Para optener las horas de forma random
			normalR.getHoras();
			// Ejemplo NombreTarea hI hF
			//log("Nombre" + i + " " + normalR.getNormal(1, 7) + " " + normalR.horaI + " " + normalR.horaF);
			log("Monitor" + i + " " + normalR.horaI + " " + normalR.horaF);				
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