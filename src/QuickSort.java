
public class QuickSort {


    public static void main(String[] args) {

        int[] list = new int[] {4, 2, 6, 5, 3, 0, 9};
        quickSort(list);
        for(int elem : list) {
            System.out.println(elem);
        }
    }

    public static void quickSort(int[] list) {
        if (list == null) {
            return;
        }
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int low, int high) {
        if (list.length == 1) {
            return;
        }

        int i = low;
        int j = high;
        int pivot = list[(i + j) / 2];

        while (i <= j) {
            while (list[i] < pivot) {
                i++;
            }
            while (list[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                i++;
                j--;
            }

        }
        if (j > low) {
            quickSort(list, low, j);
        }
        if (i < high) {
            quickSort(list, i, high);
        }

    }

}
