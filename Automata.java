import java.util.Scanner;

public class Automata {

    private int nodos;
    private int transiciones;
    private int[][] automata;
    private boolean[] estadoFinal;
    private boolean[] nodosAccesibles;
    private String[] alfaNodos;
    private String[] alfaTrans;

    public Automata(int nodos, int transiciones) {

        this.nodos = nodos;
        this.transiciones = transiciones;
        automata = new int[nodos][transiciones];
        estadoFinal = new boolean[nodos];
        nodosAccesibles = new boolean[nodos];
        alfaNodos = new String[]{"p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7"};
        alfaTrans = new String[]{"a", "b"};

        for (int i = 0; i < nodos; i++) {
            estadoFinal[i] = false;
            for (int j = 0; j < transiciones; j++) {
                automata[i][j] = -99;
            }
        }
    }

    public void Ejemplo1() {

        //Inicialización del automata de ejemplo número 1 del tema 8.

        automata[0][0] = 1; //p0->p1: a
        automata[0][1] = 0; //p0->p0: b

        automata[1][0] = 2; //p1->p2: a
        automata[1][1] = 0; //p1->p0: b

        automata[2][0] = 2; //p2->p2: a
        automata[2][1] = 3; //p2->p3: b

        automata[3][0] = 4; //p3->p4: a
        automata[3][1] = 0; //p3->p0: b

        automata[4][0] = 4; //p4->p4: a
        automata[4][1] = 5; //p4->p5: b

        automata[5][0] = 4; //p5->p4: a
        automata[5][1] = 6; //p5->p6: b

        automata[6][0] = 7; //p6->p7: a
        automata[6][1] = 6; //p6->p6: b

        automata[7][0] = 4; //p7->p4: a
        automata[7][1] = 6; //p7->p6: b

        estadoFinal[4] = true; //nodo p4 es final
        estadoFinal[5] = true; //nodo p5 es final
        estadoFinal[6] = true; //nodo p6 es final
        estadoFinal[7] = true; //nodo p7 es final

    }

    public void Ejemplo2() {

        //Inicialización del automata de ejemplo número 2 del tema 8.

        automata[0][0] = 1;
        automata[0][1] = 2;

        automata[1][0] = -99;
        automata[1][1] = 3;

        automata[2][0] = 4;
        automata[2][1] = -99;

        automata[3][0] = -99;
        automata[3][1] = 3;

        automata[4][0] = 4;
        automata[4][1] = -99;

        estadoFinal[1] = true;
        estadoFinal[2] = true;
        estadoFinal[3] = true;
        estadoFinal[4] = true;

    }

    public void Datos() {

        Scanner sc = new Scanner(System.in);
        int origen, destino, trans, fin, exit;
        do {
            System.out.println("Introduce nodo de origen:\n");
            origen = sc.nextInt();
            System.out.println("Introduce nodo de destino:\n");
            destino = sc.nextInt();
            System.out.println("Introduce la letra de la transición:\n");
            trans = sc.nextInt();
            automata[origen][trans] = destino;
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();

        } while (exit != 1);

        exit = 2;
        do {
            System.out.println("Introduce un nodo final:\n");
            fin = sc.nextInt();
            estadoFinal[fin] = true;
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();
        } while (exit != 1);
        sc.close();
    }

    public void CalculoAutomataMinimo() {

        EliminarEstadosNoAccesibles();
        marcarEstados();
    }

    private void EliminarEstadosNoAccesibles() {

        int nodo;
        nodosAccesibles[0] = true; //Da por hecho que el primer nodo es el nodo inicial
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < transiciones; j++) {
                nodo = automata[i][j];
                if (nodo != i) {
                    nodosAccesibles[i] = true;
                }
            }
        }
    }

    public void marcarEstados() {

        boolean matTriangular[][] = new boolean[nodos][nodos];
        for (int i = 1; i < nodos; i++) {
            for (int j = 0; j < i; j++) {
                matTriangular[i][j] = false;
            }
        }

        for (int i = 1; i < nodos; i++) {
            for (int j = 0; j < i; j++) {
                if ((estadoFinal[i] && !estadoFinal[j] && nodosAccesibles[i] && nodosAccesibles[j]) ||
                        (!estadoFinal[i] && estadoFinal[j] && nodosAccesibles[i] && nodosAccesibles[j])) {
                    matTriangular[i][j] = true;
                }
            }
        }

        boolean cambios;
        do {
            cambios = false;
            for (int i = 1; i < nodos; i++) {
                for (int j = 0; j < i; j++) {
                    /*if(){
                        cambios = true;
                        //Bucle por implementar
                    }*/
                }
            }
        } while (cambios);
    }

    public void mostrarAutomata() {

        String nOrigen, nDestino, trans;
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < transiciones; j++) {
                nOrigen = intToString(alfaNodos, i);
                nDestino = intToString(alfaNodos, automata[i][j]);
                trans = intToString(alfaTrans, j);
                if (nDestino != "") {
                    System.out.println("Nodo " + nOrigen + " -> Nodo " + nDestino + "\nTransición " + trans + "\n");
                }
            }
        }
    }

    private int stringToInt(String[] abc, String st) {

        int resul = -99;
        for (int i = 0; i < abc.length; i++) {
            if (st == abc[i]) {
                resul = i;
                break;
            }
        }
        return resul;
    }

    private String intToString(String[] abc, int pos) {

        if (pos >= 0)
            return abc[pos];
        else
            return "";
    }

}