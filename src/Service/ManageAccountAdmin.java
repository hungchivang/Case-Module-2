package Service;

import Model.Account;
import Model.Room;
import view.ViewAdmin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManageAccountAdmin {
    Scanner scanner = new Scanner(System.in);
ViewAdmin viewAdmin = new ViewAdmin();
    List<Account> accountsAdmin = new ArrayList<>();
    List<Account> accountsCustomer = new ArrayList<>();


    public int CheckUsername(String username) {
        for (int i = 0; i < accountsAdmin.size(); i++) {
            if (username.equals(accountsAdmin.get(i).getUsername())) return i;
        }
        return -1;
    }

    public void Login() {
        System.out.println("---Đăng nhập---");
        System.out.println("Nhập tài khoản ");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu ");
        String password = scanner.nextLine();
        int index = CheckUsername(username);
        if (index >= 0) {
            for (int i = 0; i < accountsAdmin.size(); i++) {
                if (password.equals(accountsAdmin.get(index).getPassword())) {
                    System.out.println("Đăng nhập thành công");
                    viewAdmin.viewAdmin();
                    return;
                }
            }
            System.out.println("Mật khẩu sai");
        } else {
            System.out.println("Tài khoản này không tồn tại");
        }
    }

    public void SetPassword() {
        System.out.println("Nhập tài khoản cũ ");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu cũ");
        String password = scanner.nextLine();
        int index = CheckUsername(username);
        if (index >= 0) {
            for (int i = 0; i < accountsAdmin.size(); i++) {
                if (accountsAdmin.get(index).getPassword().equals(password)) {
                    System.out.println("Nhập mật khẩu mới");
                    String newPassword = scanner.nextLine();
                    accountsAdmin.set(index, new Account(username, newPassword));
                    System.out.println("Mật khẩu đã được thay đổi");
                    return;
                }
            }
            System.out.println("Mật khẩu sai");
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }


    public List<Account> readAdmin() {
        try {
            FileReader fileReader = new FileReader("accAdmin.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(", ");
                String username = txt[0];
                String password = txt[1];
                accountsAdmin.add(new Account(username, password));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountsAdmin;
    }

    public List<Account> readAccCustomer() {
        try {
            FileReader fileReader = new FileReader("accCustomer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(", ");
                String username = txt[0];
                String password = txt[1];
                String name = txt[2];
                int age = Integer.parseInt(txt[3]);
                String sdt = txt[4];
                String gender = txt[5];
                accountsCustomer.add(new Account(username, password,name,age,sdt,gender));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountsCustomer;
    }

    public void showAccCustomer(){
        for (int i = 0; i < accountsCustomer.size(); i++) {
            System.out.println(accountsCustomer);
        }
    }

    public void writeAdmin(List<Account> accountsAdmin) {
        try {
            FileWriter fileWriter = new FileWriter("accAdmin.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account account : accountsAdmin) {
                bufferedWriter.write(account.getUsername()+", "+ account.getPassword());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
