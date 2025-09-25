package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shared.City;
import shared.CSVReader;

public class TimeMain {

    public static void main(String[] args) {
        // Sett inn korrekt filbane til CSV-filen
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";

        // Les CSV-filen og få en liste med City-objekter
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);
        System.out.println("Antall byer: " + cities.size());

        // 1. Original rekkefølge (datasettet slik det kommer fra CSV)
        List<City> originalList = new ArrayList<>(cities);
        long startOriginal = System.currentTimeMillis();
        InsertionSort.insertionSortByLatitude(originalList);
        long endOriginal = System.currentTimeMillis();
        System.out.println("Tid (original rekkefølge): " + (endOriginal - startOriginal) + " ms");

        // 2. Sortert liste (bestefall)
        List<City> sortedList = new ArrayList<>(cities);
        // Første sortering for å gjøre listen sortert
        InsertionSort.insertionSortByLatitude(sortedList);
        // Måler deretter sortering på en allerede sortert liste
        long startSorted = System.currentTimeMillis();
        InsertionSort.insertionSortByLatitude(sortedList);
        long endSorted = System.currentTimeMillis();
        System.out.println("Tid (allerede sortert): " + (endSorted - startSorted) + " ms");

        // 3. Tilfeldig stokket liste (gjennomsnitt/verstefall)
        List<City> shuffledList = new ArrayList<>(cities);
        Collections.shuffle(shuffledList); // Stokker listen tilfeldig
        long startShuffled = System.currentTimeMillis();
        InsertionSort.insertionSortByLatitude(shuffledList);
        long endShuffled = System.currentTimeMillis();
        System.out.println("Tid (stokket): " + (endShuffled - startShuffled) + " ms");

        System.out.println("-----------------------------------------------");
    }
}
