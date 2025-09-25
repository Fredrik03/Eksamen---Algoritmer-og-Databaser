package Task4;

import shared.CSVReader;
import shared.City;

import java.util.List;

import static Task4.QuickSort.*;

public class CompareMain {


    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> original = CSVReader.readCitiesFromCSV(filePath);

       // First-element pivot
        resetCounters();
        List<City> list1 = new java.util.ArrayList<>(original);
        quickSortFirst(list1);
        System.out.println("Comparisons (First pivot): " + getCompFirst());

        // Last-element pivot
        resetCounters();
        List<City> list2 = new java.util.ArrayList<>(original);
        quickSortLast(list2);
        System.out.println("Comparisons (Last pivot): " + getCompLast());

        // Random pivot
        resetCounters();
        List<City> list3 = new java.util.ArrayList<>(original);
        quickSortRandom(list3);
        System.out.println("Comparisons (Random pivot): " + getCompRandom());
    }
}

