import java.util.Arrays;

public class SimpleRecursiveFeatures {

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 1, 1, 1, 100}));
        System.out.println(sum(new int[]{1, 1, 1, 1, 100}));
        System.out.println(max(new int[]{1, 1, 1, 1, 100}));

    }

    public static int count(int[] list) {
        if (list.length == 1) {
            return list[0];
        }
        return 1 + sum(Arrays.copyOfRange(list, 1, list.length));
    }

    public static int sum(int[] list) {
        if (list.length == 1) {
            return list[0];
        }
        return list[0] + sum(Arrays.copyOfRange(list, 1, list.length));
    }

    public static int max(int[] list) {
        if (list.length == 2) {
            return Integer.max(list[0], list[1]);
        }
        return Integer.max(list[0], max(Arrays.copyOfRange(list, 1, list.length)));
    }

}
