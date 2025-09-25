package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shared.CSVReader;
import shared.City;

public class SwapsMain {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);

        // 1. ORIGINAL REKKEFØLGE
        List<City> originalList = new ArrayList<>(cities);
        InsertionSort.SortMetrics metricsOriginal = InsertionSort.insertionSortByLatitude(originalList);
        System.out.println("Sortert (original rekkefølge):");
        System.out.println("  Bytter: " + metricsOriginal.swaps +
                ", Sammenligninger: " + metricsOriginal.comparisons);

        // 2. ALLEREDER SORTERT (bestefall)
        List<City> sortedList = new ArrayList<>(cities);
        // Først sortere for å gjøre den "allerede sortert"
        InsertionSort.insertionSortByLatitude(sortedList);

        // Så telle bytter og sammenligninger
        InsertionSort.SortMetrics metricsSorted = InsertionSort.insertionSortByLatitude(sortedList);
        System.out.println("\nSortert (allerede sortert):");
        System.out.println("  Bytter: " + metricsSorted.swaps +
                ", Sammenligninger: " + metricsSorted.comparisons);

        // 3. TILFELDIG STOKKET (gjennomsnitt/verstefall)
        List<City> shuffledList = new ArrayList<>(cities);
        Collections.shuffle(shuffledList);
        InsertionSort.SortMetrics metricsShuffled = InsertionSort.insertionSortByLatitude(shuffledList);
        System.out.println("\nSortert (tilfeldig stokket):");
        System.out.println("  Bytter: " + metricsShuffled.swaps +
                ", Sammenligninger: " + metricsShuffled.comparisons);
    }
}
