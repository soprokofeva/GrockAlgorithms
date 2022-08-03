import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {

    public static void main(String[] args) {

        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        nums = Arrays.stream(nums).sorted().toArray();
        System.out.println(binarySearch(nums, 43));

        System.out.println(binarySearch(new int[]{3, 4, 8, 10, 18}, 8));
        System.out.println(recursiveBinarySearch(new int[]{3, 4, 8, 10, 18}, 8));
    }

    public static int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int recursiveBinarySearch(int[] list, int item) {
        if (list == null) {
            return -1;
        }
        return recursiveBinarySearch(list, item, 0, list.length - 1);
    }

    private static int recursiveBinarySearch(int[] list, int item, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (high + low) / 2;
        int guess = list[mid];

        if (guess == item) {
            return mid;
        } else if (guess < item) {
            low = mid + 1;
            return recursiveBinarySearch(list, item, low, high);
        } else {
            high = mid - 1;
            return recursiveBinarySearch(list, item, low, high);
        }

    }
}
