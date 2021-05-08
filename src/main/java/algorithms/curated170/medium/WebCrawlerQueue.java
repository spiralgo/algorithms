package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WebCrawlerQueue {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> que = new LinkedList<String>();

        Set<String> resultSet = new HashSet<String>();

        resultSet.add(startUrl);
        que.add(startUrl);

        while (!que.isEmpty()) {
            startUrl = que.poll();
            List<String> listURL = htmlParser.getUrls(startUrl);
            for (String url : listURL) {

                String[] root = startUrl.split("/");
                if (url.contains(root[2]) && !resultSet.contains(url)) {
                    resultSet.add(url);
                    que.add(url);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
  interface HtmlParser {
     public List<String> getUrls(String url);
  }