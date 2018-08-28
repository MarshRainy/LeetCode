public class MTools {
    public static void print2darray(int[][] a) {
        for (int[] aa : a) {
            for (int aaa : aa) {
                System.out.print(aaa);
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
