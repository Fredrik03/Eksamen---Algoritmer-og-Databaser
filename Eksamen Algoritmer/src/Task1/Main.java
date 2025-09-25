package Task1;

import shared.City;
import shared.CSVReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Denne klassen viser hvor mange bytter som trengs basert.

public class Main {
    public static void main(String[] args) {
        String filePath = "Eksamen Algoritmer/Databaser/worldcities.csv";
        // Les CSV-filen og få en liste med Task1.City-objekter
        List<City> cities = CSVReader.readCitiesFromCSV(filePath);

        // 1. ORIGINAL REKKEFØLGE (slik dataene kommer fra CSV-filen)
        List<City> originalList = new ArrayList<>(cities);
        int swapsOriginal = Bubblesort.bubbleSortByLatitude(originalList);
        System.out.println("Antall bytter (original rekkefølge): " + swapsOriginal);

        // 2. ALLEREDER SORTERT LISTE (bestefall)
        List<City> sortedList = new ArrayList<>(cities);
        Bubblesort.bubbleSortByLatitude(sortedList); // Første sortering for å gjøre listen helt sortert
        int swapsSorted = Bubblesort.bubbleSortByLatitude(sortedList); // Nå skal den oppdage at listen er sortert
        System.out.println("Antall bytter (allerede sortert liste): " + swapsSorted);

        // 3. TILFELDIG STOKKET LISTE (gjennomsnitt/verstefall)
        List<City> shuffledList = new ArrayList<>(cities);
        Collections.shuffle(shuffledList);  // Shuffler til en tilfeldig rekkefølge
        int swapsShuffled = Bubblesort.bubbleSortByLatitude(shuffledList);
        System.out.println("Antall bytter (etter tilfeldig stokking): " + swapsShuffled);

        System.out.println("-----------------------------------------------");

        // 4. ORIGINAL REKKEFØLGE (slik dataene kommer fra CSV-filen) - UOPTIMALISERT
        List<City> originalList2 = new ArrayList<>(cities);
        int swapsOriginal2 = InefficientBubbleSort.sortByLatitude(originalList2);
        System.out.println("Antall bytter (original rekkefølge UOPTIMALISERT): " + swapsOriginal2);

       // 5. ALLEREDER SORTERT LISTE (bestefall) - UOPTIMALISERT
        List<City> sortedList2 = new ArrayList<>(cities);
        InefficientBubbleSort.sortByLatitude(sortedList2); // Første sortering for å gjøre listen helt sortert
        int swapsSorted2 = InefficientBubbleSort.sortByLatitude(sortedList2); // Nå skal den oppdage at listen er sortert
        System.out.println("Antall bytter (allerede sortert liste UOPTIMALISERT): " + swapsSorted2);

        // 6. TILFELDIG STOKKET LISTE (gjennomsnitt/verstefall) - UOPTIMALISERT
        List<City> shuffledList2 = new ArrayList<>(cities);
        Collections.shuffle(shuffledList2);  // Shuffler til en tilfeldig rekkefølge
        int swapsShuffled2 = InefficientBubbleSort.sortByLatitude(shuffledList2);
        System.out.println("Antall bytter (etter tilfeldig stokking UOPTIMALISERT): " + swapsShuffled2);


    }
}


