import java.io.*;

public class EscribirTxt {

	private String campoSalida;

	public void escribirArchivo(String nombreArchivo){
		FileWriter archivo = null;
		PrintWriter pWrite = null;
		try{
			archivo = new FileWriter(nombreArchivo);
			pWrite = new PrintWriter(archivo);

			pWrite.println(campoSalida);// este es el encargado de escribir lo que hay en el archivo 


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != archivo) {
					archivo.close();
				} 
				}catch (Exception e2) {
					e2.printStackTrace();
			}				
		}
	}

	public void setCampoSalida(String salida){
		this.campoSalida = salida;
	}

}