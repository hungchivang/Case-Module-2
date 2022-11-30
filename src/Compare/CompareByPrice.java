package Compare;

import Model.RoomCustomer;

import java.util.Comparator;

public class CompareByPrice implements Comparator<RoomCustomer> {

    @Override
    public int compare(RoomCustomer o1, RoomCustomer o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }


}
