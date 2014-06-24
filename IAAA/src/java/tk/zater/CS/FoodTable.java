package tk.zater.CS;


public class FoodTable {
	private Integer id;
	private int memoId;
	private String foodStore;
	private String foodTel;
	private String foodAddress;
	private String foodTime;
	private String foodRemark;

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

    public String getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(String foodStore) {
        this.foodStore = foodStore;
    }

    public String getFoodTel() {
        return foodTel;
    }

    public void setFoodTel(String foodTel) {
        this.foodTel = foodTel;
    }

    public String getFoodAddress() {
        return foodAddress;
    }

    public void setFoodAddress(String foodAddress) {
        this.foodAddress = foodAddress;
    }

    public String getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(String foodTime) {
        this.foodTime = foodTime;
    }

    public String getFoodRemark() {
        return foodRemark;
    }

    public void setFoodRemark(String foodRemark) {
        this.foodRemark = foodRemark;
    }

    public FoodTable(int memoId, String foodStore, String foodTel, String foodAddress, String foodTime, String foodRemark) {
        this.memoId = memoId;
        this.foodStore = foodStore;
        this.foodTel = foodTel;
        this.foodAddress = foodAddress;
        this.foodTime = foodTime;
        this.foodRemark = foodRemark;
    }

    public FoodTable() {
    }
	
}
