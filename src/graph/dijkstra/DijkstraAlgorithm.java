package graph.dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DijkstraAlgorithm {

    static final String START = "start";
    static final String A = "A";
    static final String B = "B";
    static final String END = "end";


    public static void main(String[] args) {
        Hashtable<String, Hashtable<String, Integer>> graph = new Hashtable<>();
        graph.put(START, new Hashtable<>());
        graph.get(START).put(A, 6);
        graph.get(START).put(B, 2);

        graph.put(A, new Hashtable<>());
        graph.get(A).put(END, 1);

        graph.put(B, new Hashtable<>());
        graph.get(B).put(A, 3);
        graph.get(B).put(END, 5);

        graph.put(END, new Hashtable<>());

        Hashtable<String, Integer> costs = new Hashtable<>();
        costs.put(A, 6);
        costs.put(B, 2);
        costs.put(END, Integer.MAX_VALUE);

        Hashtable<String, String> parents = new Hashtable<>();
        parents.put(A, START);
        parents.put(B, START);
        parents.put(END, "");

        List<String> processedNodes = new ArrayList<>();

        String nodeName = findLowestCostNodeName(costs, processedNodes);
        while (!nodeName.isEmpty()) {
            Integer cost = costs.get(nodeName);
            for (Map.Entry<String, Integer> neighbor : graph.get(nodeName).entrySet()) {
                String neibName = neighbor.getKey();
                Integer neibCost = cost + neighbor.getValue();
                if (costs.get(neibName) > neibCost) {
                    costs.put(neibName, neibCost);
                    parents.put(neibName, nodeName);
                }

            }
            processedNodes.add(nodeName);
            nodeName = findLowestCostNodeName(costs, processedNodes);
        }
        printResultPath(costs, parents);

    }

    public static String findLowestCostNodeName(Hashtable<String, Integer> costs, List<String> processedNodes) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostName = "";

        for (Map.Entry<String, Integer> node : costs.entrySet()) {
            int cost = node.getValue();
            if (cost < lowestCost && !processedNodes.contains(node.getKey())) {
                lowestCost = cost;
                lowestCostName = node.getKey();
            }

        }
        return lowestCostName;
    }

    public static void printResultPath(Hashtable<String, Integer> costs, Hashtable<String, String> parents) {
        StringBuilder nodePath = new StringBuilder();
        nodePath.append(END + " : " + costs.get(END));
        String name = parents.get(END);
        while (name != null) {
            nodePath.append(" --->  (" + name + " : " + costs.get(name) + ")");
            name = parents.get(name);
        }
        System.out.println(nodePath);
    }

}
