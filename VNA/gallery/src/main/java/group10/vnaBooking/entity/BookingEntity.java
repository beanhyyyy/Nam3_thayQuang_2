package group10.vnaBooking.entity;

import java.util.List;

public class BookingEntity {
    private Integer id;
    private List<Object> imagesVNA;

    public BookingEntity(Integer id, List<Object> imagesVNA) {
        this.id = id;
        this.imagesVNA = imagesVNA;
    }

    public BookingEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return imagesVNA;
    }

    public void setImages(List<Object> images) {
        this.imagesVNA = images;
    }
}
