package Compare;

import Model.Room;

import java.util.Comparator;

public class CompareByPrice implements Comparator<Room> {

    @Override
    public int compare(Room o1, Room o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }


}
