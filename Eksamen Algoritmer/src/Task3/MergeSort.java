package Task3;

import java.util.ArrayList;
import java.util.List;
import shared.City;


public class MergeSort {

    private static int mergeCount = 0;


    public static int getMergeCount() {
        return mergeCount;
    }

    public static void resetMergeCount() {
        mergeCount = 0;
    }


    public static void mergeSortByLatitude(List<City> cities) {
        if (cities == null || cities.size() < 2) {
            return;
        }

        // Del listen i to halvdeler
        int mid = cities.size() / 2;
        List<City> left  = new ArrayList<>(cities.subList(0, mid));
        List<City> right = new ArrayList<>(cities.subList(mid, cities.size()));

        // Rekursiv sortering av hver halvdel
        mergeSortByLatitude(left);
        mergeSortByLatitude(right);

        // Sammenslåing av de sorterte halvdelene tilbake i originallisten
        merge(cities, left, right);
    }


    private static void merge(List<City> dest, List<City> left, List<City> right) {
        mergeCount++; // tell én merge-operasjon
        int i = 0, j = 0, k = 0;

        // Compare and merge elements from left and right sublists, inserting the lower latitude first
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getLat() <= right.get(j).getLat()) {
                dest.set(k++, left.get(i++));
            } else {
                dest.set(k++, right.get(j++));
            }
        }

        // Copy any remaining elements from left sublist
        while (i < left.size()) {
            dest.set(k++, left.get(i++));
        }

        // Copy any remaining elements from right sublist
        while (j < right.size()) {
            dest.set(k++, right.get(j++));
        }
    }
}
