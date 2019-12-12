import java.util.Scanner;

public class Proyecto_final {
	
	public static void main(String[] args) {
		char[][] letras;
 		Scanner teclado = new Scanner (System.in);
		//variables
			char m =0 , car;
			String cadena = "p";
			char [] valor1 = new char[4];
	    	int x, y, lo;
	    	char orientacion;
		//creacion de la lista de palabras de prueba y normal
			String [] palabrasPruebas = {"AAA", "AAAAAA", "BBBBBBBBB", "CCCCC", "DDDDD", "EEEEE", "FFFFF", "GGGGG", "HHHHH", "IIIII", "JJJJJ"};
			String [] palabras = {"SOLENOIDE", "ORANGUTAN", "RATON", "SOLEDAD", "ARBOL", "QUESO", "ORDENADOR", "FAROLA", "PAPEL", "CASA", "CARABINA"};


		//Eleccion del modo de juego
			System.out.println("Eliga el modo de juego, pruebas escriba P, para el modo normal escriba otra entrada");
			
			cadena = teclado.next();
			
			
			/*try {
					m=(char) System.in.read();
				}
			catch(java.io.IOException IOex){}*/
			
			car = cadena.charAt(0);
			
		   
			if ((car=='p') || (car=='P')) 
				letras = imprimirMat (palabrasPruebas);//imprime el metodo de la matriz normal
			else 
				letras = imprimirMat (palabras);//imprime el metoso de la matriz pruebas		
			
			/* bucle para que te pida coordenadas hasta que se acaben las palabras*/
			while(true) {
			System.out.println("Inserte coordenadas de fila = x, columna = y, direcci�n(Norte = N, Sur = S, Este = E, Oeste = W) y longitud de la palabra");
			String coordenadas = teclado.next();
			valor1 = leerCoordenadas (coordenadas);/* el metodo ( return valor2) se iguala al valor1*/
			x = Character.getNumericValue(valor1[0]);/* convierte un character a un int*/
			y = Character.getNumericValue(valor1[1]);
			orientacion = valor1[2];
			lo = Character.getNumericValue(valor1[3]);
			System.out.println("fila " + x + " columna " + y + " orientacion " + orientacion + " longitud " + lo);
			}
	}
	
	/* metodo para leer las coordenadas*/
	public static char [] leerCoordenadas (String coordenadas){
		char [] valor2 = new char[4];/*matriz de 4 ranuras que lea los 4 caracteres*/
	
		for(int i = 0; i<coordenadas.length(); i++) { /*bucle for para poder leer las 4 posiciones de coordenadas y las almacene*/
			valor2[i] = coordenadas.charAt(i);
		}
		return valor2;
	}
	
//metodo matriz 
	public static char [][] imprimirMat (String[] palabras) {
		char [][] matriz = NuevaMatriz.nuevaMatriz (10, 10, palabras);

		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
		for(int i = 0; i<10; i++) {
			System.out.print( i + "|" + "");
			
			for(int j = 0; j<10; j++) 
				System.out.print (matriz[i][j] + "|");
			
			System.out.println("" + i);		
		
		} 
	    
		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
		return matriz;
	}

}		




