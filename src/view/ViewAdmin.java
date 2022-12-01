package view;

import Model.Account;
import Model.Room;
import Service.ManageAccount;
import Service.ManageAccountAdmin;
import Service.ManageRoomAdmin;
import Service.MangeHotel;

import java.util.List;

public class ViewAdmin {
    public void viewAdmin() {
        ManageAccountAdmin manageAccountAdmin = new ManageAccountAdmin();
        List<Account> accountAdmin = manageAccountAdmin.readAdmin();
        ManageRoomAdmin manageRoomAdmin = new ManageRoomAdmin();
        MangeHotel mangeHotel = new MangeHotel();
        mangeHotel.readRoomBooked();

        List<Room> rooms = manageRoomAdmin.readRoom();

        int choice = -1 ;
        while (choice != 0) {
            System.out.println("---------------------");
            System.out.println("1. Thêm phòng");
            System.out.println("2. Xóa phòng");
            System.out.println("3. Sửa phòng");
            System.out.println("4. Hiển thị");
            System.out.println("5. Kiểm tra phòng còn trống");
            System.out.println("6. Hiển thị thông tin khách hàng đã đặt phòng");
            System.out.println("7. Đổi mật khẩu");
            System.out.println("8. Hiển thị danh sách người dùng");
            System.out.println("9. Đăng xuất");
            System.out.println("0. Thoát");
            System.out.println("---------------------");
            choice = manageRoomAdmin.validateInt();
            switch (choice){
                case 1:
                    manageRoomAdmin.add();
                    break;
                case 2:
                    System.out.println("Nhập id cần xóa");
                    int idDelete = manageRoomAdmin.validateInt();
                    manageRoomAdmin.Delete(idDelete);
                    break;
                case 3:
                    System.out.println("Nhập id cần sửa");
                    int idEdit = manageRoomAdmin.validateInt();
                    manageRoomAdmin.Edit(idEdit);
                    break;
                case 4:
                    manageRoomAdmin.show();
                    break;
                case 5:
                    mangeHotel.showRoomNotBook();
                    break;
                case 6:
                    mangeHotel.showCustomer();
                    break;
                case 7:
                    manageAccountAdmin.SetPassword();
                    manageAccountAdmin.writeAdmin(accountAdmin);
                    break;
                case 8:
                    manageAccountAdmin.showAccCustomer();
                    break;
                case 9:
                    return;
                case 0:
                    manageRoomAdmin.writeRoom(rooms);
                    break;
            }
        }
    }
}
