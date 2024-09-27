package model;

public class PhoneXachTay extends Phone {
    String country;
    String status;

    public PhoneXachTay(int id, String name, double price, int amount, String type, String country, String status) {
        super(id, name, price, amount, type);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "PhoneXachTay{" + "id=" + getId() + ", name='" + getName() + "', price=" + getPrice() + ", amount= " +
                getAmount() + ", type='" + getType() + "', country=" + country + ", status='" + status + "'}";
    }
}
