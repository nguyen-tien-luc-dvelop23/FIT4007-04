public class Employee {
    String name;
    String id;
    String position;
    String address;
    String phone;
    String email;

    public Employee(String name, String id, String position, String address, String phone, String email) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nhân viên [Tên: " + name + ", Mã nhân viên: " + id + ", Chức vụ: " + position + ", Địa chỉ: " + address + ", Số điện thoại: " + phone + ", Email: " + email + "]";
    }
}
