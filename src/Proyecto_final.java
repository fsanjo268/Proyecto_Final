import java.util.Scanner;

public class Proyecto_final {
	
//método matriz normal
	public static void imprimirMat (char [][] matriz) {

		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
		for(int i = 0; i<10; i++) {
			System.out.print( i + "|" + "");
			
			for(int j = 0; j<10; j++) 
				System.out.print (matriz[i][j] + "|");
			
			System.out.println("" + i);		
		
		} 
	    
		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
	}

//metodo matriz pruebas
	public static void imprimirMatprueba (char [][] matrizPruebas) {

		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
		for(int i = 0; i<10; i++) {
			System.out.print( i + "|" + "");
			
			for(int j = 0; j<10; j++) 
				System.out.print (matrizPruebas[i][j] + "|");
			
			System.out.println("" + i);		
		
		} 
	    
		System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
	}


	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		//variables
			char m =0 , car;
			String cadena = "p";
		    
		//creacion de la lista de palabras de prueba y normal
			String [] palabrasPruebas = {"AAA", "AAAAAA", "BBBBBBBBB", "CCCCC", "DDDDD", "EEEEE", "FFFFF", "GGGGG", "HHHHH", "IIIII", "JJJJJ"};
			String [] palabras = {"SOLENOIDE", "ORANGUTAN", "RATON", "SOLEDAD", "ARBOL", "QUESO", "ORDENADOR", "FAROLA", "PAPEL", "CASA", "CARABINA"};
		//creacion de la matriz 10x10 junto a las palabras
			char [][] matrizPruebas = NuevaMatriz.nuevaMatriz (10, 10, palabrasPruebas);
			char [][] matriz = NuevaMatriz.nuevaMatriz (10, 10, palabras);

		//Eleccion del modo de juego
			System.out.println("Eliga el modo de juego, pruebas escriba P, para el modo normal escriba otra entrada");
			
			cadena = teclado.next();
			
			
			/*try {
					m=(char) System.in.read();
				}
			catch(java.io.IOException IOex){}*/
			
			car = cadena.charAt(0);
			
		   
			if ((car=='p') || (car=='P')) 
				imprimirMat (matriz);//imprime el metodo de la matriz normal
			else 
				System.out.println("true");
				imprimirMatprueba (matrizPruebas);//imprime el metoso de la matriz pruebas
			
			
		
			
	}
}		




