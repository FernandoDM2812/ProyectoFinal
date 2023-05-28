package ProyectoFinalPruebas;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Humano extends Jugador{
	
	private Scanner sc2 = new Scanner(System.in);
	
	public Humano( String nombre, int puntos) {
		super(nombre,puntos);
	}
	
	@Override
	boolean responderLengua(String resultado)throws NoSuchElementException{
		String respuesta = sc2.nextLine();
			if (respuesta.equals(resultado)) {
				System.out.println("La respuesta de " + nombre + " es: " + respuesta);
				System.out.println("La respuesta es correcta: " + resultado);
				return true;
			} else {
				System.out.println("La respuesta de " + nombre + " es: " + respuesta);
				System.out.println("La respuesta correcta era: " + resultado);
				return false;
			}
		}
	@Override
	boolean responderIngles(String resultado) throws NoSuchElementException{
		String opcion = "A";
			String respuesta = sc2.nextLine();
			if (respuesta.equals(opcion)) {
				System.out.println("La respuesta de " + nombre + " es: A");
				System.out.println("La respuesta es correcta: " + resultado);
				return true;
			} else {
				System.out.println("La respuesta de " + nombre + " es: " + respuesta);
				System.out.println("La respuesta correcta era: " + resultado);
				return false;
				}
		}
	

	@Override
	boolean responderMates(String resultado) throws NoSuchElementException{
			String respuesta = sc2.nextLine();
			if (respuesta.equals(resultado)) {
				System.out.println("La respuesta de " + nombre + " es: " + respuesta);
				System.out.println("La respuesta es correcta: " + resultado);
				return true;
			} else {
				System.out.println("La respuesta de " + nombre + " es: " + respuesta);
				System.out.println("La respuesta correcta era: " + resultado);
				return false;
			}
	}
}

