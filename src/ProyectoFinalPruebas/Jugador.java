package ProyectoFinalPruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Jugador {
	static File file = new File ("src/ProyectoFinalPruebas/jugadores.txt");
	
	public  String nombre;
	public static String respuesta;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
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

public static  void verJugadores() throws IOException {
	BufferedReader leer = new BufferedReader(new FileReader(file));
	String line;
	List<String> lines = new ArrayList<String>();

	while((line = leer.readLine()) != null) {
	    lines.add(line);
	}
	leer.close();
	
	for(int i=0;i<lines.size();i++) {
		System.out.println(lines.get(i));
		}
	}
}