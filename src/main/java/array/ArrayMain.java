package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] napok = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(napok[1]);
        System.out.println(napok.length);

        int[] kettoHatvanyai = new int[5];
        kettoHatvanyai[0] = 1;
        for (int i = 1; i < kettoHatvanyai.length; i++) {
            kettoHatvanyai[i] = kettoHatvanyai[i - 1] * 2;
        }
        for (int i = 0; i < kettoHatvanyai.length; i++) {
            System.out.println(kettoHatvanyai[i]);
        }

        boolean[] valtozo = new boolean[6];

        for (int i = 1; i < valtozo.length; i++){
            valtozo [i] = !valtozo [i-1];
        }

        for (int i = 0; i < valtozo.length; i++) {
            System.out.println(valtozo[i]);
        }


    }
}
