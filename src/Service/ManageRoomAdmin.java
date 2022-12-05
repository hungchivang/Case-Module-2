package Service;

import Model.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ManageRoomAdmin {
    Scanner scanner = new Scanner(System.in);
    List<Room> rooms = new ArrayList<>();

    public void show() {
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }
    public Room CreateRoom(){
        int roomId = 1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.size() == 0) {
                roomId = 1;

            } else {
                roomId = rooms.get(rooms.size()-1).getRoomId() +1;
            }
        }

        System.out.println("Nhập số phòng");
        int numberRoom = validateInt();
        System.out.println("Nhâp giá");
        double price = validateDouble();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập mô tả");
        String describe = scanner.nextLine();
        System.out.println("Tình trạng ");
        String status = validateStatus();

        return new Room(roomId,numberRoom, price,address,describe,status);
    }

    public void add(){
        rooms.add(CreateRoom());
    }



    public int CheckRoomID(int id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId() == id) return i;
        }
        return -1;
    }

    public void Edit(int id) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            while (true) {
                System.out.println("---------------------");
                System.out.println("Thông tin muốn sửa :");
                System.out.println("1. Sửa số phòng\n" +
                        "2. Sửa giá tiền\n" +
                        "3. Sửa địa chỉ\n" +
                        "4. Sửa mô tả\n" +
                        "5. Sửa tình trạng\n" +
                        "6. OK");
                System.out.println("Chọn ");
                System.out.println("---------------------");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập số phòng cần sửa");
                        int numberRoom = validateInt();
                        rooms.set(index, new Room(id, numberRoom, rooms.get(index).getPrice(), rooms.get(index).getAddress(), rooms.get(index).getDescribe(),rooms.get(index).getStatus()));
                        break;
                    case 2:
                        System.out.println("Nhập giá tiền cần sửa");
                        double price = validateDouble();
                        rooms.set(index, new Room(id,rooms.get(index).getNumberRoom(), price, rooms.get(index).getAddress(), rooms.get(index).getDescribe(),rooms.get(index).getStatus()));
                        break;
                    case 3:
                        System.out.println("Sửa địa chỉ");
                        String address = scanner.nextLine();
                        rooms.set(index, new Room(id, rooms.get(index).getNumberRoom(), rooms.get(index).getPrice(),address,rooms.get(index).getDescribe(),rooms.get(index).getStatus()));
                        break;
                    case 4:
                        System.out.println("Sửa mô tả");
                        String describe = scanner.nextLine();
                        rooms.set(index, new Room(id, rooms.get(index).getNumberRoom(), rooms.get(index).getPrice(),rooms.get(index).getAddress(),describe,rooms.get(index).getStatus() ));
                        break;
                    case 5:
                        System.out.println("Sửa đổi tình trạng");
                        String status = scanner.nextLine();
                        rooms.set(index, new Room(id, rooms.get(index).getNumberRoom(), rooms.get(index).getPrice(),rooms.get(index).getAddress(),rooms.get(index).getDescribe(),status));
                        break;
                    case 6:
                        return;
                }
                System.out.println("Đã sửa thông tin phòng");
            }
        } else {
            System.out.println("không có id phòng này");
        }
    }

    public void Delete(int id) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            rooms.remove(index);
            System.out.println("Đã xóa phòng ");
        } else {
            System.out.println("Không có phòng này");
        }
    }

    public void readRoom() {
        FileInputStream fis =null;
        ObjectInputStream ois  = null;
        try {
            fis =new FileInputStream("roomAdmin.txt");
            ois = new ObjectInputStream(fis);
            rooms = (List<Room>) ois.readObject();
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

    public void writeRoom() {
        FileOutputStream fos =null;
        ObjectOutputStream oos  = null;
        try {
            fos = new FileOutputStream("roomAdmin.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(rooms);
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

    public String validateStatus() {
        try {
            String status = scanner.nextLine();
            if (Objects.equals(status, "yes") || Objects.equals(status, "no")) return status;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập : yes or no ");
            return validateStatus();
        }
    }
    public int validateInt() {
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 0) return number;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phai nhap so ( > 0)");
            return validateInt();
        }
    }

    public int validateDouble() {
        try {
            double number = Double.parseDouble(scanner.nextLine());
            if (number > 0) return (int) number;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phai nhap so ( > 0)");
            return validateDouble();
        }
    }
}
