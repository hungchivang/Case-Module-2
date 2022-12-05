package Service;

import Compare.CompareByNumberRoom;
import Compare.CompareByPrice;
import Model.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ManageRoomCustomer {
    Scanner scanner = new Scanner(System.in);
    List<Room> listRoom = new ArrayList<>();


    public void showRoom() {
        for (Room customer : listRoom) {
            System.out.println(customer);
        }
    }

    public void showRoomBooked(){
        for (Room room : listRoom) {
            if (room.getStatus().equals("Đã đặt")) {
                System.out.println(room);
            }
        }
    }

    public void showRoomNotBook(){
        for (Room room : listRoom) {
            if (room.getStatus().equals("yes")) {
                System.out.println(room);
            }
        }
    }

    public void readFile() {
        FileInputStream fis =null;
        ObjectInputStream ois  = null;
        try {
            fis =new FileInputStream("roomAdmin.txt");
            ois = new ObjectInputStream(fis);
            listRoom = (List<Room>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos  = null;
        try {
            fos = new FileOutputStream("roomAdmin.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listRoom);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sortByPrice() {
        listRoom.sort(new CompareByPrice());
        for (int i = 0; i < listRoom.size(); i++) {
            if(listRoom.get(i).getStatus().equals("yes")){
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public void sortByNumberRoom() {
        listRoom.sort(new CompareByNumberRoom());
        for (int i = 0; i < listRoom.size(); i++) {
            if(listRoom.get(i).getStatus().equals("yes")){
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public void SearchByPrice1() {
        for (Room room : listRoom) {
            if (room.getPrice() >= 1000 && room.getPrice() <= 2500) {
                System.out.println(room);
            }
        }
    }

    public void SearchByPrice2() {
        for (Room room : listRoom) {
            if (room.getPrice() > 2500 && room.getPrice() <= 4000) {
                System.out.println(room);
            }
        }
    }

    public void SearchByPrice3() {
        for (Room room : listRoom) {
            if (room.getPrice() > 4000) {
                System.out.println(room);
            }
        }
    }

    public void SearchByAddress(String name) {
        for (Room room : listRoom) {
            if (room.getAddress().contains(name)) {
                System.out.println(room);
            }
        }
    }

    public int CheckRoomID(int id) {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getRoomId() == id) return i;
        }
        return -1;
    }

    public void bookRoom(int id) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(index).getStatus().equals("yes")) {
                    String status = "Đã đặt";
                    listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(), listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(), status));
                    System.out.println("Đặt phòng thành công");
                    return;
                }
            }
            System.out.println("Không thể đặt phòng");
        } else {
            System.out.println("Không có  id phòng này");
        }
    }

    public void CancelRoom(int id) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(index).getStatus().equals("Đã đặt")) {
                    String status = "yes";
                    listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(), listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(), status));
                    System.out.println("Hủy phòng thành công");
                    return;
                }
            }
            System.out.println("Không thể hủy");
        } else {
            System.out.println("Không có  id phòng này");
        }
    }

    public int validateInt() {
        try {
            int number = parseInt(scanner.nextLine());
            if (number >= 0) return number;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập số nguyên");
            return validateInt();
        }
    }

}
