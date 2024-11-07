//package sorters;
//
//public class InsertionSort implements SortAlgorithm{
//
//    public void sort(int[] array) {
//        int n = array.length;
//        for (int i = 1; i < n; i++) {
//            int key = array[i];
//            int j = i - 1;
//            // Move os elementos que são maiores que a chave para uma posição à frente
//            while (j >= 0 && array[j] > key) {
//                array[j + 1] = array[j];
//                j = j - 1;
//            }
//            array[j + 1] = key;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "InsertionSort";
//    }
//}
//
