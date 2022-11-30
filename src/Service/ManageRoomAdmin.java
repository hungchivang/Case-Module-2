package Service;

import Model.Account;
import Model.Room;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Nhập số phòng");
        int numberRoom = validateInt();
        System.out.println("Nhâp giá");
        double price = validateDouble();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập mô tả");
        String describe = scanner.nextLine();
        return new Room(numberRoom, price,address,describe);
    }

    public void add(){
        rooms.add(CreateRoom());
    }

    public int CheckRoomID(int id) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId() ==id) return i;
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
                        "5. OK");
                System.out.println("Chọn ");
                System.out.println("---------------------");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập số phòng cần sửa");
                        int numberRoom = validateInt();
                        rooms.set(index, new Room(id, numberRoom, rooms.get(index).getPrice(), rooms.get(index).getAddress(), rooms.get(index).getDescribe()));
                        break;
                    case 2:
                        System.out.println("Nhập giá tiền cần sửa");
                        double price = validateDouble();
                        rooms.set(index, new Room(id,rooms.get(index).getNumberRoom(), price, rooms.get(index).getAddress(), rooms.get(index).getDescribe()));
                        break;
                    case 3:
                        System.out.println("Sửa địa chỉ");
                        String address = scanner.nextLine();
                        rooms.set(index, new Room(id, rooms.get(index).getNumberRoom(), rooms.get(index).getPrice(),address,rooms.get(index).getDescribe()));
                        break;
                    case 4:
                        System.out.println("Sửa mô tả");
                        String describe = scanner.nextLine();
                        rooms.set(index, new Room(id, rooms.get(index).getNumberRoom(), rooms.get(index).getPrice(),rooms.get(index).getAddress(),describe ));
                        break;
                    case 5:
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

    public List<Room> readRoom() {
        try {
            FileReader fileReader = new FileReader("roomAdmin.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(";");
                int roomId = Integer.parseInt(txt[0]);
                int numberRoom = Integer.parseInt(txt[1]);
                double price = Double.parseDouble(txt[2]);
                String address = txt[3];
                String describe = txt[4];
                rooms.add(new Room(roomId,numberRoom,price,address,describe));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }


    public void writeRoom(List<Room> rooms) {
        try {
            FileWriter fileWriter = new FileWriter("roomAdmin.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : rooms) {
                bufferedWriter.write(room.getRoomId()+ ", "+ room.getNumberRoom()+", "+room.getPrice()+", "+room.getAddress()+", "+room.getDescribe());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
