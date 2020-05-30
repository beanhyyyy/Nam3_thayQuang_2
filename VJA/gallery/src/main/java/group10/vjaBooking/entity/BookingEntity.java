package group10.vjaBooking.entity;

import java.util.List;

public class BookingEntity {
    private Integer id;
    private List<Object> imagesVJA;

    public BookingEntity(Integer id, List<Object> imagesVJA) {
        this.id = id;
        this.imagesVJA = imagesVJA;
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
        return imagesVJA;
    }

    public void setImages(List<Object> images) {
        this.imagesVJA = images;
    }
}
