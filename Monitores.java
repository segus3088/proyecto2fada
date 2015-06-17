

public class Monitores {

	private String nombre = "";
	private int horaInicio = 0;
	private int horaFin = 0;
	private int totalTurno = 0;

	private int[] horaOcupada = new int[24];// esto es para colocar un 0 si no esta ocupado y 1 por si esta ocupado

	public void setNombre(String nombreNuevo){
		this.nombre = nombreNuevo;
	}

	public void setHoraInicio(int nuevaHora){
		this.horaInicio = nuevaHora;
	}

	public void setHoraFin(int nuevaHora){
		this.horaFin = nuevaHora;
	}

	public void setTotalTurno(){
		this.totalTurno = this.horaFin - this.horaInicio;
		this.setHoraOcupada();
	}

	public void setHoraOcupada(){
		int[] tmpInt = new int[24];

		for (int i = 0; i<24; i++) {//con esto inicializo en 0 antes de colocar los que le corresponden
			tmpInt[i]=0;
		}

		for (int i = this.horaInicio; i < horaFin; i++) {//voy colocando los unos a las horas ocupadas
			tmpInt[i] = 1;			
		}

		this.horaOcupada = tmpInt;
		System.out.println(this.nombre);

		for(int i = 0; i<24; i++){//probar como quedo
			System.out.println(this.horaOcupada[i] + "En la hora " + i);
		}
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getHoraInicio(){
		return this.horaInicio;
	}

	public int getHoraFin(){
		return this.horaFin;
	}

	public int getTotalTurno(){
		return this.totalTurno;
	}

	public int[] getHoraOcupada(){
		return this.horaOcupada;
	}

}