//package view;
//
//import Model.Account;
//import Service.ManageAccountCustomer;
//import Service.ManageRoomCustomer;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class ViewCustomer {
//
//
//    public void viewCustomer() {
//        Scanner scanner = new Scanner(System.in);
//        ManageRoomCustomer manageRoomCustomer = new ManageRoomCustomer();
//        manageRoomCustomer.readFile();
//
//        ManageAccountCustomer manageAccountCustomer = new ManageAccountCustomer();
//        List<Account> accounts = manageAccountCustomer.readCustomer();
//
//        int choice;
//        while (true) {
//            System.out.println("---------------------");
//            System.out.println("1. Sắp xếp");
//            System.out.println("2. Tìm kiếm");
//            System.out.println("3. Hiển thị danh sách phòng");
//            System.out.println("4. Đặt phòng");
//            System.out.println("5. Hủy đặt phòng");
//            System.out.println("6. Hiển thị phòng đã đặt");
//            System.out.println("7. Hiển thị phòng còn trống");
//            System.out.println("8. Đổi mật khẩu");
//            System.out.println("9. Đăng xuất");
//            System.out.println("0. Thoát");
//            System.out.println("---------------------");
//            choice = manageRoomCustomer.validateInt();
//            switch (choice) {
//                case 1:
//                    int choice2 = -1;
//                    while (choice2 != 0) {
//                        System.out.println("---------------------");
//                        System.out.println("1. Sắp xếp theo giá");
//                        System.out.println("2. Sắp xếp theo số phòng");
//                        System.out.println("0. Exit");
//                        System.out.println("---------------------");
//                        choice2 = manageRoomCustomer.validateInt();
//                        switch (choice2) {
//                            case 1:
//                                manageRoomCustomer.sortByPrice();
//                                break;
//                            case 2:
//                                manageRoomCustomer.sortByNumberRoom();
//                                break;
//                            case 0:
//                                break;
//                        }
//                    }
//                    break;
//                case 2:
//                    int choice3 = -1;
//                    while (choice3 != 0) {
//                        System.out.println("---------------------");
//                        System.out.println("1. Tìm kiếm theo mức giá từ 1000 -> 2500");
//                        System.out.println("2. Tìm kiếm theo mức giá từ 2500 -> 4000");
//                        System.out.println("3. Tìm kiếm theo mức giá trên 4000");
//                        System.out.println("4. Tìm kếm theo địa chỉ");
//                        System.out.println("0. Exit");
//                        System.out.println("---------------------");
//                        choice3 = manageRoomCustomer.validateInt();
//                        switch (choice3) {
//                            case 1:
//                                manageRoomCustomer.SearchByPrice1();
//                                break;
//                            case 2:
//                                manageRoomCustomer.SearchByPrice2();
//                                break;
//                            case 3:
//                                manageRoomCustomer.SearchByPrice3();
//                                break;
//                            case 4:
//                                System.out.println("Nhập địa chỉ muốn tìm");
//                                String name = scanner.nextLine();
//                                manageRoomCustomer.SearchByAddress(name);
//                                break;
//                            case 0:
//                                break;
//                        }
//                    }
//                    break;
//                case 3:
//                    manageRoomCustomer.showRoom();
//                    break;
//                case 4:
//                    System.out.println("Nhập số phòng cần đặt");
//                    int roomIdBook = manageRoomCustomer.validateInt();
//                    manageRoomCustomer.bookRoom(roomIdBook,username);
//                    break;
//                case 5:
//                    System.out.println("Nhập số phòng cần hủy");
//                    int roomIdCancel = manageRoomCustomer.validateInt();
//                    manageRoomCustomer.CancelRoom(roomIdCancel);
//                    break;
//                case 6:
//                    manageRoomCustomer.showRoomBooked();
//                    break;
//                case 7:
//                    manageRoomCustomer.showRoomNotBook();
//                    break;
//                case 8:
//                    manageAccountCustomer.SetPassword();
//                    manageAccountCustomer.writeCustomer(accounts);
//                    break;
//                case 9:
//                    return;
//                case 0:
//                    manageRoomCustomer.writeFile();
//                    System.exit(0);
//            }
//        }
//    }
//}
