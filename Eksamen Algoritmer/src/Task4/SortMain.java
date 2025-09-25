package Task4;
import shared.City;
import shared.CSVReader;

import static Task4.QuickSort.*;
import java.util.ArrayList;
import java.util.List;


public class SortMain {
    public static void main(String[] args) {
        String filepath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        List<City> citiesFirst = CSVReader.readCitiesFromCSV(filepath);

        quickSortFirst(citiesFirst);
        System.out.println("Sortert ved bruk av first element: ");
        for(City city : citiesFirst) {
            System.out.println(city);
        }
    }
}
