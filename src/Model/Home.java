package Model;

import java.io.Serializable;

public class Home implements Serializable {
    private int roomId;
    private int numberRoom;
    private double price;
    private String address;
    private String describe;
    private String status;

    private String username;
    private String password;
    private String name;
    private int age;
    private String sdt;
    private String gender;

    public Home() {
    }

    public Home(int roomId, int numberRoom, double price, String address, String describe, String status, String username, String password, String name, int age, String sdt, String gender) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sdt = sdt;
        this.gender = gender;
    }

    public Home(int roomId, int numberRoom, double price, String address, String describe, String status, String name, int age, String sdt, String gender) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
        this.name = name;
        this.age = age;
        this.sdt = sdt;
        this.gender = gender;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Hotel{}";
    }
}
