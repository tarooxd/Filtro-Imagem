//package sorters;
//
//public class QuickSort implements SortAlgorithm{
//
//    public void sort(int[] array) {
//        quickSort(array, 0, array.length - 1);
//    }
//
//    private void quickSort(int[] array, int low, int high) {
//        if (low < high) {
//            int pi = partition(array, low, high);
//            quickSort(array, low, pi - 1);
//            quickSort(array, pi + 1, high);
//        }
//    }
//
//    private int partition(int[] array, int low, int high) {
//        int pivot = array[high];
//        int i = (low - 1); // índice do menor elemento
//        for (int j = low; j < high; j++) {
//            if (array[j] <= pivot) {
//                i++;
//                // Troca array[i] com array[j]
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//        }
//        // Troca array[i + 1] com array[high]
//        int temp = array[i + 1];
//        array[i + 1] = array[high];
//        array[high] = temp;
//        return i + 1;
//    }
//
//    @Override
//    public String toString() {
//        return "QuickSort";
//    }
//}
//
