package Service;

import Compare.CompareByNumberRoom;
import Compare.CompareByPrice;
import Model.Room;
import Model.RoomCustomer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ManageRoomCustomer {
    Scanner scanner = new Scanner(System.in);
    List<RoomCustomer> listRoom = new ArrayList<>();

    public List<RoomCustomer> copyFile() {
        try {
            FileReader input = new FileReader("roomAdmin.txt");
            FileWriter output = new FileWriter("ghiroom.txt");
            int line;
            while ((line = input.read()) != -1) {
                output.write(line);
            }
            output.close();
            input.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listRoom;
    }

    public List<RoomCustomer> readFile() {
        try {
            FileReader fileReader = new FileReader("ghiroom.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(", ");
                int roomId = parseInt(txt[0]);
                int numberRoom = parseInt(txt[1]);
                double price = Double.parseDouble(txt[2]);
                String address = txt[3];
                String describe = txt[4];
                listRoom.add(new RoomCustomer(roomId,numberRoom,price,address,describe));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }

    public void sortByPrice() {
        listRoom.sort(new CompareByPrice());
        System.out.println(listRoom);
    }

    public void sortByNumberRoom() {
        listRoom.sort(new CompareByNumberRoom());
        System.out.println(listRoom);
    }

    public void SearchByAddress(String name) {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getAddress().contains(name)) {
                System.out.println("Danh sách tìm kiếm theo địa chỉ");
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public void SearchByPrice(Double price) {
        for (RoomCustomer roomCustomer : listRoom) {
            if (roomCustomer.getPrice() == price) {
                System.out.println("Danh sách tìm kiếm theo giá");
                System.out.println(roomCustomer.toString());
            }
        }
    }

    public int validateInt() {
        try {
            int number = parseInt(scanner.nextLine());
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
