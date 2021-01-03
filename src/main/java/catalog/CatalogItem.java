package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final String registrationNumber;
    private final int price;
    private final List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        parametersCheck(registrationNumber, price, features);

        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.addAll(Arrays.asList(features));
    }

    private void parametersCheck(String registrationNumber, int price, Feature[] features) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Registration number is needed.");
        }
        if (!(price > 0)) {
            throw new IllegalArgumentException("The price must be a positive number.");
        }
        if (features == null || features.length == 0)
            throw new IllegalArgumentException("Empty features!");
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public boolean hasPrintedFeature() {
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAudioFeature() {
        for (Feature feature : features) {
            if (feature.getClass() == AudioFeatures.class) {
                return true;
            }
        }
        return false;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature feature : features) {
            contributors.addAll(feature.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature feature : features) {
            titles.add(feature.getTitle());
        }
        return titles;
    }

    public int numberOfPagesAtOneItem() {
        int sum = 0;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                sum += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return sum;
    }


    public int fullLengthAtOneItem() {
        int sum = 0;
        for (Feature feature : features) {
            if (feature.getClass() == AudioFeatures.class) {
                sum += ((AudioFeatures) feature).getLength();
            }
        }
        return sum;
    }

}
