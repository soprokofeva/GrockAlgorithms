import java.util.*;

public class SortSearch {

    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<>(Arrays.asList(4, 2, 5, 3))));
    }

    private static List<Integer> sort(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list.size());

        int smallest;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            smallest = findSmallestIndex(list);
            sortedList.add(list.get(smallest));
            list.remove(smallest);
        }
        return sortedList;
    }


    private static int findSmallestIndex(List<Integer> list) {
        int minInd = 0;
        int minElem = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < minElem) {
                minElem = list.get(i);
                minInd = i;
            }
        }
        return minInd;
    }
}
