package Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shared.CSVReader;
import shared.City;

public class Main2 {

    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        // Les CSV-filen og få en liste med Task1.City-objekter
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);
        System.out.println("Antall byer: " + cities.size());

        // 1. Original rekkefølge (datasettet slik det kommer fra CSV)
        List<City> originalList = new ArrayList<>(cities);
        long startOriginal = System.currentTimeMillis();
        Bubblesort.bubbleSortByLatitude(originalList);
        long endOriginal = System.currentTimeMillis();
        System.out.println("Tid (original rekkefølge): " + (endOriginal - startOriginal) + " ms");


        // 2. Sortert liste (bestefall)
        List<City> sortedList = new ArrayList<>(cities);
        // Først sorterer vi for å sikre at listen er helt sortert
        Bubblesort.bubbleSortByLatitude(sortedList);
        // Måler deretter sortering på en allerede sortert liste
        long startSorted = System.currentTimeMillis();
        Bubblesort.bubbleSortByLatitude(sortedList);
        long endSorted = System.currentTimeMillis();

        // 3. Tilfeldig stokket liste (gjennomsnitt/verstefall)
        List<City> shuffledList = new ArrayList<>(cities);
        Collections.shuffle(shuffledList); // Shuffler kortene til en tilfeldig rekkefølge
        long startShuffled = System.currentTimeMillis();
        Bubblesort.bubbleSortByLatitude(shuffledList);
        long endShuffled = System.currentTimeMillis();
        System.out.println("Tid (stokket): " + (endShuffled - startShuffled) + " ms");

        System.out.println("-----------------------------------------------");

        // 4. Original rekkefølge (datasettet slik det kommer fra CSV)
        List<City> originalList2 = new ArrayList<>(cities);
        long startOriginal2 = System.currentTimeMillis();
        InefficientBubbleSort.sortByLatitude(originalList2);
        long endOriginal2 = System.currentTimeMillis();
        System.out.println("Tid (original rekkefølge uoptimalisert): " + (endOriginal2 - startOriginal2) + " ms");


        // 5. Sortert liste (bestefall)
        List<City> sortedList2 = new ArrayList<>(cities);
        // Først sorterer vi for å sikre at listen er helt sortert
        InefficientBubbleSort.sortByLatitude(sortedList2);
        // Måler deretter sortering på en allerede sortert liste
        long startSorted2 = System.currentTimeMillis();
        InefficientBubbleSort.sortByLatitude(sortedList2);
        long endSorted2 = System.currentTimeMillis();
        System.out.println("Tid (allerede sortert uoptimalisert): " + (endSorted2 - startSorted2) + " ms");

        // 6. Tilfeldig stokket liste (gjennomsnitt/verstefall)
        List<City> shuffledList2 = new ArrayList<>(cities);
        Collections.shuffle(shuffledList2); // Shuffler kortene til en tilfeldig rekkefølge
        long startShuffled2 = System.currentTimeMillis();
        InefficientBubbleSort.sortByLatitude(shuffledList);
        long endShuffled2 = System.currentTimeMillis();
        System.out.println("Tid (stokket uoptimalisert): " + (endShuffled2 - startShuffled2) + " ms");
    }
}





