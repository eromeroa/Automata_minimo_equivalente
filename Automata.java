public class Automata {

    private boolean[][][] grafo;

    public Automata(int i){
        switch(i){
            case 1: automato1();
            break;
            case 2: automato2();
            break;
            case 3: automatoG();
        }
    }


    private void automato1(){
        System.out.println("\nHas seleccionado el automato de ejemplo 1");
        grafo = new boolean[8][8][2];
    }
    private void automato2(){

        System.out.println("\nHas seleccionado el automato de ejemplo 2");
    }
    private void automatoG(){

        System.out.println("\nHas seleccionado otro automato");
    }
}
