package Task4;

import java.util.ArrayList;
import java.util.List;
import shared.City;
import shared.CSVReader;

public class QuickSortTimeDemo {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);
        System.out.println("Antall byer: " + cities.size());
        System.out.println("--------------------------------------------------");

        // 1) First element pivot
        List<City> c1 = new ArrayList<>(cities);
        long t0 = System.currentTimeMillis();
        QuickSort.quickSortFirst(c1);
        long t1 = System.currentTimeMillis();
        System.out.println("First pivot time:   " + (t1 - t0) + " ms");

        // 2) Last element pivot
        List<City> c2 = new ArrayList<>(cities);
        t0 = System.currentTimeMillis();
        QuickSort.quickSortLast(c2);
        t1 = System.currentTimeMillis();
        System.out.println("Last pivot time:    " + (t1 - t0) + " ms");

        // 3) Random pivot
        List<City> c3 = new ArrayList<>(cities);
        t0 = System.currentTimeMillis();
        QuickSort.quickSortRandom(c3);
        t1 = System.currentTimeMillis();
        System.out.println("Random pivot time:  " + (t1 - t0) + " ms");

        System.out.println("--------------------------------------------------");
    }
}
