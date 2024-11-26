// Customer.java
public class Customer {
    String name;
    String address;
    String phone;
    String purchaseHistory;

    public Customer(String name, String address, String phone, String purchaseHistory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.purchaseHistory = purchaseHistory != null ? purchaseHistory : "";
    }

    @Override
    public String toString() {
        return "Khách hàng [Tên: " + name + ", Địa chỉ: " + address + ", Số điện thoại: " + phone + ", Lịch sử mua hàng: " + purchaseHistory + "]";
    }
}
