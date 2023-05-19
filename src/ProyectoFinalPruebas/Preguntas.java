package ProyectoFinalPruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Preguntas {

	  public static void preguntaMates() {
		    int numOperandos = new Random().nextInt(5) + 4; // número aleatorio de 4 a 8 operandos
		    StringBuilder sb = new StringBuilder();
		    
		    // generamos los operandos aleatorios
		    for (int i = 0; i < numOperandos; i++) {
		      sb.append(new Random().nextInt(11) + 2); // valores aleatorios de 2 a 12
		      if (i != numOperandos - 1) { // si no es el último operando, añadimos un operador
		        sb.append(generarOperadorAleatorio());
		      }
		    }
		    
		    String operacion = sb.toString();
		    System.out.println("La pregunta es: " + operacion);
		  }
		  
		  private static char generarOperadorAleatorio() {
		    int numAleatorio = new Random().nextInt(3);
		    switch (numAleatorio) {
		      case 0:
		        return '+';
		      case 1:
		        return '-';
		      default:
		        return '*';
		    }
		  }
		  
		  public static void preguntaLengua() throws FileNotFoundException {
			  String Palabra;
			  File file = new File("src/ProyectoFinalPruebas/diccionario.txt");
				Palabra(file);
				Palabra	 = Palabra(file);
				Palabra = tildesPalabra(Palabra);
		  }
			public static String Palabra(File file) throws FileNotFoundException{
		        Scanner entrada = new Scanner(file);
		        ArrayList<String> palabras = new ArrayList<>();
		        while (entrada.hasNext()) {
		            palabras.add(entrada.next());
		        }
		        int randomIndex = (int)(Math.random() * palabras.size());
		        String Palabra = palabras.get(randomIndex);
		        entrada.close();
		        return Palabra;
			}
			public static String tildesPalabra(String palabra) {
		        
				char[] aux = palabra.toCharArray(); 
				for(int i=0;i<palabra.length();i++) {
					if(aux[i]=='á') {
						aux[i]='a';
					}else if(aux[i]=='é') {
						aux[i]='e';
					}else if(aux[i]=='í') {
						aux[i]='i';
					}else if(aux[i]=='ó') {
						aux[i]='o';
					}else if(aux[i]=='ú') {
						aux[i]='u';
					}
				}
				palabra = new String(aux);
				
				return palabra;
		    }
			
}
