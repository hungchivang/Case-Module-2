package Model;

import java.io.Serializable;

public class Room extends Home implements Serializable {
    private int roomId;
    private int numberRoom;
    private double price;
    private String address;
    private String describe;

    private String status;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Room() {
    }

    public Room(int roomId, int numberRoom, double price, String address, String describe, String status) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
    }

    public Room(int roomId, int numberRoom, double price, String address, String describe, String status, String username) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
        this.username = username;
    }



    @Override
    public String toString() {
        return "roomId = " + roomId +
                ", numberRoom = " + numberRoom +
                ", price = " + price +
                ", address = " + address +
                ", describe = " + describe +
                ", status = " + status;
    }
}
