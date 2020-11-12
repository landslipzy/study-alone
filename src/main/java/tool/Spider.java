package tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @description: 爬虫
 * @author: zhongying
 * @create: 2020-11-12
 */
public class Spider {
    public static void main(String[] args) {
        Document document = null;
        try {
            document = Jsoup.connect("https://live.leisu.com/wanchang?date=20200102").get();
        } catch (IOException e) {
            System.err.println("链接失败");
        }
        Element list = document.getElementById("list");
        Element finished = list.getElementById("finished");
        Elements ul = finished.getElementsByTag("ul");
        Element first = ul.first();
        Elements lis = first.getElementsByTag("li");
        lis.forEach(n->{
            Element div = n.getElementsByTag("div").first();
            Element div1 = div.getElementsByTag("div").first();
            //赛事名称
            Element eventName = div1.getElementsByClass("event-name").first();
            Element span = eventName.getElementsByTag("span").first();
            System.out.print(span.text()+"  ");
            //轮次
            String labRound = div1.getElementsByClass("lab-round").first().text();
            System.out.print(labRound+"  ");
            //时间
            String labTime = div1.getElementsByClass("lab-time").first().text();
            System.out.print(labTime+" ");
            //主队
            String teamHome = div1.getElementsByClass("lab-team-home").first().getElementsByTag("span").first()
                    .getElementsByTag("a").first().text();
            System.out.print(teamHome+" ");

            //比分
            String score = div1.getElementsByClass("score").first().getElementsByTag("b").first().text();
            System.out.print(score+" ");

            //客队
            String teamAway = div1.getElementsByClass("lab-team-away").first().getElementsByTag("span").first()
                    .getElementsByTag("a").first().text();
            System.out.println(teamAway);
        });
    }
}
