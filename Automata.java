import java.util.Scanner;

public class Automata {

    private int n;
    private int m;
    private boolean[][][] grafo;
    private boolean[] estadoFinal;
    private boolean[] inaccesibles;
    private boolean[][] matTriangular;



    public Automata(int n, int m) {

        this.n = n;
        this.m = m;
        grafo = new boolean[n][n][m];
        estadoFinal = new boolean[n];
        inaccesibles = new boolean[n];
        matTriangular = new boolean[n][n];
        //Inicialización de la matriz y estadoFinal a false.

        for (int i = 0; i < n; i++) {
            estadoFinal[i] = false;
            inaccesibles[i] = false;
            for (int j = 0; j < n; j++) {
                matTriangular[i][j] = false;
                for (int k = 0; k < m; k++) {
                    grafo[i][j][k] = false;
                }
            }
        }
    }


    public void Ejemplo1() {
        //Inicialización del grafo de ejemplo número 1 del tema 8.

        grafo[0][0][1] = true; //0->0
        grafo[0][1][0] = true; //0->1
        grafo[1][0][1] = true; //1->0
        grafo[1][2][0] = true; //1->2
        grafo[2][2][0] = true; //2->2
        grafo[2][3][1] = true; //2->3
        grafo[3][0][1] = true; //3->0
        grafo[3][4][0] = true; //3->4
        grafo[4][4][0] = true; //4->4
        grafo[4][5][1] = true; //4->5
        grafo[5][4][0] = true; //5->4
        grafo[5][6][1] = true; //5->6
        grafo[6][6][1] = true; //6->6
        grafo[6][7][0] = true; //6->7
        grafo[7][4][0] = true; //7->4
        grafo[7][6][0] = true; //7->6

        //Inicialización del array de estados finales para el ejemplo numero 1 del tema 8.

        estadoFinal[4] = true; //nodo 4 es final
        estadoFinal[5] = true; //nodo 5 es final
        estadoFinal[6] = true; //nodo 6 es final
        estadoFinal[7] = true; //nodo 7 es final
    }

    public void Ejemplo2() {
        //Inicialización del grafo de ejemplo numero 2 del tema 8.

        grafo[0][1][0] = true; //0->1
        grafo[0][2][1] = true; //0->2
        grafo[1][3][1] = true; //1->3
        grafo[2][4][0] = true; //2->4
        grafo[3][3][1] = true; //3->3
        grafo[4][4][0] = true; //4->4

        //Inicialización del array de estados finales para el ejemplo numero 2 del tema 8.

        estadoFinal[1] = true; //nodo 1 es final
        estadoFinal[2] = true; //nodo 2 es final
        estadoFinal[3] = true; //nodo 3 es final
        estadoFinal[4] = true; //nodo 4 es final
    }

    public void Datos() {

        Scanner sc = new Scanner(System.in);
        char l;
        int i, j, k, exit;
        do {

            System.out.println("Introduce nodo de origen:\n");
            i = sc.nextInt();
            System.out.println("Introduce nodo de destino:\n");
            j = sc.nextInt();
            System.out.println("Introduce la letra de la transición:\n");
            k = conversor(sc.next().charAt(0));
            grafo[i][j][k] = true;
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();

        } while (exit != 1);
        exit = 2;
        do {
            System.out.println("Introduce un nodo final:\n");
            i = sc.nextInt();
            estadoFinal[i] = true;
            System.out.println("\n¿Ha terminado?\n");
            System.out.println("1. Si");
            System.out.println("2. No\n");
            exit = sc.nextInt();
        } while (exit != 1);
    }

    private int conversor(char letra) {

        int resul = -99, i=0;
        boolean encontrado = false;
        char abc[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        do{
            if(letra == abc[i]) {
                resul = i;
                encontrado = true;
            }
            i++;
        }while(!encontrado && i<abc.length);
        return resul;
    }

    private char conversorALetra(int letra){
        char abc[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char resul = abc[letra];
        return resul;
    }

    public void CalculoAutomataMinimo() {
        EliminarEstadosNoAccesibles();
        marcarEstados();
    }

    private void EliminarEstadosNoAccesibles() {

        int j = 1;
        boolean accesible;
        do {
            accesible = false;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (grafo[i][j][k] == true && !accesible) {
                        accesible = true;
                    }
                }
            }
            //Eliminamos el nodo si no es accesible.
            if (!accesible) {
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m; k++) {
                        inaccesibles[j] = true;
                        grafo[j][i][k] = false;
                        grafo[i][j][k] = false;
                    }
                }
            }
            j++;
        } while (j < n);
    }

    //Matriz triangular
    public void marcarEstados() {
        int cambios;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if((estadoFinal[i]&&!estadoFinal[j]&&!inaccesibles[i]&&!inaccesibles[j])||(!estadoFinal[i]&&estadoFinal[j]&&!inaccesibles[i]&&!inaccesibles[j])){
                    matTriangular[i][j]=true;
                }
            }
        }
        do{
            cambios = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    /*if(){
                        cambios++;
                        //Bucle por implementar
                    }*/
                }
            }
        }while(cambios!=0);
    }

    public void EscribirGrafo() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (grafo[i][j][k]) {
                        char a =conversorALetra(k);
                        System.out.println("Nodo " + i + " -> Nodo " + j + " Valor de transición: " + a + " ;");
                    }
                }
            }
        }
    }
}
