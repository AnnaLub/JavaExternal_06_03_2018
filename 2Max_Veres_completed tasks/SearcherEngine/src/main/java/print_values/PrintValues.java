package print_values;

import sorting_method.SortByValue;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PrintValues {

    public void printValues(Map<String, TreeMap<String, Integer>> map) {
        for(Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()){
            String key = entry.getKey();
            System.out.println("Key: ");
            System.out.println(key);
            TreeMap<String, Integer> myMap = entry.getValue();

            TreeMap<String, Integer> sorted_map = SortByValue.sortByValues(myMap);
            System.out.println("Values: ");
            for (Map.Entry<String, Integer> entry1 : sorted_map.entrySet()) {
                System.out.println(entry1.getKey() + " => " + entry1.getValue());
            }
        }
    }

    public void printFirstValues(Map<String, TreeMap<String, Integer>> map) {
        for(Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()){
            String key = entry.getKey();
            System.out.println("Key: ");
            System.out.println(key);
            TreeMap<String, Integer> myMap = entry.getValue();

            TreeMap<String, Integer> sorted_map = SortByValue.sortByValues(myMap);

            System.out.println("Value and Frequency: ");

            for (Map.Entry<String, Integer> entry1 : sorted_map.entrySet()) {
                System.out.println(entry1.getKey() + " => " + entry1.getValue());
                break;
            }
        }
    }

    public void printValues(TreeMap<String, Integer> map) {
        TreeMap<String, Integer> sorted_map = SortByValue.sortByValues(map);
        for (Map.Entry<String, Integer> entry1 : sorted_map.entrySet()) {
            System.out.println(entry1.getKey() + " => " + entry1.getValue());
        }
    }
}
