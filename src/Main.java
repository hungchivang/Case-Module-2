import Model.Account;
import Service.ManageAccount;
import Service.ManageAccountAdmin;
import view.ViewAdmin;
import view.ViewCustomer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ManageAccountAdmin manageAccountAdmin = new ManageAccountAdmin();
        manageAccountAdmin.readAdmin();

        ManageAccount manageAccount = new ManageAccount();
        List<Account> accounts = manageAccount.readCustomer();


        int choice = -1;
        while (choice != 0) {
            System.out.println("-----------------------");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            choice = manageAccount.validateInt();
            switch (choice) {
                case 1:
                    manageAccountAdmin.Login();
                    break;
                case 2:
                    int choice1 = -1;
                    while (choice1 != 0){
                        System.out.println("-----------------");
                        System.out.println("1. Đăng nhập");
                        System.out.println("2. Đăng kí");
                        System.out.println("0. Thoát");
                        System.out.println("-----------------");
                        choice1 = manageAccount.validateInt();
                        switch (choice1){
                            case 1:
                                manageAccount.Login();
                                break;
                            case 2:
                                manageAccount.Register();
                                break;
                            case 0:
                                manageAccount.writeCustomer(accounts);
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