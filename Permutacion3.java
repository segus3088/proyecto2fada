public class Permutacion3 {

    public static void main(String[] args) {
        //String[] elementos = "a,b,c,d,e".split(",");

        int[] elementos = new int[4];

        for (int o=1; o<elementos.length; o++ ) {
            elementos[o]= o;
            
        }
        int n = 5;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Perm2(elementos, "", n, r);
        System.out.println("hola 2");
    }

    private static void Perm2(int[] elem, String act, int n, int r) {
        System.out.println(act);

        if (act=="") {
            System.out.println("esta vacio");
            
        }

        String[] partecitas = act.split(" ");

        System.out.println(partecitas.length + "tamaño");

        //done deveria ccolora
        if (n == 0) {
            System.out.println(act + "hola");
        } else {
            //System.out.println(act + " yo");
            for (int i = 0; i < r; i++) {
                if (!act.contains(Integer.toString(elem[i]))) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + " ", n - 1, r);
                }
            }
        }
    }
}