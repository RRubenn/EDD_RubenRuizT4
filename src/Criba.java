import java.util.Scanner;

public class Criba {
    private static int sizeArray;
    private static boolean[] booleansPrimes;
    private static int num;
    private static int[] primos;
    private static int cuentaPrimos;

    public static int[] generarPrimos(int numMax) {
        primos = new int[0];
        if (numMax >= 2) {
            // Genera números primos de 1 a numMax
            generateBooleanArray(numMax);
            CribaPrimes();
            countPrimeNumbers();
            generateVectorPrimes();
            return primos;
            // Vector generado
        } else { // numMax < 2
            return primos;
            // Vector vacío
        }
    }

    private static void generateBooleanArray(int max) {
        // Tamaño del array
        sizeArray = max + 1;
        booleansPrimes = new boolean[sizeArray];

        // Eliminar el 0 y el 1, que no son primos
        booleansPrimes[0] = booleansPrimes[1] = false;

        // Inicializar el array
        for (num = 2; num < sizeArray; num++) {
            booleansPrimes[num] = true;
        }
    }

    private static void CribaPrimes() {
        // Recorre todos los números hasta la raiz cuadrada de estos.
        int multiple;
        for (num = 2; num < Math.sqrt(sizeArray); num++) {
            if (booleansPrimes[num]) {
                // Si num es primo, elimina los múltiplos de num hasta sizeArray.
                for (multiple = 2 * num; multiple < sizeArray; multiple += num) {
                    booleansPrimes[multiple] = false;
                }
            }
        }
    }

    private static void countPrimeNumbers() {
        // ¿Cuántos primos hay?
        cuentaPrimos = 0;
        for (num = 0; num < sizeArray; num++) {
            if (booleansPrimes[num]) {
                cuentaPrimos++;
            }
        }
    }

    private static void generateVectorPrimes() {
        // Rellenar el vector de números primos
        int j = 0;
        primos = new int[cuentaPrimos];
        for (int i = 0; i < sizeArray; i++) {
            if (booleansPrimes[i]) {
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