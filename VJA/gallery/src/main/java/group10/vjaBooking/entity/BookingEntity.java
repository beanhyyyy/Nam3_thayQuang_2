package group10.vjaBooking.entity;

import java.util.List;

public class BookingEntity {
    private Integer id;
    private List<Object> images;

    public BookingEntity(Integer id, List<Object> images) {
        this.id = id;
        this.images = images;
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
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }
}
