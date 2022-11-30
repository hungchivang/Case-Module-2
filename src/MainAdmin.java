import Model.Room;
import Service.ManageRoomAdmin;
import java.util.List;

public class MainAdmin {
    public static void main(String[] args) {
        ManageRoomAdmin manageRoomAdmin = new ManageRoomAdmin();

        List<Room> rooms = manageRoomAdmin.readRoom();

        int choice = -1 ;
        while (choice != 0) {
            System.out.println("---------------------");
            System.out.println("1. Thêm phòng");
            System.out.println("2. Xóa phòng");
            System.out.println("3. Sửa phòng");
            System.out.println("4. Hiển thị");
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
                case 0:
                    manageRoomAdmin.writeRoom(rooms);
                    break;
            }
        }
    }
}
