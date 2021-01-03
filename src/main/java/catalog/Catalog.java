package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();


    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedItems.add(catalogItem);
            }
        }
        return printedItems;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioItems.add(catalogItem);
            }
        }
        return audioItems;
    }

    public int getAllPageNumber() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.numberOfPagesAtOneItem();
        }
        return sum;
    }

    public int getFullLength() {
        int sum = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sum += catalogItem.fullLengthAtOneItem();
        }
        return sum;
    }

    public double averagePageNumberOver(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        double result = 0.0;
        int counter = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.numberOfPagesAtOneItem() > limit) {
                result += catalogItem.numberOfPagesAtOneItem();
                counter++;
            }
        }
        if (counter == 0) {
            throw new IllegalArgumentException("No page");
        }
        return result / counter;
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> resultList = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (hasTitleOrContributor(catalogItem, searchCriteria)) {
                resultList.add(catalogItem);
            }
        }
        return resultList;
    }

    private boolean hasTitleOrContributor(CatalogItem catalogItem, SearchCriteria searchCriteria) {
        return catalogItem.getContributors().contains(searchCriteria.getContributor())
                || catalogItem.getTitles().contains(searchCriteria.getTitle());
    }


    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(catalogItems.get(i));
            }
        }
    }

}
