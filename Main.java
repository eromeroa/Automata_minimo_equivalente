import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Automata a;
        Scanner sc = new Scanner(System.in);
        int x, n, m;
        do {


            System.out.println("\n||==============================||");
            System.out.println("||GENERADOR DE AUTOMATAS MINIMOS||");
            System.out.println("||==============================||\n");
            System.out.println("Selecciona una opcion:\n");
            System.out.println("1. Automata de ejemplo 1");
            System.out.println("2. Automata de ejemplo 2");
            System.out.println("3. Otro automata\n");
            int i = sc.nextInt();
            switch (i) {

                case 1: {
                    System.out.println("\nHas seleccionado el automata de ejemplo 1");
                    a = new Automata(8, 2);
                    a.Ejemplo1();
                    a.EscribirGrafo();
                    a.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    a.EscribirGrafo();
                }
                break;
                case 2: {
                    System.out.println("\nHas seleccionado el automata de ejemplo 2");
                    a = new Automata(5, 2);
                    a.Ejemplo2();
                    a.EscribirGrafo();
                    a.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    a.EscribirGrafo();
                }
                break;
                case 3: {
                    System.out.println("\nHas seleccionado otro automata");
                    System.out.println("Introduce el numero de nodos:\n");
                    n = sc.nextInt();
                    System.out.println("Introduce el numero de valores de las transiciones:\n");
                    m = sc.nextInt();
                    a = new Automata(n, m);
                    a.Datos();
                    a.EscribirGrafo();
                    a.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    a.EscribirGrafo();
                }
                break;
            }

            System.out.println("\n¿Desea continuar?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            x = sc.nextInt();

        } while (x != 2);

    }
}
