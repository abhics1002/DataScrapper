import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author abbharadwaj
 * this class will download content from the URL or from the Html page. 
 * input - urls. 
 * 		- files (storing urls )
 * 
 * output - >  files having content or quiz
 *
 */
public class ContentDownloader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		Document doc = Jsoup.connect("http://www.gktoday.in/gk-current-affairs-september-1-2-2014/").timeout(50000).get();
		
		ContentDownloader sitedownloader = new ContentDownloader();
		sitedownloader.getTitle(doc);
		sitedownloader.getContentTitle(doc);
		
		List<QuestionAnswer> temp = new ArrayList<QuestionAnswer>();
		
		temp= sitedownloader.getQuestions(sitedownloader.getmainPost(doc));
		
	//	Helper.printQuestion(temp);
		
	}
	
	/*
	 * 
	 */
	public void loadUrls(List<String> urls)
	{
		
		
		
	}
	
	public String getTitle(Document doc)
	{
		return doc.title();
	}
	
	public Element getmainContent(Document doc)
	{
		Element content = doc.getElementById("main");
		return content;
	}
	
	public Elements getmainPost(Document doc)
	{
		Element content = doc.getElementById("main");
		String title = content.getElementsByClass("title").text();

		System.out.println("titile ------------------------"+ title);

		Elements questionContent = content.select("div[id^=post-");

		return questionContent;
	}
	
	public String getContentTitle(Document doc)
	{
		Element content = doc.getElementById("main");
		String title = content.getElementsByClass("title").text();
		return title;
	}
	
	public List<QuestionAnswer> getQuestions(Elements questioncontent)
	{
		List<QuestionAnswer> questionList = new ArrayList<QuestionAnswer>();
		QuestionAnswer ques = new QuestionAnswer() ;
		QuestionAnswer q =null;
		Elements e1 = questioncontent.select("p");
		int questionFlag =0;
		int answerFlag =0;
		for (Element e:e1)
		{
			//System.out.println(e);
			if (e.hasClass("answer"))
			{	answerFlag++;
				//System.out.println(e);
				//System.out.println("Answer=="+e.text());
				Elements temp = e.select("b");

				//System.out.println("Answer = "+temp.text());
				ques.setanswer(temp.text());
				
				//System.out.println("Description- e.childNodeSize"+e.childNodeSize());
				/*for(int i=0; i<e.childNodeSize();i++)
				{
					System.out.println("child node "+i+"--- "+e.childNode(i));
				}*/
				String desc = e.childNode(e.childNodeSize() - 1).toString();
				//System.out.println("Desc ---"+desc);
				ques.setdescription(desc);
			}
			else 
			{	
				questionFlag++;
				//System.out.println("Question ----- "+ e.text());
				q= Helper.getQuestionAnswer( e.text());
				//Helper.printQuestion(q);
				ques.setquestion(q.getquestion());
				ques.setoptionA(q.getoptionA());
				ques.setoptionB(q.getoptionB());
				ques.setoptionC(q.getoptionC());
				ques.setoptionD(q.getoptionD());
			}
			
			if(questionFlag == answerFlag && questionFlag>0 && answerFlag >0)
			{
				System.out.print("=========prnt question from contntDownloader ===");
				Helper.printQuestion(ques);
				
				QuestionAnswer temp= new QuestionAnswer(ques);
				questionList.add(temp);
				ques.reset();
			}
		}
		return questionList;
		
	}
	
	public void GetAnswers(Element content)
	{
		Elements divcontent = content.select("div[id^=dvt");
		System.out.println("div content ------------"+divcontent);
	}

	public List<QuestionAnswer> getcontent(String page_url) throws IOException
	{
		System.out.println("downloading content from ----"+ page_url);
		//List<QuestionAnswer> quesAnswer = new ArrayList<QuestionAnswer>();
		
		Document doc = Jsoup.connect(page_url).timeout(50000).get();
		
		ContentDownloader sitedownloader = new ContentDownloader();
		sitedownloader.getTitle(doc);
		sitedownloader.getContentTitle(doc);
		
		return sitedownloader.getQuestions(sitedownloader.getmainPost(doc));
				
	}
	
	public void setansweroption(List<QuestionAnswer> ques)
	{
		for(int i=0; i<ques.size(); i++)
		{
			QuestionAnswer q = new QuestionAnswer(ques.get(i));
			
			
		}
	}
}
