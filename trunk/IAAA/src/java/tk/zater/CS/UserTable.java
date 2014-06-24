package tk.zater.CS;

import java.util.Date;

public class UserTable {

    private Integer id;
    private String accountName;
    private String pwd;
    private String userName;
    private String email;
    private Date addDate;
    private String address;
    private String tel;
    private int userLv;
    private int userScore;
    private String inrtoduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getUserLv() {
        return userLv;
    }

    public void setUserLv(int userLv) {
        this.userLv = userLv;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getInrtoduction() {
        return inrtoduction;
    }

    public void setInrtoduction(String inrtoduction) {
        this.inrtoduction = inrtoduction;
    }

    @Override
    public String toString() {
        return "UserTable{" + "id=" + id + ", accountName=" + accountName + ", pwd=" + pwd + ", userName=" + userName + ", email=" + email + ", addDate=" + addDate + ", address=" + address + ", tel=" + tel + ", userLv=" + userLv + ", userScore=" + userScore + ", inrtoduction=" + inrtoduction + '}';
    }

    public UserTable() {
    }

    public UserTable(String accountName, String pwd, String userName, String email, Date addDate, String address, String tel, int userLv, int userScore, String inrtoduction) {
        this.accountName = accountName;
        this.pwd = pwd;
        this.userName = userName;
        this.email = email;
        this.addDate = addDate;
        this.address = address;
        this.tel = tel;
        this.userLv = userLv;
        this.userScore = userScore;
        this.inrtoduction = inrtoduction;
    }

    public UserTable(String pwd, String userName) {
        this.pwd = pwd;
        this.userName = userName;
    }

    
}
