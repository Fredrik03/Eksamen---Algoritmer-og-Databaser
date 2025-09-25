package Task2;

import java.util.List;
import shared.CSVReader;
import shared.City;

public class SortMain {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);
        System.out.println("Før sortering: ");


        for(City city : cities) {
            System.out.println(city);
        }

        InsertionSort.insertionSortByLatitude(cities);
        System.out.println("\nEtter sortering (basert på latitude): ");

        for(City city : cities) {
            System.out.println(city);
        }
    }
}