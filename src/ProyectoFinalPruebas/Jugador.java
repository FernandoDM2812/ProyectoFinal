package ProyectoFinalPruebas;


public abstract class Jugador {
	public  String nombre;
	public int puntos=0;
	public static String respuesta;
	
	public Jugador(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private void responderMates() {
	}
	private void responderLengua() {
	}
	private void responderIngles() {
	}
}
