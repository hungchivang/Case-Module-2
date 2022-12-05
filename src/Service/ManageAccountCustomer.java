package Service;

import Model.Account;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ManageAccountCustomer {
    Scanner scanner = new Scanner(System.in);
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
                    Scanner scanner = new Scanner(System.in);
                    ManageRoomCustomer manageRoomCustomer = new ManageRoomCustomer();
                    manageRoomCustomer.readFile();

                    ManageAccountCustomer manageAccountCustomer = new ManageAccountCustomer();
                    List<Account> accounts = manageAccountCustomer.readCustomer();

                    int choice;
                    while (true) {
                        System.out.println("---------------------");
                        System.out.println("1. Sắp xếp");
                        System.out.println("2. Tìm kiếm");
                        System.out.println("3. Hiển thị danh sách phòng");
                        System.out.println("4. Đặt phòng");
                        System.out.println("5. Hủy đặt phòng");
                        System.out.println("6. Hiển thị phòng đã đặt");
                        System.out.println("7. Thanh toán");
                        System.out.println("8. Hiển thị phòng còn trống");
                        System.out.println("9. Đổi mật khẩu");
                        System.out.println("10. Đăng xuất");
                        System.out.println("0. Thoát");
                        System.out.println("---------------------");
                        choice = manageRoomCustomer.validateInt();
                        switch (choice) {
                            case 1:
                                int choice2 = -1;
                                while (choice2 != 0) {
                                    System.out.println("---------------------");
                                    System.out.println("1. Sắp xếp theo giá");
                                    System.out.println("2. Sắp xếp theo số phòng");
                                    System.out.println("0. Exit");
                                    System.out.println("---------------------");
                                    choice2 = manageRoomCustomer.validateInt();
                                    switch (choice2) {
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
                                while (choice3 != 0) {
                                    System.out.println("---------------------");
                                    System.out.println("1. Tìm kiếm theo mức giá từ 1000 -> 2500");
                                    System.out.println("2. Tìm kiếm theo mức giá từ 2500 -> 4000");
                                    System.out.println("3. Tìm kiếm theo mức giá trên 4000");
                                    System.out.println("4. Tìm kếm theo địa chỉ");
                                    System.out.println("0. Exit");
                                    System.out.println("---------------------");
                                    choice3 = manageRoomCustomer.validateInt();
                                    switch (choice3) {
                                        case 1:
                                            manageRoomCustomer.SearchByPrice1();
                                            break;
                                        case 2:
                                            manageRoomCustomer.SearchByPrice2();
                                            break;
                                        case 3:
                                            manageRoomCustomer.SearchByPrice3();
                                            break;
                                        case 4:
                                            System.out.println("Nhập địa chỉ muốn tìm");
                                            String name = scanner.nextLine();
                                            manageRoomCustomer.SearchByAddress(name);
                                            break;
                                        case 0:
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                manageRoomCustomer.showRoom();
                                break;
                            case 4:
                                System.out.println("Nhập số phòng cần đặt");
                                int roomIdBook = manageRoomCustomer.validateInt();
                                manageRoomCustomer.bookRoom(roomIdBook,username);
                                break;
                            case 5:
                                System.out.println("Nhập số phòng cần hủy");
                                int roomIdCancel = manageRoomCustomer.validateInt();
                                manageRoomCustomer.CancelRoom(roomIdCancel,username);
                                break;
                            case 6:
                                manageRoomCustomer.showRoomBooked(username);
                                break;
                            case 7:
                                manageRoomCustomer.totalAmount(username);
                                break;
                            case 8:
                                manageRoomCustomer.showRoomNotBook();
                                break;
                            case 9:
                                manageAccountCustomer.SetPassword();
                                manageAccountCustomer.writeCustomer(accounts);
                                break;
                            case 10:
                                manageRoomCustomer.writeFile();
                                return;
                            case 0:
                                manageAccountCustomer.writeCustomer(accounts);
                                manageRoomCustomer.writeFile();
                                System.exit(0);
                        }
                    }
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
                    accounts.set(index, new Account(username, newPassword, accounts.get(index).getName(), accounts.get(index).getAge(), accounts.get(index).getSdt(), accounts.get(index).getGender()));
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

