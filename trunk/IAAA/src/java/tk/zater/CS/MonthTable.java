package tk.zater.CS;


public class MonthTable {
	private Integer id;
	private int planId;
	private int month;

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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public MonthTable() {
    }

    public MonthTable(Integer id, int planId, int month) {
        this.id = id;
        this.planId = planId;
        this.month = month;
    }

    public MonthTable(int planId, int month) {
        this.planId = planId;
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthTable{" + "id=" + id + ", planId=" + planId + ", month=" + month + '}';
    }
        
}
