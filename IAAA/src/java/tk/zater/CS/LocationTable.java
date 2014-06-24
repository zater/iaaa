package tk.zater.CS;


public class LocationTable {
	private Integer id;
	private int planId;
	private String locationName;

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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationTable(int planId, String locationName) {
        this.planId = planId;
        this.locationName = locationName;
    }

    public LocationTable() {
    }

    @Override
    public String toString() {
        return "LocationTable{" + "id=" + id + ", planId=" + planId + ", locationName=" + locationName + '}';
    }
	
}
