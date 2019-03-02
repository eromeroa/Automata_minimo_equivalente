import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Automata a;
        Scanner sc = new Scanner(System.in);
        int x;
        do{
            System.out.println("\n||==============================||");
            System.out.println("||GENERADOR DE AUTOMATAS MINIMOS||");
            System.out.println("||==============================||\n");
            System.out.println("Selecciona una opcion:\n");
            System.out.println("1. Automata de ejemplo 1");
            System.out.println("2. Automata de ejemplo 2");
            System.out.println("3. Otro automata\n");
            int i = sc.nextInt();
            a = new Automata(i);
            System.out.println("\n¿Desea continuar?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            x = sc.nextInt();
        }
        while (x!=2);
    }
}
