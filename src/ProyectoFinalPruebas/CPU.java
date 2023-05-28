package ProyectoFinalPruebas;

import java.util.ArrayList;
import java.util.Random;

public class CPU extends Jugador{

	public CPU( String nombre, int puntos) {
		super(nombre,puntos);
	}
	@Override
	boolean responderMates(String resultado) {
		System.out.println("La respuesta de " + nombre + " es: " +resultado);
		return true;
	}
	@Override
	boolean responderLengua(String resultado) {
		System.out.println("La respuesta de " + nombre + " es: " + resultado+"heuj");
		return false;
	}
	@Override
	boolean responderIngles(String resultado) {
		int numAleatorio = (new Random().nextInt(4)+1);
		if(numAleatorio==1) {
			System.out.println("La respuesta de " + nombre + " es: A");
			return true;
		}else if(numAleatorio==2){
			System.out.println("La respuesta de " + nombre + " es: B");
			System.out.println("La respuesta correcta era: "+resultado);
			return false;
		}else if(numAleatorio==3){
			System.out.println("La respuesta de " + nombre + " es: C");
			System.out.println("La respuesta correcta era: "+resultado);
			return false;
		}else {
			System.out.println("La respuesta de " + nombre + " es: D");
			System.out.println("La respuesta correcta era: "+resultado);
			return false;
			}
	}
}
