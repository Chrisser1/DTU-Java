public class Opgave1 {
    public static void main(String[] args) throws Exception {
        int[][] arr1 = {{1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}};
        int[][] arr2 = {{1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}};

        System.out.println(equal(arr1, arr2));
    }

    private static boolean equal(int[][] arr1, int[][] arr2) {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
