package tk.zater.CS;


public class UserLvTable {
	private Integer id;
	private String userTitle;
	private String Remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public UserLvTable(String userTitle, String Remark) {
        this.userTitle = userTitle;
        this.Remark = Remark;
    }

    @Override
    public String toString() {
        return "UserLvTable{" + "id=" + id + ", userTitle=" + userTitle + ", Remark=" + Remark + '}';
    }

    public UserLvTable() {
    }
        
        
        
}
