public class HorarioMonitores {

	public static void main(String argEntrada[]){

		if(argEntrada.length == 0){
			System.out.println("No puede ser vacio");
			System.exit(0);
		}

		if(argEntrada.length > 1){
			System.out.println("Muchos argumentos");
			System.exit(0);
		}

		String nombreArchivo = argEntrada[0];

		System.out.println(nombreArchivo);

		HorarioMonitores arrancar = new HorarioMonitores();	
	}

}
