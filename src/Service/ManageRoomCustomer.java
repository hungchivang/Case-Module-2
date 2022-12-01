package Service;

import Compare.CompareByNumberRoom;
import Compare.CompareByPrice;
import Model.Account;
import Model.Room;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ManageRoomCustomer {
    Scanner scanner = new Scanner(System.in);
    List<Room> listRoom = new ArrayList<>();

    Account account = new Account();

    public void showRoom() {
        for (Room customer : listRoom) {
            System.out.println(customer);
        }
    }

    public void showRoomBooked(){
        for (int i = 0; i < listRoom.size(); i++) {
            if(listRoom.get(i).getStatus().equals(" Đã đặt")){
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public void showRoomNotBook(){
        for (int i = 0; i < listRoom.size(); i++) {
            if(listRoom.get(i).getStatus().equals("yes")){
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public List<Room> copyFile() {
        try {
            FileReader input = new FileReader("roomAdmin.txt");
            FileWriter output = new FileWriter("roomCustomer.txt");
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

    public List<Room> readFile() {
        try {
            FileReader fileReader = new FileReader("roomCustomer.txt");
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
                String status = txt[5];
                listRoom.add(new Room(roomId, numberRoom, price, address, describe, status));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRoom;
    }

    public void writeFile(List<Room> listRoom) {
        try {
            FileWriter fileWriter = new FileWriter("roomCustomer.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : listRoom) {
                bufferedWriter.write(room.getRoomId()+ ", "+ room.getNumberRoom()+", "+room.getPrice()
                        +", "+room.getAddress()+", "+room.getDescribe()
                        + ", "+room.getStatus()+", "+ account.getUsername()+", "+account.getAge()+", "
                +account.getSdt()+", "+ account.getGender());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortByPrice() {
        listRoom.sort(new CompareByPrice());
        System.out.println(listRoom);
    }

    public void sortByNumberRoom() {
        listRoom.sort(new CompareByNumberRoom());
        System.out.println(listRoom);
    }

    public void SearchByPrice1() {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getPrice() >= 1000 && listRoom.get(i).getPrice() <= 2500) {
                System.out.println("Danh sách tìm kiếm theo giá từ 1000 -> 2500 ");
                System.out.println(listRoom);
            }
        }
    }

    public void SearchByPrice2() {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getPrice() > 2500 && listRoom.get(i).getPrice() <= 4000) {
                System.out.println("Danh sách tìm kiếm theo giá từ 2500 -> 4000 ");
                System.out.println(listRoom);
            }
        }
    }

    public void SearchByPrice3() {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getPrice() > 4000) {
                System.out.println("Danh sách tìm kiếm theo giá trên 4000 ");
                System.out.println(listRoom);
            }
        }
    }



    public void SearchByAddress(String name) {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getAddress().contains(name)) {
                System.out.println("Danh sách tìm kiếm theo địa chỉ");
                System.out.println(listRoom.get(i).toString());
            }
        }
    }

    public boolean checkStatus() {
        String status = "yes";
        for (Room customer : listRoom) {
            if (customer.getStatus().equals(status)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkStatusCancle() {
        String status = " Đã đặt";
        for (Room customer : listRoom) {
            if (customer.getStatus().equals(status)) {
                return true;
            }
        }
        return false;
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
                if (checkStatus()) {
                    String status = " Đã đặt";
                    listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(), listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(), status));
                    System.out.println("Đặt phòng thành công");
                    return;
                }
            }
            System.out.println("Đã có người đặt");
        } else {
            System.out.println("Không có  id phòng này");
        }
    }

    public void CancelRoom(int id) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (checkStatusCancle()) {
                    String status = " yes";
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
