import Model.Account;
import Service.ManageAccountCustomer;
import Service.ManageAccountAdmin;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ManageAccountAdmin manageAccountAdmin = new ManageAccountAdmin();
        manageAccountAdmin.readAdmin();
        manageAccountAdmin.readAccCustomer();

        ManageAccountCustomer manageAccountCustomer = new ManageAccountCustomer();
        List<Account> accounts = manageAccountCustomer.readCustomer();


        int choice = -1;
        while (choice != 0) {
            System.out.println("-----------------------");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            choice = manageAccountCustomer.validateInt();
            switch (choice) {
                case 1:
                    manageAccountAdmin.Login();
                    break;
                case 2:
                    int choice1 = -1;
                    while (choice1 != 0) {
                        System.out.println("-----------------");
                        System.out.println("1. Đăng nhập");
                        System.out.println("2. Đăng kí");
                        System.out.println("0. Thoát");
                        System.out.println("-----------------");
                        choice1 = manageAccountCustomer.validateInt();
                        switch (choice1) {
                            case 1 -> manageAccountCustomer.Login();
                            case 2 -> manageAccountCustomer.Register();
                            case 0 -> manageAccountCustomer.writeCustomer(accounts);
                        }
                    }
                    break;
                case 0:
                    break;
            }
        }
    }
}