package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader
                        (CountryStatistics.class.getResourceAsStream("/" + fileName)))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(" ");
                Country country = new Country(temp[0], Integer.parseInt(temp[1]));
                countryList.add(country);

            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannor read file.", e);
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country max = countryList.get(0);
        for (Country country : countryList) {
            if (country.getBorderCountries() > max.getBorderCountries()) {
                max = country;
            }
        }
        return max;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }


}
