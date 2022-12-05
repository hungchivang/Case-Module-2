package Service;

import Model.Account;
import Model.Home;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ManageHome {
    List<Home> homes = new ArrayList<>();
ManageAccountCustomer manageAccountCustomer= new ManageAccountCustomer();
    List<Account> accounts = manageAccountCustomer.readCustomer();

    public void readHome() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("roomAdmin.txt");
            ois = new ObjectInputStream(fis);
            homes = (List<Home>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showCustomer() {
        for (int i = 0; i < homes.size(); i++) {
            if (homes.get(i).getStatus().equals("Đã đặt")) {
                System.out.println("roomId = " + homes.get(i).getRoomId() +
                        ", price = " + homes.get(i).getPrice() +
                        ", name = " + accounts.get(i).getName() +
                        ", age = " + accounts.get(i).getAge() +
                        ", sdt = " + accounts.get(i).getSdt() +
                        ", gender = " + accounts.get(i).getGender());
            }
        }
    }

    public void showRoomNotBook() {
        for (Home home : homes) {
            if (home.getStatus().equals("yes")) {
                System.out.println("roomId = " + home.getRoomId() +
                        ", numberRoom = " + home.getNumberRoom() +
                        ", price = " + home.getPrice() +
                        ", address = " + home.getAddress() +
                        ", describe = " + home.getDescribe() +
                        ", status = " + home.getStatus());
            }
        }
    }
}
