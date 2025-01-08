package controller;

import model.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoomManager implements GenericManager<Room>{
    private final List<Room> rooms = new ArrayList<Room>();

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void add(Room item) {
        rooms.add(item);
    }

    @Override
    public void delete(String id) {
        boolean found = false;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId().equals(id)) {
                rooms.remove(i);
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("Xoa thanh cong " + id);
        }else {
            System.out.println("không tìm thấy id cần xóa" + id);
        }
    }

    @Override
    public void update(Room item) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomId().equals(item.getRoomId())) {
                rooms.set(i, item);
                break;
            }
        }
        System.out.println("không tìm thấy " + item.getRoomId());
    }

    @Override
    public void sort() {
        rooms.sort(new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getRoomId().compareTo(o2.getRoomId());
            }
        });
    }

    @Override
    public Room searchById(String id) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(id)) {
                return room;
            }
        }
        System.out.println("không tìm thấy " + id);
        return null;
    }

    @Override
    public void displayAll(Room item) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(item.getRoomId())) {
                System.out.println(room);
            }
        }

    }

    @Override
    public void readFromFile() {

    }

    @Override
    public void writeToFile() {

    }


}
