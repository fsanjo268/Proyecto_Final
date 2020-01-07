import java.util.Arrays;
import java.util.Scanner;

public class Proyecto_final {
	
	public static void main(String[] args) {
		char[][] letras;
 		Scanner teclado = new Scanner (System.in);
//variables
			char car;
			String cadena = "p";
			char [] valor1 = new char[4];
	    	int x, y, lo;
	    	char orientacion;
	    	boolean exist;
	    	int con;
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
			
		   
			if ((car=='p') || (car=='P')) {
				System.out.println("las palabras a buscar son: " +Arrays.toString(palabrasPruebas));
				letras = imprimirMat (palabrasPruebas);//imprime el metodo de la matriz normal
			}else {
				System.out.println("Las palabras a buscar son: " +Arrays.toString(palabras));
				letras = imprimirMat (palabras);//imprime el metoso de la matriz pruebas		
			}
// bucle para que te pida coordenadas hasta que se acaben las palabras
			while(true) {//bucle principal 
			while(hayletras(letras)) {//si hay letras entonces se repite el bucle, sino no
				System.out.println("Inserte coordenadas de columna = x, fila = y, dirección(Norte = N, Sur = S, Este = E, Oeste = W) y longitud de la palabra");
				String coordenadas = teclado.next();
					valor1 = leerCoordenadas (coordenadas);// el metodo ( return valor2) se iguala al valor1
						x = Character.getNumericValue(valor1[0]);// convierte un character a un int
						y = Character.getNumericValue(valor1[1]);
						orientacion = valor1[2];
						lo = Character.getNumericValue(valor1[3]);
							String word = localizarpalabra(x, y, lo, orientacion, letras);//igualar una variable string para almacenar las palabras al metodo de lectura de palabras 
						exist = compararpalabras (palabras, word);//llamar al metodo leer y comparar palabra
								System.out.println(word);
								System.out.println("fila " + x + " columna " + y + " orientacion " + orientacion + " longitud " + lo);
						if(exist) {//llamar metodo quietar plabras
							quitarpalabras(x,y,orientacion, lo, letras);
						}
			}System.out.println("¿Desea jugar de nuevo? pulse 1");//cuando no haya palabras te pide volver a jugar o no
			con = teclado.nextInt();
			if(con==1) {// si tecleas 1, se repite de nuevo el bucle
				continue;
			}else {// sino, finaliza el programa
				System.out.println("gracias por jugar");
				break;
			}
	}
}			
//Metodo lectura de casillas para ver si hay huecos o no
	public static boolean hayletras(char[][] letras) {
		for(int i = 0; i < letras.length; i++) {//lectura de filas
			for(int j = 0; j < letras.length; j++) {//lectura de columnas
			if (letras[i][j] != '\0') {//si hay letras entonces es verdadero
				return true;
			}		
		}
	}return false;
}
//Metodo para gravedad y quitar palabras
	public static char[][] quitarpalabras(int x, int y, char orientacion, int lo, char[][] letras) {
		switch(orientacion) {
		case 'N':
			for(int i = y; i >= 0; i--) {
				if(i - lo >= 0) {
					letras[i][x] = letras[i - lo][x];
				}else {
					letras[i][x] = '\0';
				}
			}break;
		case 'S':
			for(int i = y + lo-1; i >= 0; i--) {
				if(i-lo>= 0) {
					letras[i][x] = letras[i - lo][x];
				}else {
					letras[i][x] = '\0';
				}
			}break;
		case 'W':
			for(int j = y; j >= 0; j--) {
				for(int i = x; i>x - lo; i--) {
					if(j==0) {
						letras[j][i] = '\0';	
					}else {
						letras[j][i]= letras[j - 1][i];
					}
				}
			}break;
		case'E':
			for(int j = y; j>=0; j--) {
				for(int i = x; i <lo + x; i++) {
					if(j==0){
						letras[j][i] = '\0';
					}else {
						letras [j][i]= letras[j-1][i];
					}
				}
			}break;
		}
		nuevaGeneracion(letras);
		return letras;
	}
//metodo que vuelva a escribir la matriz despues de la gravedad y eliminar la palabra
	public static void nuevaGeneracion(char[][] letras) {
		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
		for(int i = 0; i<10; i++) {
			System.out.print( i + "|" + "");
			
			for(int j = 0; j<10; j++) {
				System.out.print (letras[i][j] + "|");
			}
			System.out.println("" + i);		
		}  
		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
	}
//metodo para la comparacion de palabras 
	public static boolean compararpalabras(String[] palabras, String word ) {
			boolean existencia = true;
		for(int i = 0; i<palabras.length; i++){//bucle para poder leer las palabras de la lista
				if(palabras[i].equals(word)) {//comparamos la lista de palabras con la palabra encontrada
					System.out.println("true");
				}
				else {
					System.out.println("no esta la palabra");
		}
	}return existencia;
}			

//metodo para leer las palabras
	public static String localizarpalabra(int x, int y, int lo, char orientacion, char[][] letras) {
		String palabra = "";//variable de la palabra leida
		switch (orientacion) { //declarar cada uno de los casos posibles de coordenadas base a la orientacion
			case 'N':
				for(int i = y; i > y - lo; i--) { // bucle para leer cada una de las casillas de la amtriz comenzando por el eje y hasta la resta de la longitud dada y la posicion del y
					palabra += letras[i][x]; //añadir a la palabra cada una de los characters leidos por i
				}break;
			case 'S':
				for(int i = y; i < y + lo; i++) {
					palabra += letras[i][x];
				}break;
			case 'E':
				for(int i = x; i < x + lo; i++) {
					palabra += letras[y][i];
				}break;
			case 'W':
				for(int i = x; i > x - lo; i--) {
					palabra += letras[y][i];
				}break;
		}return palabra;
	}
// metodo para leer las coordenadas
	public static char [] leerCoordenadas (String coordenadas){
		char [] valor2 = new char[4];//matriz de 4 ranuras que lea los 4 caracteres de coordenadas
	
		for(int i = 0; i<coordenadas.length(); i++) { //bucle for para poder leer las 4 posiciones de coordenadas y las almacene
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
