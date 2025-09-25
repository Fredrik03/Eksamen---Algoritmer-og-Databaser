package Task3;
import shared.CSVReader;
import shared.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergesMain {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);

        // Normal (original) order
        MergeSort.resetMergeCount();
        MergeSort.mergeSortByLatitude(cities);
        System.out.println("Antall merges (original order): " + MergeSort.getMergeCount());

        // Reset list and shuffle
        List<City> shuffled = new ArrayList<>(cities);
        Collections.shuffle(shuffled);
        MergeSort.resetMergeCount();
        MergeSort.mergeSortByLatitude(shuffled);
        System.out.println("Antall merges (shuffled order):  " + MergeSort.getMergeCount());
    }
}
