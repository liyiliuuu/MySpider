package cn.jobwebsite.spider.lianjia.utils;

import cn.jobwebsite.spider.lianjia.beans.House;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Amos
 * @Description:
 * @Date: 9/14/2017 9:48 AM
 */
public class Extract {
    /**
     * 此方法用来提取页面的房屋信息
     * @param url
     * @return
     */
    public static List<House> extratHouse(String url) {
        //新建list用来存放搜集到的二手房信息
        List<House> houseList = new ArrayList<House>();
        try {
            //使用jsoup 建立链接
            Connection connect = Jsoup.connect(url);
            //获取传入url的页面document对象
            Document doc = connect.get();

            //通过选择器提取所需信息
            Elements infoClear = doc.select("div.info.clear");
            for (Element oneInfo: infoClear) {
                String title = oneInfo.select("div.title").text();
                String houseInfo = oneInfo.select("div.houseInfo").text();
                String housingEstate = oneInfo.select("div.houseInfo").select("a[href]").text();
                String address = oneInfo.select("div.positionInfo").select("a[href]").text();
                String totalPriceString = oneInfo.select("div.priceInfo").select("div.totalPrice").select("span").text();
                String avaragePriceString = oneInfo.select("div.priceInfo").select("div.unitPrice").select("span").text();
                //将总价转成double类型
                double totalPrice = Double.parseDouble(totalPriceString);
                //对均价进行处理
                String regEx = "\\d+";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(avaragePriceString);
                while (matcher.find()){
                    avaragePriceString = matcher.group();
                }
                double avaragePrice = Double.parseDouble(avaragePriceString);
                //将获取到的信息存入house对象中
                House house = new House(title, totalPrice, avaragePrice, address, housingEstate, houseInfo);
                houseList.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }
}
