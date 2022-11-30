package Model;

public class Room {
    static int idCurrent;
    private int roomId;
    private int numberRoom;
    private double price;
    private String address;
    private String describe;

    public Room() {
    }

    public Room(int numberRoom, double price, String address, String describe) {

        this.roomId = ++idCurrent;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
    }

    public Room(int roomId, int numberRoom, double price, String address, String describe) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
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

    @Override
    public String toString() {
        return "roomId = " + roomId +
                ", numberRoom = " + numberRoom +
                ", price = " + price +
                ", address = " + address +
                ", describe = " + describe ;
    }
}
