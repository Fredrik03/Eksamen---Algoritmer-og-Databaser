package Task1;
import shared.City;

import java.util.List;

public class Bubblesort {
    public static int bubbleSortByLatitude(List<City> cities) {
        int n = cities.size();
        boolean swapped;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (cities.get(j).getLat() > cities.get(j + 1).getLat()) {
                    City temp = cities.get(j);
                    cities.set(j, cities.get(j + 1));
                    cities.set(j + 1, temp);
                    swapped = true;
                    swapCount++;
                }
            }
            if (!swapped) break;
        }

        return swapCount;
    }

}
