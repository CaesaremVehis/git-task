public class Main {
    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;

    public static void main(String[] args) {
        int size = firstArray.length + secondArray.length;
        resultArray = new int[size];
        int j = firstArray.length;
        for (int i = 0; i < firstArray.length; i++) {
            resultArray[i] = firstArray[i];
        }
        for (int i = 0; i < secondArray.length; i++) {
            resultArray[j] = secondArray[i];
            j++;
        }

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}
