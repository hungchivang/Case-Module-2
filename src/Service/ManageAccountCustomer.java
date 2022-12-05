package Service;

import Model.Account;
import view.ViewCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ManageAccountCustomer {
    Scanner scanner = new Scanner(System.in);
    ViewCustomer viewCustomer = new ViewCustomer();
    List<Account> accounts = new ArrayList<>();


    public void Register() {
        String username;
        String password;
        while (true) {
            try {
                System.out.println("Nhập tài khoản");
                username = scanner.nextLine();
                int index = CheckUsername(username);
                if (index < 0) {
                    if (validateUserName(username)) {
                        break;
                    } else {
                        System.out.println("Xin vui lòng nhập ít nhất 6-20 kí tự");
                    }
                } else {
                    System.out.println("Tài khoản đã tồn tại");
                }
            } catch (Exception e) {
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
        System.out.println("Nhập tên ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = validateAge();
        String sdt;
        while (true) {
            try {
                System.out.println("Nhập số điện thoại");
                sdt = scanner.nextLine();
                if (validateSdt(sdt)) {
                    break;
                } else {
                    System.out.println("Nhập đủ 10 kí tự");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nhập giới tính");
        String gender = validateGender();
        accounts.add(new Account(username, password, name, age, sdt, gender));
        System.out.println("Xin chào : " + name);
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
                    viewCustomer.viewCustomer();
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
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(index).getPassword().equals(password)) {
                    System.out.println("Nhập mật khẩu mới");
                    String newPassword = scanner.nextLine();
                    accounts.set(index, new Account(username, newPassword, accounts.get(i).getName(), accounts.get(i).getAge(), accounts.get(i).getSdt(), accounts.get(i).getGender()));
                    System.out.println("Mật khẩu đã được thay đổi");
                    return;
                }
            }
            System.out.println("Mật khẩu sai");
        } else {
            System.out.println("Tài khoản không tồn tại");
        }
    }

    public boolean validateUserName(String regex) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9].{6,20}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    public boolean validatePassWord(String regex) {
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
                int age = parseInt(txt[3]);
                String sdt = txt[4];
                String gender = txt[5];
                accounts.add(new Account(username, password, name, age, sdt, gender));
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
            FileWriter fileWriter = new FileWriter("accCustomer.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account account : accounts) {
                bufferedWriter.write(account.getUsername() + ", " + account.getPassword() + ", " + account.getName() + ", " + account.getAge() + ", " + account.getSdt() + ", " + account.getGender());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateSdt(String regex) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public int validateAge() {
        try {
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 18 && age <= 65) return age;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập độ tuổi từ ( 18 -> 65 )");
            return validateAge();
        }
    }

    public String validateGender() {
        try {
            String gender = scanner.nextLine();
            if (Objects.equals(gender, "nam") || Objects.equals(gender, "nu")) return gender;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập :nam hoặc nu");
            return validateGender();
        }
    }

}

