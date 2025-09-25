package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shared.City;
import shared.CSVReader;

public class MemMain {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        // Les CSV-filen og få en liste med City-objekter
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);

        System.out.println("--------------------------------------------------");
        System.out.println("Måling av minnebruk (Merge Sort):");

        // 1. MINNEBRUK – ORIGINAL REKKEFØLGE
        List<City> original = new ArrayList<>(cities);
        long beforeOriginal = getUsedMemory();
        MergeSort.mergeSortByLatitude(original);
        long afterOriginal = getUsedMemory();
        printMemory("Original rekkefølge", beforeOriginal, afterOriginal);

        // 2. MINNEBRUK – ALLEREDER SORTERT LISTE (bestefall)
        List<City> sorted = new ArrayList<>(cities);
        MergeSort.mergeSortByLatitude(sorted);  // gjør listen sortert
        long beforeSorted = getUsedMemory();
        MergeSort.mergeSortByLatitude(sorted);
        long afterSorted = getUsedMemory();
        printMemory("Allerede sortert liste (bestefall)", beforeSorted, afterSorted);

        // 3. MINNEBRUK – TILFELDIG STOKKET LISTE (gjennomsnitt/verstefall)
        List<City> shuffled = new ArrayList<>(cities);
        Collections.shuffle(shuffled);
        long beforeShuffled = getUsedMemory();
        MergeSort.mergeSortByLatitude(shuffled);
        long afterShuffled = getUsedMemory();
        printMemory("Tilfeldig stokket liste", beforeShuffled, afterShuffled);

        System.out.println("--------------------------------------------------");
    }

    private static void printMemory(String label, long before, long after) {
        long diff = after - before;
        System.out.println("Test: " + label);
        System.out.println("  Før sortering:  " + before  + " bytes");
        System.out.println("  Etter sortering: " + after   + " bytes");
        System.out.println("  Endring:        " + diff    + " bytes\n");
    }

    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
