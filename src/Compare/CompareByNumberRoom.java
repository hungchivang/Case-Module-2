package Compare;

import Model.Room;

import java.util.Comparator;

public class CompareByNumberRoom implements Comparator<Room> {

    @Override
    public int compare(Room o1, Room o2) {
        return o1.getNumberRoom()- o2.getNumberRoom();
    }
}
