package Service;

import Model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MangeHotel {
    List<Hotel> hotels = new ArrayList<>();

    public List<Hotel> readRoomBooked() {
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
                int roomId = Integer.parseInt(txt[0]);
                int numberRoom = Integer.parseInt(txt[1]);
                double price = Double.parseDouble(txt[2]);
                String address = txt[3];
                String describe = txt[4];
                String status = txt[5];
                String name = txt[6];
                int age = Integer.parseInt(txt[7]);
                String sdt = txt[8];
                String gender = txt[9];
                hotels.add(new Hotel(roomId,numberRoom,price,address,describe,status,name,age,sdt,gender));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public void showCustomer(){
        for (int i = 0; i < hotels.size(); i++) {
            if(hotels.get(i).getStatus().equals(" Đã đặt")){
                System.out.println("Thông tin nhân viên đã đặt");
                System.out.println(hotels.get(i).getRoomId()+ ", " +hotels.get(i).getName()+ ", "+hotels.get(i).getAge()+ ", "
                +hotels.get(i).getSdt()+ ", "+hotels.get(i).getGender());
            }
        }
    }

    public void showRoomNotBook(){
        for (int i = 0; i < hotels.size(); i++) {
            if(hotels.get(i).getStatus().equals("yes")){
                System.out.println("Thông tin nhân viên đã đặt");
                System.out.println("roomId = " + hotels.get(i).getRoomId() +
                        ", numberRoom = " + hotels.get(i).getNumberRoom() +
                        ", price = " + hotels.get(i).getPrice() +
                        ", address = " + hotels.get(i).getAddress() +
                        ", describe = " + hotels.get(i).getDescribe() +
                        ", status = " + hotels.get(i).getStatus());
            }
        }
    }
}
