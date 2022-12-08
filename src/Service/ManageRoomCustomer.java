package Service;

import Compare.CompareById;
import Compare.CompareByNumberRoom;
import Compare.CompareByPrice;
import Model.Account;
import Model.Room;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ManageRoomCustomer {
    Scanner scanner = new Scanner(System.in);
    List<Room> listRoom = new ArrayList<>();

    ManageAccountCustomer manageAccountCustomer = new ManageAccountCustomer();
    List<Account> accounts = manageAccountCustomer.readCustomer();

    public void showRoom() {
        for (Room room : listRoom) {
            System.out.println(room);
        }
    }

    public void showRoomBooked(String username) {
        for (Room room : listRoom) {
            if (room.getStatus().equals("Đã đặt") && room.getUsername().equals(username)) {
                System.out.println("roomId = " + room.getRoomId() +
                        ", numberRoom = " + room.getNumberRoom() +
                        ", price = " + room.getPrice() +
                        ", address = " + room.getAddress() +
                        ", describe = " + room.getDescribe() +
                        ", status = " + room.getStatus() +
                        ", dayIn = " + room.getDayIn() +
                        ", dayOut = " + room.getDayOut());
            }
        }
    }

    public void showRoomNotBook() {
        for (Room room : listRoom) {
            if (room.getStatus().equals("yes")) {
                System.out.println(room);
            }
        }
    }

    public List<Room> readFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("roomAdmin.txt");
            ois = new ObjectInputStream(fis);
            listRoom = (List<Room>) ois.readObject();
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
        return null;
    }

    public void writeFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("roomAdmin.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listRoom);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sortByPrice() {
        listRoom.sort(new CompareByPrice());
        for (Room room : listRoom) {
            System.out.println(room.toString());

        }
    }

    public void sortByNumberRoom() {
        listRoom.sort(new CompareByNumberRoom());
        for (Room room : listRoom) {
            System.out.println(room.toString());
        }
    }

    public void sortByRoomId() {
        listRoom.sort(new CompareById());
        for (Room room : listRoom) {
            System.out.println(room.toString());
        }
    }

    public void SearchByPrice1() {
        for (Room room : listRoom) {
            if (room.getPrice() >= 1000 && room.getPrice() <= 2500) {
                System.out.println(room);
            }
        }
    }

    public void SearchByPrice2() {
        for (Room room : listRoom) {
            if (room.getPrice() > 2500 && room.getPrice() <= 4000) {
                System.out.println(room);
            }
        }
    }

    public void SearchByPrice3() {
        for (Room room : listRoom) {
            if (room.getPrice() > 4000) {
                System.out.println(room);
            }
        }
    }

    public void SearchByAddress(String name) {
        for (Room room : listRoom) {
            if (room.getAddress().contains(name)) {
                System.out.println(room);
            }
        }
    }

    public int CheckRoomID(int id) {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getRoomId() == id) return i;
        }
        return -1;
    }

    public void bookRoom(int id, String username) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(index).getStatus().equals("yes")) {
                    System.out.println("Ngày checkin");
                    System.out.println("Nhập năm");
                    int yearIn = validateYear();
                    System.out.println("Nhập tháng");
                    int monthIn = validateMonth();
                    System.out.println("Nhập ngày");
                    int dateIn = validateBirthday(yearIn, monthIn);
                    LocalDate dayIn = LocalDate.of(yearIn, monthIn, dateIn);

                    System.out.println("Ngày checkout");
                    System.out.println("Nhập năm");
                    int yearOut = validateYear();
                    System.out.println("Nhập tháng");
                    int monthOut = validateMonth();
                    System.out.println("Nhập ngày");
                    int dateOut = validateBirthday(yearOut, monthOut);
                    LocalDate dayOut = LocalDate.of(yearOut, monthOut, dateOut);
                    String status = "Đã đặt";

                    listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(), listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(), status, username, dayIn, dayOut));
                    System.out.println("Đặt phòng thành công");
                    return;
                }
            }
            System.out.println("Không thể đặt phòng");
        } else {
            System.out.println("Không có  id phòng này");
        }
    }

    public void CancelRoom(int id, String username) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(index).getStatus().equals("Đã đặt") && listRoom.get(index).getUsername().equals(username)) {
                    String status = "yes";
                    listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(), listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(), status));
                    System.out.println("Hủy phòng thành công");
                    return;
                }
            }
            System.out.println("Không thể hủy");
        } else {
            System.out.println("Không có  id phòng này");
        }
    }

    public void totalAmount(String username) {
        double sum = 0;
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getStatus().equals("Đã đặt") && listRoom.get(i).getUsername().equals(username)) {
                LocalDate input = LocalDate.of(listRoom.get(i).getDayIn().getYear(), listRoom.get(i).getDayIn().getMonth(), listRoom.get(i).getDayIn().getDayOfMonth());
                LocalDate output = LocalDate.of(listRoom.get(i).getDayOut().getYear(), listRoom.get(i).getDayOut().getMonth(), listRoom.get(i).getDayOut().getDayOfMonth());

                Period different = Period.between(input, output);
                System.out.println("roomId = " + listRoom.get(i).getRoomId() + " Tổng số ngày : " + different.getYears() + " năm " + different.getMonths() + " tháng và " +
                        different.getDays() + " ngày.");
                if (different.getDays() < 15) {
                    sum = sum + ((different.getYears() * 12 + different.getMonths()) * (listRoom.get(i).getPrice()));
                } else {
                    sum = sum + ((different.getYears() * 12 + different.getMonths() + 1) * (listRoom.get(i).getPrice()));
                }
            }
        }
        System.out.println("Số tiền cần thanh toán : " + sum);
    }

    public void editDate(int id, String username) {
        int index = CheckRoomID(id);
        if (index >= 0) {
            for (int i = 0; i < listRoom.size(); i++) {
                if (listRoom.get(index).getStatus().equals("Đã đặt") && listRoom.get(index).getUsername().equals(username)) {
                    while (true) {
                        System.out.println("---------------------");
                        System.out.println("1. Thay đổi ngày checkIn\n" +
                                "2. Thay đổi ngày checkOut\n" +
                                "3. OK");
                        System.out.println("---------------------");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Ngày checkin");
                                System.out.println("Nhập năm");
                                int yearIn = validateYear();
                                System.out.println("Nhập tháng");
                                int monthIn = validateMonth();
                                System.out.println("Nhập ngày");
                                int dateIn = validateBirthday(yearIn, monthIn);
                                LocalDate dayIn = LocalDate.of(yearIn, monthIn, dateIn);
                                listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(),
                                        listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(),
                                        listRoom.get(index).getStatus(), listRoom.get(index).getUsername(), dayIn, listRoom.get(index).getDayOut()));
                                break;
                            case 2:
                                System.out.println("Ngày checkout");
                                System.out.println("Nhập năm");
                                int yearOut = validateYear();
                                System.out.println("Nhập tháng");
                                int monthOut = validateMonth();
                                System.out.println("Nhập ngày");
                                int dateOut = validateBirthday(yearOut, monthOut);
                                LocalDate dayOut = LocalDate.of(yearOut, monthOut, dateOut);
                                listRoom.set(index, new Room(id, listRoom.get(index).getNumberRoom(), listRoom.get(index).getPrice(),
                                        listRoom.get(index).getAddress(), listRoom.get(index).getDescribe(),
                                        listRoom.get(index).getStatus(), listRoom.get(index).getUsername(), listRoom.get(index).getDayIn(), dayOut));

                                break;
                            case 3:
                                return;
                        }
                        System.out.println("Đã thay đổi thông tin");
                    }
                }
            }
            System.out.println("không thể thay đổi");
        }else {
            System.out.println("Không có  id phòng này");
        }
    }


    // Validate
    public int validateInt() {
        try {
            int number = parseInt(scanner.nextLine());
            if (number >= 0) return number;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập số nguyên");
            return validateInt();
        }
    }

    public int validateBirthday(int year, int month) {
        int date = Integer.parseInt(scanner.nextLine());
        try {
            if (date > 0 && date <= numberDate(month, year))
                return date;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phai nhap ngay > 0 va <= " + numberDate(month, year));
            return validateBirthday(year, month);
        }
    }


    public boolean yearPrime(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public int numberDate(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (yearPrime(year)) {
                    return 29;
                }
                return 28;
        }
        return -1;
    }

    public int validateMonth() {
        try {
            int month = Integer.parseInt(scanner.nextLine());
            if (month > 0 && month <= 12) return month;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập tháng ( 1 -> 12 )");
            return validateMonth();
        }
    }

    public int validateYear() {
        try {
            int year = Integer.parseInt(scanner.nextLine());
            if (year >= 2022) return year;
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Phải nhập từ 2022");
            return validateYear();
        }
    }
}
