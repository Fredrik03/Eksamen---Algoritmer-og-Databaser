package Task4;

import java.util.List;
import java.util.Random;
import shared.City;

/**
 * QuickSort med teller for sammenligninger og tre pivot‑strategier.
 */
public class QuickSort {
    private enum PivotStrategy { FIRST, LAST, RANDOM }
    private static final Random RANDOM = new Random();

    // Tellere for antall sammenligninger
    private static long compFirst = 0;
    private static long compLast  = 0;
    private static long compRandom= 0;

    public static long getCompFirst()  { return compFirst;  }
    public static long getCompLast()   { return compLast;   }
    public static long getCompRandom() { return compRandom; }
    public static void resetCounters() { compFirst = compLast = compRandom = 0; }

    public static void quickSortFirst(List<City> cities) {
        resetCounters();
        quickSort(cities, 0, cities.size() - 1, PivotStrategy.FIRST);
    }

    public static void quickSortLast(List<City> cities) {
        resetCounters();
        quickSort(cities, 0, cities.size() - 1, PivotStrategy.LAST);
    }

    public static void quickSortRandom(List<City> cities) {
        resetCounters();
        quickSort(cities, 0, cities.size() - 1, PivotStrategy.RANDOM);
    }

    private static void quickSort(List<City> cities, int low, int high, PivotStrategy strategy) {
        if (low < high) {
            int p = partition(cities, low, high, strategy);
            quickSort(cities, low, p - 1, strategy);
            quickSort(cities, p + 1, high, strategy);
        }
    }

    private static int partition(List<City> cities, int low, int high, PivotStrategy strategy) {
        // Velg pivot‐indeks basert på strategi
        int pivotIndex;
        switch (strategy) {
            case FIRST:  pivotIndex = low; break;
            case LAST:   pivotIndex = high; break;
            case RANDOM: pivotIndex = low + RANDOM.nextInt(high - low + 1); break;
            default:     pivotIndex = high; break;
        }
        double pivot = cities.get(pivotIndex).getLat();
        swap(cities, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Tell sammenligning
            switch (strategy) {
                case FIRST:  compFirst++;  break;
                case LAST:   compLast++;   break;
                case RANDOM: compRandom++; break;
            }
            if (cities.get(j).getLat() < pivot) {
                i++;
                swap(cities, i, j);
            }
        }
        swap(cities, i + 1, high);
        return i + 1;
    }

    private static void swap(List<City> list, int i, int j) {
        City tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
