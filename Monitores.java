

public class Monitores {

	private String nombre = "";
	private int horaInicio;
	private int horaFin;
	private int totalTurno;

	public void setNombre(String nombreNuevo){
		nombre = nombreNuevo;
	}

	public void setHoraInicio(int nuevaHora){
		horaInicio = nuevaHora;
	}

	public void setHoraFin(int nuevaHora){
		horaFin = nuevaHora;
	}

	public void setTotalTurno(){
		totalTurno = this.horaFin - this.horaInicio;
	}
}