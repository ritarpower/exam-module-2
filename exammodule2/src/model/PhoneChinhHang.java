package model;

public class PhoneChinhHang extends Phone {
    int timeDate;
    String area;

    public PhoneChinhHang(int id, String name, double price, int amount, String type, int timeDate, String area) {
        super(id, name, price, amount, type);
        this.timeDate = timeDate;
        this.area = area;
    }

    public int getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(int timeDate) {
        this.timeDate = timeDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "PhoneChinhHang{" + "id=" + getId() + ", name='" + getName() + "', price=" + getPrice() + ", amount= " +
                getAmount() + ", type='" + getType() + "', timeDate=" + timeDate + ", area='" + area + "'}";
    }
}
