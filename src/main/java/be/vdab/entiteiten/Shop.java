package be.vdab.entiteiten;

import java.util.Comparator;

public class Shop implements Comparable<Shop> {
    private Integer shopId;
    private String info;
    private String address;

    public Shop() {
    }

    public Shop(Integer shopId, String info, String address) {
        this.shopId = shopId;
        this.info = info;
        this.address = address;
    }

    public static Comparator<Shop> sortBasedOnShopId() {
        return Comparator.comparing(Shop::getShopId);
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Shop o) {
        return this.shopId - o.shopId;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", shopId, "Info:", info, "Address:", address);
    }
}
