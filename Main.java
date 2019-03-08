import java.util.Scanner;

public class Main {

    /*
    Hay que modificar los menús para que se permita modificar las relaciones entre nodos por si hay alguna equivocacion y para poder imprimir el grafo en cualquier momento
     */
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
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    //automata.mostrarAutomata();
                }
                break;
                case 2: {
                    System.out.println("\nHas seleccionado el automata de ejemplo 2\n");
                    automata = new Automata(4);
                    automata.Ejemplo2();
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    //automata.mostrarAutomata();
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
                    automata.mostrarAutomata();
                    automata.CalculoAutomataMinimo();
                    System.out.println("-----------------------------------------------------------");
                    //automata.mostrarAutomata();
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