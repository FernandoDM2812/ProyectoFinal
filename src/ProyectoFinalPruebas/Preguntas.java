package ProyectoFinalPruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Preguntas {
	  	  
	public static void generarPreguntaAleatoria() throws FileNotFoundException {
		int opcion = new Random().nextInt(3) + 1; // número aleatorio de 4 a 8 operandos
		if (opcion == 1) {
			preguntaLengua();
		}else if(opcion == 2) {
			preguntaIngles();
		}else if(opcion == 3){
			preguntaMates();
		}
	}
	
	
		public static void preguntaLengua() throws FileNotFoundException {
			  String palabra;
			  File file = new File("src/ProyectoFinalPruebas/diccionario.txt");
				Palabra(file);
				palabra	 = Palabra(file);
				palabra = tildesPalabra(palabra);
				String palabraAuxiliar = ocultarLetras(palabra);
				System.out.println(palabra + ":::" + palabraAuxiliar);
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
	
		private static String ocultarLetras(String palabra) {
			
			StringBuilder palabraOculta = new StringBuilder(palabra);
			if(palabra.length()==1){
				palabra = "-";
			}else if(palabra.length()==2) {
				Random random = new Random();
				int[] aux = new int[1];
				for(int i=0;i<2;i++) {
					int indice = random.nextInt(palabra.length());
					}
				for (int indice : aux) {
					palabraOculta.setCharAt(indice, '-');
				}
			}else if(palabra.length()>=3) {
				int letrasOcultas = palabra.length() / 3;
				int[] aux = new int[letrasOcultas];
	
			    Random random = new Random();
	
				for(int i=0;i<aux.length;i++) {
					int indice = random.nextInt(palabra.length());
					if(aux[i]==indice) {
					indice = random.nextInt(palabra.length());
					aux[i] = indice; 
					}else{
						aux[i] = indice;
					}
					}
				for (int indice : aux) {
					palabraOculta.setCharAt(indice, '-');
				}
			}
			return palabraOculta.toString();
	}
		public static String preguntaIngles() {
			        String preguntasIngles = "src/ProyectoFinalPruebas/ingles.txt";
			        String resultado="";
			        ArrayList<String> letras = new ArrayList();
			        letras.add("A");
			        letras.add("B");
			        letras.add("C");
			        letras.add("D");
			        
			        try (BufferedReader br = new BufferedReader(new FileReader(preguntasIngles))) {
			            String linea;
			            ArrayList<String> preguntas = new ArrayList<>();
			            ArrayList<ArrayList<String>> respuestas = new ArrayList<>();

			            while ((linea = br.readLine()) != null) {
			                preguntas.add(linea);
			                ArrayList<String> respuestasPregunta = new ArrayList<>();
			                for (int i = 0; i < 4; i++) {
			                    if ((linea = br.readLine()) != null) {
			                        respuestasPregunta.add(linea);
			                    } else {
			                        break;
			                    }
			                }
			                respuestas.add(respuestasPregunta);
			            }

			            // Obtener una pregunta aleatoria
			            int indicePreguntaAleatoria = (int) (Math.random() * preguntas.size());
			            String preguntaAleatoria = preguntas.get(indicePreguntaAleatoria);
			            ArrayList<String> respuestasPreguntaAleatoria = respuestas.get(indicePreguntaAleatoria);
			            resultado=respuestasPreguntaAleatoria.get(0);
			            ArrayList<String> respuestasConLetras = new ArrayList<String>();
			            for (int i=0;i<letras.size();i++) {
			            	respuestasConLetras.add(letras.get(i)+ " - " + respuestasPreguntaAleatoria.get(i));
			            }
			            
			            // Imprimir la pregunta aleatoria y sus respuestas
			            System.out.println(preguntaAleatoria);
			            Collections.shuffle(respuestasConLetras);
			            for (String respuesta : respuestasConLetras) {
			                System.out.println(respuesta);
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        return resultado;
			    }
		public static String preguntaMates() {
			        int numOperandos = new Random().nextInt(5) + 4; // número aleatorio de 4 a 8 operandos
			        StringBuilder sb = new StringBuilder();
			        String operador;

			        // generamos los operandos aleatorios
			        for (int i = 0; i < numOperandos; i++) {
			            sb.append(new Random().nextInt(11) + 2); // valores aleatorios de 2 a 12
			            if (i != numOperandos - 1) { // si no es el último operando, añadimos un operador
			                int numAleatorio = new Random().nextInt(3);
			                switch (numAleatorio) {
			                    case 0:
			                        operador = "+";
			                        break;
			                    case 1:
			                        operador = "-";
			                        break;
			                    default:
			                        operador = "*";
			                        break;
			                }
			                sb.append(operador);
			            }
			        }

			        String operacion = sb.toString();
			        System.out.println("La Pregunta de Matematicas es: \n"+ operacion);
			        
			        
			        double resultado = resultadoOperacion(operacion);
			        int resultadoEntero = (int) resultado;
			        String resultadoEscrito = String.valueOf(resultadoEntero);
			        System.out.println(resultadoEscrito);
			        return resultadoEscrito;
			    }
		public static double resultadoOperacion(String operacion) {
			        String[] operandos = operacion.split("[+\\-]"); // Dividir en operandos por suma y resta
			        double resultado = evaluarMultiplicaciones(operandos[0]);

			        for (int i = 1; i < operandos.length; i++) {
			            int indiceOperando = operacion.indexOf(operandos[i]);
			            if (indiceOperando > 0) {
			                char operador = operacion.charAt(indiceOperando - 1);
			                if (operador == '+') {
			                    resultado += evaluarMultiplicaciones(operandos[i]);
			                } else if (operador == '-') {
			                    resultado -= evaluarMultiplicaciones(operandos[i]);
			                }
			            }
			        }

			        return resultado;
			    }

		public static double evaluarMultiplicaciones(String operacion) {
			        String[] operandos = operacion.split("\\*"); // Dividir en operandos por multiplicación
			        double resultado = Double.parseDouble(operandos[0]);

			        for (int i = 1; i < operandos.length; i++) {
			            resultado *= Double.parseDouble(operandos[i]);
			        }

			        return resultado;
			    }
			 
			}

