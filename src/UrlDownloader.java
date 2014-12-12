import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author abbharadwaj
 * this class will download urls from the website. 
 * and store them in a file. 
 * 
 *
 */
public class UrlDownloader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UrlDownloader obj = new UrlDownloader();
		String page = "http://www.gktoday.in/category/current-affairs-quiz-questions/";
		List<String> test  = obj.download_All_Urls(page);
		
		obj.download_Urls_with_keyword(test, "gk-current-affairs");
		
	}
	
	public List<String> download_All_Urls(String page) throws IOException
	{


		List<String> current_affairs_urls = new ArrayList<String>();
		Document doc = Jsoup.connect(page).timeout(50000).get();

		Elements links= doc.select("a[href]");

		for (Element link : links) {

			String temp = link.attr("href");

			current_affairs_urls.add(temp);

			//System.out.println(temp);
			/* if (temp.contains("gk-current-affairs"))
			 {
				 	current_affairs_urls.add(temp);
			 }*/
		}

		return current_affairs_urls;
	}
	
	public List<String> download_Urls_with_keyword(List<String> urls, String Keyword)
	{
		Iterator<String> it = urls.iterator();
		System.out.println(urls.size());
		List<String> urls_with_keyword = new ArrayList<String>();
		for(; it.hasNext(); )
		{
			String temp = (String) it.next();
			if (temp.contains(Keyword))
			{
				System.out.println(temp);
				urls_with_keyword.add(temp);
			}
		}
		
		return urls_with_keyword;
	}

}
