package Task1;

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
        System.out.println("Måling av minnebruk (optimalisert Bubble Sort):");

        // 1. MINNEBRUK – ORIGINAL REKKEFØLGE
        List<City> originalListMem = new ArrayList<>(cities);
        long memBeforeOriginal = getUsedMemory();
        Bubblesort.bubbleSortByLatitude(originalListMem);
        long memAfterOriginal = getUsedMemory();
        long diffOriginal = memAfterOriginal - memBeforeOriginal;
        System.out.println("Test 1: Original rekkefølge:");
        System.out.println("  Før sortering: " + memBeforeOriginal + " bytes");
        System.out.println("  Etter sortering: " + memAfterOriginal + " bytes");
        System.out.println("  Endring: " + diffOriginal + " bytes");
        System.out.println();

        // 2. MINNEBRUK – ALLEREDER SORTERT LISTE (bestefall)
        List<City> sortedListMem = new ArrayList<>(cities);
        Bubblesort.bubbleSortByLatitude(sortedListMem); // Gjør listen sortert
        long memBeforeSorted = getUsedMemory();
        Bubblesort.bubbleSortByLatitude(sortedListMem);
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
        Bubblesort.bubbleSortByLatitude(shuffledListMem);
        long memAfterShuffled = getUsedMemory();
        long diffShuffled = memAfterShuffled - memBeforeShuffled;
        System.out.println("Test 3: Tilfeldig stokket liste:");
        System.out.println("  Før sortering: " + memBeforeShuffled + " bytes");
        System.out.println("  Etter sortering: " + memAfterShuffled + " bytes");
        System.out.println("  Endring: " + diffShuffled + " bytes");
        System.out.println("--------------------------------------------------");

        System.out.println("Måling av minnebruk (uoptimalisert Bubble Sort):");

        // 4. MINNEBRUK – ORIGINAL REKKEFØLGE med ineffektiv Bubble Sort
        List<City> originalListIneff = new ArrayList<>(cities);
        long memBeforeOriginalIneff = getUsedMemory();
        InefficientBubbleSort.sortByLatitude(originalListIneff);
        long memAfterOriginalIneff = getUsedMemory();
        long diffOriginalIneff = memAfterOriginalIneff - memBeforeOriginalIneff;
        System.out.println("Test 4: Original rekkefølge:");
        System.out.println("  Før sortering: " + memBeforeOriginalIneff + " bytes");
        System.out.println("  Etter sortering: " + memAfterOriginalIneff + " bytes");
        System.out.println("  Endring: " + diffOriginalIneff + " bytes");
        System.out.println();

        // 5. MINNEBRUK – ALLEREDER SORTERT LISTE
        List<City> sortedListIneff = new ArrayList<>(cities);
        InefficientBubbleSort.sortByLatitude(sortedListIneff); // Gjør listen sortert
        long memBeforeSortedIneff = getUsedMemory();
        InefficientBubbleSort.sortByLatitude(sortedListIneff);
        long memAfterSortedIneff = getUsedMemory();
        long diffSortedIneff = memAfterSortedIneff - memBeforeSortedIneff;
        System.out.println("Test 5: Allerede sortert liste:");
        System.out.println("  Før sortering: " + memBeforeSortedIneff + " bytes");
        System.out.println("  Etter sortering: " + memAfterSortedIneff + " bytes");
        System.out.println("  Endring: " + diffSortedIneff + " bytes");
        System.out.println();

        // 6. MINNEBRUK – TILFELDIG STOKKET LISTE
        List<City> shuffledListIneff = new ArrayList<>(cities);
        Collections.shuffle(shuffledListIneff);
        long memBeforeShuffledIneff = getUsedMemory();
        InefficientBubbleSort.sortByLatitude(shuffledListIneff);
        long memAfterShuffledIneff = getUsedMemory();
        long diffShuffledIneff = memAfterShuffledIneff - memBeforeShuffledIneff;
        System.out.println("Test 6: Tilfeldig stokket liste:");
        System.out.println("  Før sortering: " + memBeforeShuffledIneff + " bytes");
        System.out.println("  Etter sortering: " + memAfterShuffledIneff + " bytes");
        System.out.println("  Endring: " + diffShuffledIneff + " bytes");
    }

    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();  // Be GC rydde opp for en mer nøyaktig måling
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
