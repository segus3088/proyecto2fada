

public class Monitores {

	private String nombre = "";
	private int horaInicio = 0;
	private int horaFin = 0;
	private int totalTurno = 0;

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
}