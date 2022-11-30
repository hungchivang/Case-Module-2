package Compare;

import Model.RoomCustomer;

import java.util.Comparator;

public class CompareByNumberRoom implements Comparator<RoomCustomer> {

    @Override
    public int compare(RoomCustomer o1, RoomCustomer o2) {
        return o1.getNumberRoom()- o2.getNumberRoom();
    }
}
