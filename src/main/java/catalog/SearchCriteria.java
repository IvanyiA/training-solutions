package catalog;

public final class SearchCriteria {

    public String title;
    public String contributor;


    public SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public boolean hasContributor() {
        return !(contributor == null || "".equals(contributor));
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Invalid search criteria.");
        }
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Invalid contributor.");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Invalid title.");
        }
        return new SearchCriteria(title, null);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}
