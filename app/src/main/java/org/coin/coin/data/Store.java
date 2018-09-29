package org.coin.coin.data;

public class Store {

    private String name, addr, tel, categ;
    private String hr, store_name, market_name;
    private String owner;
    private Double lat, lng, pct;
    private int id, num, market_id;

    public Store(String name, String addr, String tel, String categ, String hr, String store_name, String market_name, String owner, Double lat, Double lng, Double pct, int id, int num, int market_id) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.categ = categ;
        this.hr = hr;
        this.store_name = store_name;
        this.market_name = market_name;
        this.owner = owner;
        this.lat = lat;
        this.lng = lng;
        this.pct = pct;
        this.id = id;
        this.num = num;
        this.market_id = market_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getPct() {
        return pct;
    }

    public void setPct(Double pct) {
        this.pct = pct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMarket_id() {
        return market_id;
    }

    public void setMarket_id(int market_id) {
        this.market_id = market_id;
    }
}