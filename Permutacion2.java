public class Permutacion2 {

    public static void main(String[] args) {
        String[] elementos = "a,b,c,d,e".split(",");
        int n = 5;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Perm2(elementos, "", n, r);
    }

    private static void Perm2(String[] elem, String act, int n, int r) {
        //System.out.println(act);
        if (n == 0) {
            System.out.println(act + "hola");
        } else {
            //System.out.println(act + " yo");
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r);
                }
            }
        }
    }
}
