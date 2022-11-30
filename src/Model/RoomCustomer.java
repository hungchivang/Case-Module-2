package Model;

public class RoomCustomer extends Room{
    private String name;
    private int age;
private int sdt;
    private String gender;

    public RoomCustomer() {
    }

    public RoomCustomer(String name, int age, String gender, int sdt) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sdt = sdt;
    }

    public RoomCustomer(int roomId, int numberRoom, double price, String address, String describe, String name, int age, String gender, int sdt) {
        super(roomId, numberRoom, price, address, describe);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sdt = sdt;
    }

    public RoomCustomer(int roomId, int numberRoom, double price, String address, String describe) {
        super(roomId,numberRoom,price,address,describe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return super.toString() + "\n";
    }

}
