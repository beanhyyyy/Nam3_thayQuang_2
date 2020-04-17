package group10.vnaTicket.image.entity;

public class ImageEntity {
    private Integer id;
    private String ngaydi;
    private String ngayve;
    private String noidi;
    private String noiden;
    private Integer nguoilon;
    private Integer treem;
    private Integer embe;
    private String hangbay;
    
    public ImageEntity(Integer id, String hangbay, String ngaydi, String ngayve, String noidi, String noiden, Integer nguoilon, Integer treem, Integer embe) {
        this.id = id;
        this.hangbay= hangbay;
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.noidi = noidi;
        this.noiden = noiden;
        this.nguoilon = nguoilon;
        this.treem = treem;
        this.embe = embe;
        // hang bay
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getHangbay() {
        return hangbay;
    }

    public void setHangbay(String hangbay) {
        this.hangbay = hangbay;
    }
    
    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getNgayve() {
        return ngayve;
    }

    public void setNgayve(String ngayve) {
        this.ngayve = ngayve;
    }
    
    //
    public String getNoidi() {
        return noidi;
    }

    public void setNoidi(String noidi) {
        this.noidi = noidi;
    }
    
    //
    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }
    
    //
    public Integer getNguoilon() {
        return nguoilon;
    }

    public void setNguoilon(Integer nguoilon) {
        this.nguoilon = nguoilon;
    }
    
    //
    public Integer getTreem() {
        return treem;
    }

    public void setTreem(Integer treem) {
        this.treem = treem;
    }
    
    //
    public Integer getEmbe() {
        return embe;
    }

    public void setEmbe(Integer embe) {
        this.embe = embe;
    }
    
}
