package shared;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {
    public static List<City> readCitiesFromCSV(String filePath) {
        List<City> cities = new ArrayList<>();
        // Regex for å finne innholdet mellom doble anførselstegn
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                // Hopp over header-linjen
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                Matcher matcher = pattern.matcher(line);
                List<String> fields = new ArrayList<>();
                while (matcher.find()) {
                    fields.add(matcher.group(1));
                }
                // Sjekk at vi har nok felter (her forventes 11)
                if (fields.size() < 11) {
                    continue;
                }
                String city = fields.get(0);
                String cityAscii = fields.get(1);
                double lat = Double.parseDouble(fields.get(2).trim());
                double lng = Double.parseDouble(fields.get(3).trim());
                String country = fields.get(4);
                String iso2 = fields.get(5);
                String iso3 = fields.get(6);
                String adminName = fields.get(7);
                String capital = fields.get(8);
                String population = fields.get(9);
                String id = fields.get(10);

                cities.add(new City(city, cityAscii, lat, lng, country, iso2, iso3, adminName, capital, population, id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
