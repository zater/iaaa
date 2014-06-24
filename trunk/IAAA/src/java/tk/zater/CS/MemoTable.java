package tk.zater.CS;


public class MemoTable {
	private Integer id;
	private int planId;
	private int day;
	private String memo;
	private String memoTraffic;

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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemoTraffic() {
        return memoTraffic;
    }

    public void setMemoTraffic(String memoTraffic) {
        this.memoTraffic = memoTraffic;
    }

    @Override
    public String toString() {
        return "MemoTable{" + "id=" + id + ", planId=" + planId + ", day=" + day + ", memo=" + memo + ", memoTraffic=" + memoTraffic + '}';
    }

    public MemoTable() {
    }

    public MemoTable(int planId, int day, String memo, String memoTraffic) {
        this.planId = planId;
        this.day = day;
        this.memo = memo;
        this.memoTraffic = memoTraffic;
    }
	
}
