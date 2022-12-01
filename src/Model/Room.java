package Model;

public class Room extends Hotel{
    static int idCurrent;
    private int roomId;
    private int numberRoom;
    private double price;
    private String address;
    private String describe;

    private String status;

    public Room() {
    }

    public Room(int numberRoom, double price, String address, String describe,String status) {

        this.roomId = ++idCurrent;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
    }

    public Room(int roomId, int numberRoom, double price, String address, String describe,String status) {
        this.roomId = roomId;
        this.numberRoom = numberRoom;
        this.price = price;
        this.address = address;
        this.describe = describe;
        this.status = status;
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
