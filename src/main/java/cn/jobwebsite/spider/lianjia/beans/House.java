package cn.jobwebsite.spider.lianjia.beans;

/**
 * @Author: Amos
 * @Description:
 * @Date: 9/14/2017 10:24 AM
 */
public class House {
    public String title;         //房屋标题
    public Double totalPrice;    //总价
    public Double avaragePrice;   //均价
    public String address;       //区域
    public String housingEstate; //小区
    public String houseInfo;     //房屋信息
    public String city;          //城市

    public House(String title, Double totalPrice, Double avaragePrice, String address, String housingEstate,
            String houseInfo, String city) {
        this.title = title;
        this.totalPrice = totalPrice;
        this.avaragePrice = avaragePrice;
        this.address = address;
        this.housingEstate = housingEstate;
        this.houseInfo = houseInfo;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getAvaragePrice() {
        return avaragePrice;
    }

    public void setAvaragePrice(Double avaragePrice) {
        this.avaragePrice = avaragePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHousingEstate() {
        return housingEstate;
    }

    public void setHousingEstate(String housingEstate) {
        this.housingEstate = housingEstate;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    @Override public String toString() {
        return "House{" + "title='" + title + '\'' + ", totalPrice=" + totalPrice + ", avaragePrice=" + avaragePrice
                + ", address='" + address + '\'' + ", housingEstate='" + housingEstate + '\'' + ", houseInfo='"
                + houseInfo + '\'' + ", city='" + city + '\'' + '}';
    }
}
