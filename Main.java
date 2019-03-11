import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Automata automata;
        Scanner sc = new Scanner(System.in);
        int exit, alfabeto = -99999;
        do {
            System.out.println("\n||===========================================||");
            System.out.println("||GENERADOR DE AUTOMATAS MINIMOS EQUIVALENTES||");
            System.out.println("||===========================================||\n");
            System.out.println("Selecciona una opcion:\n");
            System.out.println("1. Automata de ejemplo 1");
            System.out.println("2. Automata de ejemplo 2");
            System.out.println("3. Otro automata\n");
            int i = sc.nextInt();
            switch (i) {

                case 1: {
                    System.out.println("\nHas seleccionado el automata de ejemplo 1\n");
                    automata = new Automata(3);
                    automata.Ejemplo1();
                    System.out.println("Automata inicial\n");
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("Automata minimo equivalente\n");
                    automata.mostrarAutomata();
                    System.out.println("-----------------------------------------------------------");
                }
                break;
                case 2: {
                    System.out.println("\nHas seleccionado el automata de ejemplo 2\n");
                    automata = new Automata(4);
                    automata.Ejemplo2();
                    System.out.println("Automata inicial\n");
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("Automata minimo equivalente\n");
                    automata.mostrarAutomata();
                    System.out.println("-----------------------------------------------------------");
                }
                break;
                case 3: {
                    System.out.println("\nHas seleccionado otro automata\n");
                    System.out.println("\n¿Desea utilizar el alfabeto por defecto o prefiere personalizarlo?");
                    System.out.println("1. Alfabeto por defecto ");
                    System.out.println("2. Alfabeto personalizado");
                    do {
                        alfabeto = sc.nextInt();
                        if (alfabeto != -99999 && alfabeto != 1 && alfabeto != 2) System.out.println("Opción no válida");
                    } while(alfabeto != 1 && alfabeto != 2);
                    automata = new Automata(alfabeto);
                    automata.Datos();
                    System.out.println("Automata inicial\n");
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("Automata minimo equivalente\n");
                    automata.mostrarAutomata();
                    System.out.println("-----------------------------------------------------------");
                }
                break;
            }

            System.out.println("\n¿Desea continuar?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();

        } while (exit != 2);
        sc.close();
    }

}