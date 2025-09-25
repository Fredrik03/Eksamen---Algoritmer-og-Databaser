package Task1;

import shared.City;
import java.util.List;

public class InefficientBubbleSort {
    public static int sortByLatitude(List<City> cities) {
        int n = cities.size();
        int swapCount = 0; // Teller hvor mange ganger elementer byttes

        // Denne ytre løkken kjører n ganger, selv om listen kan bli sortert før vi har gått gjennom alle passeringene.
        for (int i = 0; i < n; i++) {
            // Den indre løkken sammenligner og bytter naboelementer for hver passering.
            for (int j = 0; j < n - 1; j++) {
                if (cities.get(j).getLat() > cities.get(j + 1).getLat()) {
                    // Bytt plass på elementene
                    City temp = cities.get(j);
                    cities.set(j, cities.get(j + 1));
                    cities.set(j + 1, temp);
                    swapCount++; // Registrer at et bytte har skjedd
                }
            }
        }
        return swapCount;
    }
}
