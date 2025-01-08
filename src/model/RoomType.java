package model;

public enum RoomType {
    VIP(1300000),
    DELUXE(700000),
    STANDARD(500000),
    ECONOMY(200000);

    private final int price;
    RoomType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
