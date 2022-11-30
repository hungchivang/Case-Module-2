package Service;

import Model.Account;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageAccount {
    Scanner scanner = new Scanner(System.in);

    List<Account> accounts = new ArrayList<>();

    public void Register() {
        String username;
        String password;
        while (true) {
            try{
                System.out.println("Nhập tài khoản");
                username = scanner.nextLine();
                int index = CheckUsername(username);
                if (index < 0) {
                    if(validateUserName(username)){
                        break;
                    }else {
                        System.out.println("Xin vui lòng nhập ít nhất 6-20 kí tự");
                    }
                } else {
                    System.out.println("Tài khoản đã tồn tại");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        while (true) {
            try {
                System.out.println("Nhập mật khẩu");
                password = scanner.nextLine();
                if (validatePassWord(password)) {
                    break;
                } else {
                    System.out.println("Xin vui lòng viết hoa chữ cái đầu tiên và ít nhất 8 kí tự");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Xin chào : "+ username);
        accounts.add(new Account(username, password));

    }

    public int CheckUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (username.equals(accounts.get(i).getUsername())) return i;
        }
        return -1;
    }

    public void Login() {
        System.out.println("Nhập tài khoản ");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu ");
        String password = scanner.nextLine();
        int index = CheckUsername(username);
        if (index >= 0) {
            for (int i = 0; i < accounts.size(); i++) {
                if (password.equals(accounts.get(index).getPassword())) {
                    System.out.println("Đăng nhập thành công");
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
        System.out.println("Nhập mật khẩu ");
        String password = scanner.nextLine();
        String newPassword;
        int index = CheckUsername(username);
        if (index >= 0) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(index).getPassword().equals(password)) {
                    System.out.println("Nhập mật khẩu mới");
                    newPassword = scanner.nextLine();
                    accounts.set(index,new Account(username, newPassword));
                    System.out.println("Mật khẩu đã được thay đổi");
                    return;
                }
            }
            System.out.println("Mật khẩu sai");
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }

    public boolean validateUserName(String regex){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9].{6,20}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    public boolean validatePassWord(String regex){
        Pattern pattern = Pattern.compile("^[A-Z][A-Za-z0-9].{6,}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public int validateInt() {
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 0) return number;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập số ");
            return validateInt();
        }
    }

    public List<Account> readCustomer() {
        try {
            FileReader fileReader = new FileReader("memo.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(";");
                String username = txt[0];
                String password = txt[1];
                accounts.add(new Account(username, password));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }


    public void writeCustomer(List<Account> accounts) {
        try {
            FileWriter fileWriter = new FileWriter("memo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account account : accounts) {
                bufferedWriter.write(account.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

