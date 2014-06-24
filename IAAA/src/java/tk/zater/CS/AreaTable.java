package tk.zater.CS;


public class AreaTable {
	private Integer id;
	private String areaName;
	private String locationName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "AreaTable{" + "id=" + id + ", areaName=" + areaName + ", locationName=" + locationName + '}';
    }

    public AreaTable(String areaName, String locationName) {
        this.areaName = areaName;
        this.locationName = locationName;
    }

    public AreaTable() {
    }
        
        
        
        
}
