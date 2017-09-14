package cn.jobwebsite.spider.lianjia;

import cn.jobwebsite.spider.lianjia.beans.House;
import cn.jobwebsite.spider.lianjia.utils.Extract;
import cn.jobwebsite.spider.lianjia.utils.GetURLs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Amos
 * @Description: 此类是爬取链家北京二手房的简单实现,使用的Jsoup框架
 * @Date: 9/14/2017 3:20 PM
 */
public class SpiderAction {
    public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mytest", "postgres", "admin");
            System.out.println("Opened database successfully");

            c.setAutoCommit(true);
            Statement stmt = c.createStatement();
            List<String> urlsList = GetURLs.getUrlsList();
            for (String url : urlsList) {
                List<House> houses = Extract.extratHouse(url);
                for (House house: houses) {
                    String sql =
                            "Insert into t_house (id,title, address, housingestate, houseinfo, avarageprice, totalprice)"
                                    + " values ('" + UUID.randomUUID().toString() + "','" + house.getTitle() + "','" + house.getAddress() + "','" + house
                                    .getHousingEstate() + "','" + house.getHouseInfo() + "','" + house.getAvaragePrice()
                                    + "','" + house.getTotalPrice() + "')";

                    stmt.execute(sql);
                }
            }
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
