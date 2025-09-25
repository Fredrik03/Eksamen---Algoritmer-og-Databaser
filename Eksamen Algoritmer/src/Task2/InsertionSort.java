package Task2;

import java.util.List;
import shared.City;

public class InsertionSort {

    // En liten hjelpeklasse for å returnere både antall bytter og antall sammenligninger
    public static class SortMetrics {
        public int swaps;
        public int comparisons;

        public SortMetrics(int swaps, int comparisons) {
            this.swaps = swaps;
            this.comparisons = comparisons;
        }
    }

    public static SortMetrics insertionSortByLatitude(List<City> cities) {
        int swapCount = 0;
        int comparisonCount = 0;

        for (int i = 1; i < cities.size(); i++) {
            City key = cities.get(i);
            int j = i - 1;

            while (j >= 0) {
                comparisonCount++; // Teller sammenligning
                if (cities.get(j).getLat() > key.getLat()) {
                    swapCount++;
                    cities.set(j + 1, cities.get(j));
                    j--;
                } else {
                    break;
                }
            }
            cities.set(j + 1, key);
        }
        return new SortMetrics(swapCount, comparisonCount);
    }
}