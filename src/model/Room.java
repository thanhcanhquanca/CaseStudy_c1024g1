package model;

import enums.RoomType;

public class Room {
    private String roomId;
    private RoomType type;
    private boolean isStatus;

    public Room(String roomId, RoomType type, boolean isStatus) {
        this.roomId = roomId;
        this.type = type;
        this.isStatus = isStatus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", type=" + type +
                ", isStatus=" + isStatus +
                '}';
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}
