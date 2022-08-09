package greedy;

import java.util.*;

public class RadioStations {

    public static void main(String[] args) {
        Set<String> stationNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Hashtable<String, LinkedHashSet<String>> stations = new Hashtable<>();
        stations.put("kone", new LinkedHashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new LinkedHashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new LinkedHashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new LinkedHashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new LinkedHashSet<>(Arrays.asList("ca", "az")));

        Set<String> finalStations = new LinkedHashSet<>();

        while (!stationNeeded.isEmpty()) {
            String bestStation = "";
            Set<String> statesCovered = new HashSet<>();
            for (Map.Entry<String, LinkedHashSet<String>> station : stations.entrySet()) {
                Set<String> covered = station.getValue();
                covered.retainAll(stationNeeded);
                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            stationNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        finalStations.stream().forEach(System.out::println);

    }
}
