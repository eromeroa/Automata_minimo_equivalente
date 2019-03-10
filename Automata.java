import java.util.Scanner;

public class Automata {

    private Alfabeto alfa;
    private int nodos;
    private int transiciones;
    private int[][] automata;
    private int[][] automataFinal;
    private boolean[] estadoFinal;
    private boolean[] nodosAccesibles;
    private boolean[][] matTriangular;
    private boolean[] nodosEliminados;

    public Automata(int alfabeto) {
        alfa = new Alfabeto(alfabeto);
        this.nodos = alfa.getNodos();
        this.transiciones = alfa.getTransiciones();
        automata = new int[nodos][transiciones];
        automataFinal = new int[nodos][transiciones];
        estadoFinal = new boolean[nodos];
        nodosAccesibles = new boolean[nodos];
        nodosEliminados = new boolean[nodos];

        matTriangular = new boolean[nodos][nodos];
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                matTriangular[i][j] = false;
            }
        }

        for (int i = 0; i < nodos; i++) {
            estadoFinal[i] = false;
            nodosEliminados[i] = false;
            for (int j = 0; j < transiciones; j++) {
                automataFinal[i][j] = -99;
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
        String origen, destino, trans, fin;
        int exit;
        boolean pertenece;
        do {
            do {
                System.out.println("Introduce nodo de origen:\n");
                origen = sc.nextLine();
                pertenece = alfa.PerteneceAlAlfabeto_Nodo(origen);
                if (!pertenece) {
                    System.out.println("Este nombre de nodo no pertenece al alfabeto definido.\n");
                }
            } while (!pertenece);
            do {
                System.out.println("Introduce nodo de destino:\n");
                destino = sc.nextLine();
                pertenece = alfa.PerteneceAlAlfabeto_Nodo(destino);
                if (!pertenece) {
                    System.out.println("Este nombre de nodo no pertenece al alfabeto definido.\n");
                }
            } while (!pertenece);
            do {
                System.out.println("Introduce la letra de la transicion:\n");
                trans = sc.nextLine();
                pertenece = alfa.PerteneceAlAlfabeto_Transicion(trans);
                if (!pertenece) {
                    System.out.println("Este nombre de transición no pertenece al alfabeto definido\n");
                }
            } while (!pertenece);
            automata[alfa.StringToIntNodo(origen)][alfa.StringToIntTrans(trans)] = alfa.StringToIntNodo(destino);
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();
            sc.nextLine(); //Limpiamos el buffer.
        } while (exit != 1);
        do {
            System.out.println("Introduce un nodo final:\n");
            fin = sc.nextLine();
            estadoFinal[alfa.StringToIntNodo(fin)] = true;
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();
            sc.nextLine();//Limpiamos buffer.
        } while (exit != 1);
    }   //cambiar para meter los datos de: Nodo origen, valor de transición y nodo destino a la vez.

    public void CalculoAutomataMinimo() {

        EliminarEstadosNoAccesibles();
        marcarEstados();
        combinarEstados();
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

    private void marcarEstados() {

        for (int i = 0; i < nodos; i++) {
            System.out.print(estadoFinal[i] + "  ");
        }
        System.out.print("\n\n");


        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                if (i != j) {
                    if (((estadoFinal[i] && !estadoFinal[j]) && (nodosAccesibles[i] && nodosAccesibles[j])) ||
                            ((!estadoFinal[i] && estadoFinal[j]) && (nodosAccesibles[i] && nodosAccesibles[j]))) {
                        matTriangular[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                System.out.print(matTriangular[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");


        boolean cambios;
        int nodo1, nodo2;
        do {
            cambios = false;
            for (int i = 1; i < nodos; i++) {
                for (int j = 0; j < i; j++) {
                    if (nodosAccesibles[i] && nodosAccesibles[j]) { //No tener en cuenta los nodos inaccesibles en la matriz triangular
                        if (!matTriangular[i][j]) {
                            for (int k = 0; k < transiciones; k++) {
                                nodo1 = automata[j][k];
                                nodo2 = automata[i][k];
                                if (nodo1 != -99 && nodo2 != -99) { //Comprobar si existe la transicion
                                    if (matTriangular[nodo1][nodo2]) {
                                        matTriangular[i][j] = true;
                                        matTriangular[j][i] = true;
                                        cambios = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (cambios);

        //Bucle para imprimir la matriz "triangular"

        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                System.out.print(matTriangular[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }

    private void combinarEstados() {

        boolean[][] nodosEquivalentes = new boolean[nodos][nodos];
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < nodos; j++) {
                nodosEquivalentes[i][j] = false;
            }
        }

        //Rellenar nodosEquivalentes y nodosEliminados
        for (int i = 1; i < nodos; i++) {
            for (int j = 0; j < i; j++) {
                if (!matTriangular[i][j]) {
                    nodosEliminados[i] = true;
                    nodosEquivalentes[j][i] = true;
                }
            }
        }

        int nodoD;
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < transiciones; j++) {
                //guardamos el nodo destino del nodo i con transicion j
                nodoD = automata[i][j];
                //si el nodo no tiene la transicion j no hay que buscar el nodo destino
                if (nodoD != -99) {
                    //si el nodo destino es un nodo eliminado buscamos el nodo equivalente del nodo destino eliminado y se sustituye
                    if (nodosEliminados[nodoD]) {
                        for (int k = 0; k < nodos; k++) {
                            if (nodosEquivalentes[k][nodoD]) {
                                automata[i][j] = k;
                                break;
                            }
                        }
                    }
                }
            }
        }

        //si un nodo i no tiene transicion j y su equivalente si hay que ponerle la transicion j al nodo i
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < transiciones; j++) {
                if (!nodosEliminados[i] && automata[i][j] == -99) {
                    for (int k = 0; k < nodos; k++) {
                        if (nodosEquivalentes[i][k] && automata[k][j] != -99) {
                            automata[i][j] = automata[k][j];
                        }
                    }
                }
            }
        }

        //ponemos las transiciones de los nodos eliminados a -99
        for (int i = 0; i < nodos; i++) {
            if (nodosEliminados[i]) {
                for (int j = 0; j < transiciones; j++) {
                    automata[i][j] = -99;
                }
            }
        }
    }

    public void mostrarAutomata() {
        String nOrigen, nDestino, trans;
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < transiciones; j++) {
                nOrigen = alfa.intToStringNodo(i);
                nDestino = alfa.intToStringNodo(automata[i][j]);
                trans = alfa.intToStringTrans(j);
                if (nDestino != "") {
                    System.out.println("Nodo " + nOrigen + " - " + trans + " -> Nodo " + nDestino);
                }
            }
        }
        System.out.print("\nNodos finales: ");
        for (int i = 0; i < estadoFinal.length; i++) {
            if (estadoFinal[i] && !nodosEliminados[i]) {
                System.out.print(alfa.intToStringNodo(i) + " ");
            }
        }
        System.out.print("\n\n");
    }

}