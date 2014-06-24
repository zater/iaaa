package tk.zater.CS;


public class AnnexTable {
	private Integer id;
	private int planId;
	private int memoId;
	private int foodId;
	private int pointId;
	private int hotelId;
	private byte cover;
	private String annexName;
	private String annexURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getMemoId() {
        return memoId;
    }

    public void setMemoId(int memoId) {
        this.memoId = memoId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public byte getCover() {
        return cover;
    }

    public void setCover(byte cover) {
        this.cover = cover;
    }



    public String getAnnexName() {
        return annexName;
    }

    public void setAnnexName(String annexName) {
        this.annexName = annexName;
    }

    public String getAnnexURL() {
        return annexURL;
    }

    public void setAnnexURL(String annexURL) {
        this.annexURL = annexURL;
    }

    @Override
    public String toString() {
        return "AnnexTable{" + "id=" + id + ", planId=" + planId + ", memoId=" + memoId + ", foodId=" + foodId + ", pointId=" + pointId + ", hotelId=" + hotelId + ", cover=" + cover + ", annexName=" + annexName + ", annexURL=" + annexURL + '}';
    }

    public AnnexTable() {
    }

    public AnnexTable(int planId, int memoId, int foodId, int pointId, int hotelId, byte cover, String annexName, String annexURL) {
        this.planId = planId;
        this.memoId = memoId;
        this.foodId = foodId;
        this.pointId = pointId;
        this.hotelId = hotelId;
        this.cover = cover;
        this.annexName = annexName;
        this.annexURL = annexURL;
    }

   
        
        
        
}
