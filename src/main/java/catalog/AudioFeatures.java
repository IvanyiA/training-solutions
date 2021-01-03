package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final String title;
    private final int length;
    private List<String> composer;
    private final List<String> performers;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("Composer is needed.");
        }
        this.composer = composer;
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        parametersCheck(title, length, performers);
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(composer);
        contributors.addAll(performers);
        return contributors;
    }

    private void parametersCheck(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is missing.");
        }
        if (!(length > 0)) {
            throw new IllegalArgumentException("Invalid length.");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Performer is needed.");
        }
    }

}
