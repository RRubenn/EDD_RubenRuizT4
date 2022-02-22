import java.util.Scanner;

public class Criba {
    private static int sizeArray;
    private static boolean[] esPrimo;
    private static int num;
    private static int[] primos;
    private static int cuentaPrimos;

    public static int[] generarPrimos(int max) {
        primos = new int[0];
        if (max >= 2) {
            // Genera números primos de 1 a max
            generateBooleanArray(max);
            CribaPrimes();
            countPrimeNumbers();
            generateVectorPrimes();
            return primos;
            // Vector generado
        } else { // max < 2
            return primos;
            // Vector vacío
        }
    }

    private static void generateBooleanArray(int max) {
        // Tamaño del array
        sizeArray = max + 1;
        esPrimo = new boolean[sizeArray];

        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;

        // Inicializar el array
        for (num = 2; num < sizeArray; num++) {
            esPrimo[num] = true;
        }
    }

    private static void CribaPrimes() {
        // Recorre todos los números hasta la raiz cuadrada de estos.
        int multiple;
        for (num = 2; num < Math.sqrt(sizeArray); num++) {
            if (esPrimo[num]) {
                // Si num es primo, elimina los múltiplos de num hasta sizeArray.
                for (multiple = 2 * num; multiple < sizeArray; multiple += num) {
                    esPrimo[multiple] = false;
                }
            }
        }
    }

    private static void countPrimeNumbers() {
        // ¿Cuántos primos hay?
        cuentaPrimos = 0;
        for (num = 0; num < sizeArray; num++) {
            if (esPrimo[num]) {
                cuentaPrimos++;
            }
        }
    }

    private static void generateVectorPrimes() {
        // Rellenar el vector de números primos
        int j = 0;
        primos = new int[cuentaPrimos];
        for (int i = 0; i < sizeArray; i++) {
            if (esPrimo[i]) {
                primos[j] = i;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];

        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}