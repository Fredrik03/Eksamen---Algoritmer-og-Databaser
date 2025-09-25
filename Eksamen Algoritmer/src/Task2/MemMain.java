package Task2;

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
        System.out.println("Måling av minnebruk (Insertion Sort):");

        // 1. MINNEBRUK – ORIGINAL REKKEFØLGE
        List<City> originalListMem = new ArrayList<>(cities);
        long memBeforeOriginal = getUsedMemory();
        InsertionSort.insertionSortByLatitude(originalListMem);
        long memAfterOriginal = getUsedMemory();
        long diffOriginal = memAfterOriginal - memBeforeOriginal;
        System.out.println("Test 1: Original rekkefølge:");
        System.out.println("  Før sortering: " + memBeforeOriginal + " bytes");
        System.out.println("  Etter sortering: " + memAfterOriginal + " bytes");
        System.out.println("  Endring: " + diffOriginal + " bytes");
        System.out.println();

        // 2. MINNEBRUK – ALLEREDER SORTERT LISTE (bestefall)
        List<City> sortedListMem = new ArrayList<>(cities);
        InsertionSort.insertionSortByLatitude(sortedListMem); // Gjør listen sortert
        long memBeforeSorted = getUsedMemory();
        InsertionSort.insertionSortByLatitude(sortedListMem);
        long memAfterSorted = getUsedMemory();
        long diffSorted = memAfterSorted - memBeforeSorted;
        System.out.println("Test 2: Allerede sortert liste (bestefall):");
        System.out.println("  Før sortering: " + memBeforeSorted + " bytes");
        System.out.println("  Etter sortering: " + memAfterSorted + " bytes");
        System.out.println("  Endring: " + diffSorted + " bytes");
        System.out.println();

        // 3. MINNEBRUK – TILFELDIG STOKKET LISTE (gjennomsnitt/verstefall)
        List<City> shuffledListMem = new ArrayList<>(cities);
        Collections.shuffle(shuffledListMem);
        long memBeforeShuffled = getUsedMemory();
        InsertionSort.insertionSortByLatitude(shuffledListMem);
        long memAfterShuffled = getUsedMemory();
        long diffShuffled = memAfterShuffled - memBeforeShuffled;
        System.out.println("Test 3: Tilfeldig stokket liste:");
        System.out.println("  Før sortering: " + memBeforeShuffled + " bytes");
        System.out.println("  Etter sortering: " + memAfterShuffled + " bytes");
        System.out.println("  Endring: " + diffShuffled + " bytes");
        System.out.println("--------------------------------------------------");
    }

    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
