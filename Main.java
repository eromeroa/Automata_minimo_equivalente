import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Automata a;
        Scanner sc = new Scanner(System.in);
        int x;
        do{
            System.out.println("\n||==============================||");
            System.out.println("||GENERADOR DE AUTÓMATAS MÍNIMOS||");
            System.out.println("||==============================||\n");
            System.out.println("Selecciona una opción:\n");
            System.out.println("1. Autómata de ejemplo 1");
            System.out.println("2. Autómata de ejemplo 2");
            System.out.println("3. Otro autómata\n");
            int i = sc.nextInt();
            a = new Automata(i);
            System.out.println("\n¿Desea continuar?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            x = sc.nextInt();
            automato1();
        }
        while (x!=2);
    }

    private void automato1(){
        System.out.println("\nHas seleccionado el automato de ejemplo 1");
        grafo = new boolean[8][8][2];
    }
}
