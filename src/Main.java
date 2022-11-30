import java.util.List;

import Model.Account;
import Service.ManageAccount;
import Service.ManageAccountAdmin;

public class Main {
    public static void main(String[] args) {
        ManageAccount manageAccount = new ManageAccount();
        List<Account> accounts = manageAccount.readCustomer();

        ManageAccountAdmin manageAccountAdmin = new ManageAccountAdmin();
        List<Account> accountAdmin = manageAccountAdmin.readAdmin();

        MainAdmin mainAdmin = new MainAdmin();

        int choice = -1;
        while (choice != 0) {
            System.out.println("-----------------------");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.println("Chọn 1 or 2");
            System.out.println("-----------------------");
            choice = manageAccount.validateInt();
            switch (choice) {
                case 1:
                    while (choice != 0) {
                        System.out.println("------- Log In -------");
                        System.out.println("Chức năng");
                        System.out.println("1. Đăng nhập");
                        System.out.println("2. Đăng kí");
                        System.out.println("3. Đổi mật khẩu");
                        System.out.println("0. Thoát");
                        System.out.println("Chọn chức năng");
                        System.out.println("-----------------------");
                        choice = manageAccount.validateInt();

                        switch (choice) {
                            case 1:
                                manageAccountAdmin.Login();
//                                mainAdmin.main();
                                break;
                            case 2:
                                manageAccountAdmin.Register();
                                break;
                            case 3:
                                manageAccountAdmin.SetPassword();
                                break;
                            case 0:
                                manageAccountAdmin.writeAdmin(accountAdmin);
                                break;
                        }
                    }
                    break;
                case 2:
                    while (choice != 0) {
                        System.out.println("------- Log In -------");
                        System.out.println("Chức năng");
                        System.out.println("1. Đăng nhập");
                        System.out.println("2. Đăng kí");
                        System.out.println("3. Đổi mật khẩu");
                        System.out.println("0. Thoát");
                        System.out.println("Chọn chức năng");
                        System.out.println("-----------------------");
                        choice = manageAccount.validateInt();

                        switch (choice) {
                            case 1:
                                manageAccount.Login();
                                break;
                            case 2:
                                manageAccount.Register();
                                break;
                            case 3:
                                manageAccount.SetPassword();
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