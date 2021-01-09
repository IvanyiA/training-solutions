package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {


    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... originalPhotos) {

        for (String photo : originalPhotos) {
            photos.add(new Photo(photo));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                return;
            }

        }
        throw new PhotoNotFoundException("Cannot find photo.");
    }


    public int numberOfStars() {

        int sum = 0;
        for (Photo photo : photos) {
            sum += photo.getQuality().getStars();
        }
        return sum;
    }


    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }
}
