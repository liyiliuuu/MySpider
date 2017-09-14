package cn.jobwebsite.spider.lianjia.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Amos
 * @Description:
 * @Date: 9/14/2017 1:51 PM
 */
public class GetURLs {
    /**
     * 此方法用来获取链家二手房的url
     */
    public static List<String> getUrlsList() {
        String initUrl = "https://nj.lianjia.com/ershoufang/";
        //创建url存放的list
        List<String> urlList = new ArrayList<String>();
        try {
            //使用jsoup 建立链接
            Connection connect = Jsoup.connect(initUrl);
            //获取传入url的页面document对象
            Document doc = connect.get();

            //获取分页数 totalNum
            String[] tmp = doc.select("div.page-box.house-lst-page-box")
                    .attr("page-data")
                    .split(",");

            int totalPageNum = Integer.parseInt(tmp[0].substring(tmp[0].indexOf(":") + 1));

            //生成url,并存入list集合返回
            for (int i = 1; i <= totalPageNum; i++) {
                String url = initUrl + "pg" + i;
                urlList.add(url);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return urlList;
    }
}
