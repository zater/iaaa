package tk.zater.CS;


public class PlanTable {
	private Integer id;
	private int userId;
	private int days;
	private String topic;
	private String abstracts;
	private String characteristic;
	private int price;
        private int download;
	private double score;
        private String cover;
        private String plantype;
        private boolean gone;

    public boolean isGone() {
        return gone;
    }

    public void setGone(boolean gone) {
        this.gone = gone;
    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPlantype() {
        return plantype;
    }

    public void setPlantype(String plantype) {
        this.plantype = plantype;
    }

   
    public PlanTable() {
    }

    public PlanTable(Integer id, int userId, int days, String topic, String abstracts, String characteristic, int price, int download, double score, String cover, String plantype) {
        this.id = id;
        this.userId = userId;
        this.days = days;
        this.topic = topic;
        this.abstracts = abstracts;
        this.characteristic = characteristic;
        this.price = price;
        this.download = download;
        this.score = score;
        this.cover = cover;
        this.plantype = plantype;
    }

    
    @Override
    public String toString() {
        return "PlanTable{" + "id=" + id + ", userId=" + userId + ", days=" + days + ", topic=" + topic + ", abstracts=" + abstracts + ", characteristic=" + characteristic + ", price=" + price + ", download=" + download + ", score=" + score + '}';
    }

    
        
        
}
