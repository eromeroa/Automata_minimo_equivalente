import java.util.Scanner;

public class Alfabeto {

    //Los arrays de Strings alfa*****Pred contienen los nombres predeterminados para nos nodos y las transiciones
    private String[] alfaNodosPred = {"p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19"};
    private String[] alfaTransPred = {"a", "b", "c", "d", "e", "f", "g"};
    private String[] alfaNodos;
    private String[] alfaTrans;

    public Alfabeto(int tipoAlf){
        switch (tipoAlf){
            case 1: tipo1();
                    break;
            case 2: tipo2();
                    break;
            case 3: ejemplo1();
                    break;
            case 4: ejemplo2();
                    break;
        }
    }

    //Genera el alfabeto de tipo 1 (nombres predeterminados eligiendo número de nodos y transiciones)
    private void tipo1(){
        Scanner sc = new Scanner(System.in);
        int nodos, trans;

        do {
            System.out.println("\nIntroduce el numero de nodos (minimo 1, maximo 20):");
            nodos = sc.nextInt();
            if (nodos <= 0 || nodos > 20) System.out.println("\nEl numero indicado no es valido\n");
        }while(nodos<=0||nodos>20);
        alfaNodos = new String[nodos];

        do {
            System.out.println("\nIntroduce el numero de valores distintos para las transiciones (minimo 1, maximo 7):\n");
            trans = sc.nextInt();
            if (trans <= 0 || trans > 7) System.out.println("\nEl numero indicado no es valido\n");
        }while(trans<=0||trans>7);
        alfaTrans = new String[trans];

        System.out.println("\nLos nodos disponibles son: ");
        for(int i=0; i<nodos; i++) {
            alfaNodos[i] = alfaNodosPred[i];
            System.out.println(alfaNodos[i] + " ");
        }

        System.out.println("\nLas transiciones disponibles son: ");
        for(int i=0; i<trans; i++) {
            alfaTrans[i] = alfaTransPred[i];
            System.out.println(alfaTrans[i] + " ");
        }

        sc.close();
    }

    //Genera el alfabeto de tipo 2 (numero y nombres de nodos y transiciones personalizables)
    private void tipo2(){
        Scanner sc = new Scanner(System.in);
        int nodos=-99, trans=-99;

        do {
            if (nodos != -99 || nodos <= 0) System.out.println("El numero indicado no es valido");
            System.out.println("\nIntroduce el numero de nodos (maximo 20):");
            nodos = sc.nextInt();
        }while(nodos<=0);
        alfaNodos = new String[nodos];

        do {
            if (trans != -99 || trans <= 0) System.out.println("El numero indicado no es valido");
            System.out.println("\nIntroduce el numero de valores distintos para las transiciones (maximo 7):\n");
            trans = sc.nextInt();
        }while(trans<=0);
        alfaTrans = new String[trans];

        System.out.println("\nIntroduce un nombre para cada nodo: ");
        for(int i=0; i<nodos; i++) {
            System.out.println("Nodo " + i + ": ");
            alfaNodos[i] = sc.nextLine();
            System.out.println("\n");
        }
        for(int i=0; i<trans; i++) {
            System.out.println("Nodo " + i + ": ");
            alfaTrans[i] = sc.nextLine();
            System.out.println("\n");
        }

        sc.close();
    }

    private void ejemplo1(){
        int nodos = 8, trans = 2;
        alfaNodos = new String[nodos];
        alfaTrans = new String[trans];
        for (int i=0; i<nodos; i++) alfaNodos[i] = alfaNodosPred[i];
        for (int i=0; i<trans; i++) alfaTrans[i] = alfaTransPred[i];
    }

    private void ejemplo2(){
        int nodos = 5, trans = 2;
        alfaNodos = new String[nodos];
        alfaTrans = new String[trans];
        for (int i=0; i<nodos; i++) alfaNodos[i] = alfaNodosPred[i];
        for (int i=0; i<trans; i++) alfaTrans[i] = alfaTransPred[i];
    }

    public int getNodos(){
        return alfaNodos.length;
    }

    public int getTransiciones(){
        return alfaTrans.length;
    }

    public String intToStringNodo(int nodo){
        String nodoS = "";
        if (nodo >= 0 && nodo < alfaNodos.length) nodoS = alfaNodos[nodo];
        return nodoS;
    }

    public String intToStringTrans(int trans){
        String transS = "";
        if (trans >= 0 && trans < alfaTrans.length) transS = alfaNodos[trans];
        return transS;
    }

    public int StringToIntNodo(String nodo){
        boolean encontrado = false;
        int nodoS = -99, i=0;
        do{
            if (nodo.equals(alfaNodos[i])) {
                nodoS = i;
                encontrado = true;
            }
            i++;
        }while(i<alfaNodos.length && !encontrado);
        return nodoS;
    }

    public int StringToIntTrans(String trans){
        boolean encontrado = false;
        int transS = -99, i=0;
        do{
            if (trans.equals(alfaTrans[i])) {
                transS = i;
                encontrado = true;
            }
            i++;
        }while(i<alfaTrans.length && !encontrado);
        return transS;
    }

}
