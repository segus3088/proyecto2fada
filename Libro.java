
public class Libro{

	private String nombre;
	private int paginas;

	public void setNombre(String nuevoNombre){
		this.nombre = nuevoNombre;
	}

	public void setPaginas(int cantidad){
		this.paginas = cantidad;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getPaginas(){
		return this.paginas;
	}
}