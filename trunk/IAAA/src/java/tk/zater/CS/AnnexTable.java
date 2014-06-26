package tk.zater.CS;

public class AnnexTable {

    private Integer id;
    private int planId;
    private int memoId;
    private int foodId;
    private int pointId;
    private int hotelId;
    private String annexURL;

    public AnnexTable(String annexURL) {
        this.annexURL = annexURL;
    }

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

   

    public String getAnnexURL() {
        return annexURL;
    }

    public void setAnnexURL(String annexURL) {
        this.annexURL = annexURL;
    }

    @Override
    public String toString() {
        return "AnnexTable{" + "id=" + id + ", planId=" + planId + ", memoId=" + memoId + ", foodId=" + foodId + ", pointId=" + pointId + ", hotelId=" + hotelId + ", annexURL=" + annexURL + '}';
    }

   

    public AnnexTable() {
    }

    

}
