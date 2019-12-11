import java.util.Scanner;

public class Proyecto_final {
	
	public static void main(String[] args) {
		char[][] letras;
 		Scanner teclado = new Scanner (System.in);
		//variables
			char m =0 , car;
			String cadena = "p";
		    
		//creacion de la lista de palabras de prueba y normal
			String [] palabrasPruebas = {"AAA", "AAAAAA", "BBBBBBBBB", "CCCCC", "DDDDD", "EEEEE", "FFFFF", "GGGGG", "HHHHH", "IIIII", "JJJJJ"};
			String [] palabras = {"SOLENOIDE", "ORANGUTAN", "RATON", "SOLEDAD", "ARBOL", "QUESO", "ORDENADOR", "FAROLA", "PAPEL", "CASA", "CARABINA"};
		//creacion de la matriz 10x10 junto a las palabras


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
				System.out.println("true");
				letras = imprimirMat (palabras);//imprime el metoso de la matriz pruebas
			
			
		
			
	}
	
//método matriz 
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




