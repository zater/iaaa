package tk.zater.CS;


public class HotelTable {
	private Integer id;
	private int memoId;
	private String hotelName;
	private String hotelTel;
	private String hotelAddress;
	private String htotelRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMemoId() {
        return memoId;
    }

    public void setMemoId(int memoId) {
        this.memoId = memoId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHtotelRemark() {
        return htotelRemark;
    }

    public void setHtotelRemark(String htotelRemark) {
        this.htotelRemark = htotelRemark;
    }

    public HotelTable(Integer id, int memoId, String hotelName, String hotelTel, String hotelAddress, String htotelRemark) {
        this.id = id;
        this.memoId = memoId;
        this.hotelName = hotelName;
        this.hotelTel = hotelTel;
        this.hotelAddress = hotelAddress;
        this.htotelRemark = htotelRemark;
    }

    public HotelTable(int memoId, String hotelName, String hotelTel, String hotelAddress, String htotelRemark) {
        this.memoId = memoId;
        this.hotelName = hotelName;
        this.hotelTel = hotelTel;
        this.hotelAddress = hotelAddress;
        this.htotelRemark = htotelRemark;
    }

    @Override
    public String toString() {
        return "HotelTable{" + "id=" + id + ", memoId=" + memoId + ", hotelName=" + hotelName + ", hotelTel=" + hotelTel + ", hotelAddress=" + hotelAddress + ", htotelRemark=" + htotelRemark + '}';
    }
	
}
