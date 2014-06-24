package tk.zater.CS;


public class PointTable {

    private Integer id;
    private int memoId;
    private String pointName;
    private String pointSummary;
    private int pointNum;

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

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointSummary() {
        return pointSummary;
    }

    public void setPointSummary(String pointSummary) {
        this.pointSummary = pointSummary;
    }

    public int getPointNum() {
        return pointNum;
    }

    public void setPointNum(int pointNum) {
        this.pointNum = pointNum;
    }

    public PointTable() {
    }

    public PointTable(Integer id, int memoId, String pointName, String pointSummary, int pointNum) {
        this.id = id;
        this.memoId = memoId;
        this.pointName = pointName;
        this.pointSummary = pointSummary;
        this.pointNum = pointNum;
    }

}
