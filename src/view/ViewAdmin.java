package view;

import Model.Account;
import Service.ManageAccountAdmin;
import Service.ManageRoomAdmin;
import Service.ManageHome;

import java.util.List;

public class ViewAdmin {
    public void viewAdmin() {
        ManageAccountAdmin manageAccountAdmin = new ManageAccountAdmin();
        List<Account> accountAdmin = manageAccountAdmin.readAdmin();

        ManageRoomAdmin manageRoomAdmin = new ManageRoomAdmin();
        manageRoomAdmin.readRoom();

        ManageHome manageHome = new ManageHome();
        manageHome.readHome();

        int choice ;
        while (true) {
            System.out.println("---------------------");
            System.out.println("1. Thêm phòng");
            System.out.println("2. Xóa phòng");
            System.out.println("3. Sửa phòng");
            System.out.println("4. Hiển thị danh sách phòng ");
            System.out.println("5. Hiển thị phòng còn trống");
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
                    manageRoomAdmin.writeRoom();
                    break;
                case 3:
                    System.out.println("Nhập id cần sửa");
                    int idEdit = manageRoomAdmin.validateInt();
                    manageRoomAdmin.Edit(idEdit);
                    manageRoomAdmin.writeRoom();
                    break;
                case 4:
                    manageRoomAdmin.show();
                    break;
                case 5:
                    manageHome.showRoomNotBook();
                    break;
                case 6:
                    manageHome.showCustomer();
                    break;
                case 7:
                    manageAccountAdmin.SetPassword();
                    manageAccountAdmin.writeAdmin(accountAdmin);
                    break;
                case 8:
                    manageAccountAdmin.showAccCustomer();
                    break;
                case 9:
                    manageRoomAdmin.writeRoom();
                    return;
                case 0:
                    manageAccountAdmin.writeAdmin(accountAdmin);
                    manageRoomAdmin.writeRoom();
                    System.exit(0);
            }
        }
    }
}
