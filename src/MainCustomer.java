import Model.RoomCustomer;
import Service.ManageRoomCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCustomer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageRoomCustomer manageRoomCustomer = new ManageRoomCustomer();
        manageRoomCustomer.copyFile();
        manageRoomCustomer.readFile();
        List<RoomCustomer> listRoom = new ArrayList<>();

        int choice = -1;
        while (choice != 0){
            System.out.println("---------------------");
            System.out.println("1. Sắp xếp");
            System.out.println("2. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.println("---------------------");
            choice = manageRoomCustomer.validateInt();
            switch (choice){
                case 1:
                    int choice2 = -1;
                    while (choice2 != 0){
                        System.out.println("---------------------");
                        System.out.println("1. Sắp xếp theo giá");
                        System.out.println("2. Sắp xếp theo số phòng");
                        System.out.println("0 . Thoát");
                        System.out.println("---------------------");
                        choice2 = manageRoomCustomer.validateInt();
                        switch (choice2){
                            case 1:
                                manageRoomCustomer.sortByPrice();
                                break;
                            case 2:
                                manageRoomCustomer.sortByNumberRoom();
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 2:
                    int choice3 = -1;
                    while (choice3 != 0){
                        System.out.println("---------------------");
                        System.out.println("1. Tìm kiếm theo giá");
                        System.out.println("2. Tìm kếm theo địa chỉ");
                        System.out.println("0 . Thoát");
                        System.out.println("---------------------");
                        choice3 = manageRoomCustomer.validateInt();
                        switch (choice3){
                            case 1:
                                System.out.println("Nhập tiền muốn tìm");
                                double price = manageRoomCustomer.validateDouble();
                                manageRoomCustomer.SearchByPrice(price);
                                break;
                            case 2:
                                System.out.println("Nhập địa chỉ muốn tìm");
                                String name = scanner.nextLine();
                                manageRoomCustomer.SearchByAddress(name);
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 0:
                    break;
            }
        }
    }
}
