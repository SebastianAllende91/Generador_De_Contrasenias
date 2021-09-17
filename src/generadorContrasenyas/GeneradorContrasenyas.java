
package generadorContrasenyas;

import java.util.Scanner;

public class GeneradorContrasenyas {

	private static final String CONSONANTES = "BCDFGHJKLMNPQRSTVWXYZ";
	private static final String VOCALES = "AEIOU";
	private static final String NUMEROS = "0123456789";

	private static int NUM_PARES = 3;
	private static int NUM_NUMS = 2;

	public static void main(String[] args) {

		char opcion;
		Scanner entrada = new Scanner(System.in);

		do {
			String password = "";
			for (int i = 0; i < NUM_PARES; i++) {
				password += generarPar();
			}

			for (int i = 0; i < NUM_NUMS; i++) {
				password += getAleatorio(NUMEROS);
			}

			System.out.println("La contraseña aleatoria es:\n\t" + password);
			System.out.println("Se encuentra conforme con su contraseña? (si/no)");
			opcion = entrada.next().charAt(0);

			if (opcion == 's' || opcion == 'S') {
				System.out.println("Su contraseña sera:\n" + password);
				break;
			}

		} while (opcion == 'n' || opcion == 'N');
		
		entrada.close();
	}

	//metodo para seleccionar una posicion aleatoria
	private static char getAleatorio(String opciones) {
		int pos = (int) (Math.random() * opciones.length());

		return opciones.charAt(pos);
	}

	
	private static String generarPar() {
		String par = "";
		par += getAleatorio(CONSONANTES);
		par += getAleatorio(VOCALES);

		return par;
	}

}
