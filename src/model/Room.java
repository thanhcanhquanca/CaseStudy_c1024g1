package model;

public class Room {
    private String roomId;
    private String type;
    private int pricePerDay;
    private boolean isStatus;

    public Room(String roomId, String type, int pricePerDay, boolean isStatus) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.isStatus = isStatus;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}
