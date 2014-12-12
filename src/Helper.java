import java.util.Iterator;
import java.util.List;


public class Helper {

	public static void main(String[] args) {
		
		
		
		//System.out.println(Findendpoint("http://www.gktoday.in/gk-current-affairs-july-29-30-2014/"));
	/*	getQuestionAnswer("4. Which two Indian buildings have won the UNESCO Asia-Pacific Heritage Award 2014? 	 "
				+ "[A]Esplanade House, Mumbai and Shri Sakhargad Nivasini Devi Temple Complex, Satara	 "
				+ "[B]Hill Forts, Rajasthan and Jantar Mantar, Jaipur	 "
				+ "[C]Mahabodhi Temple, Gaya and Sun Temple, Konark "
				+ "	 [D]Rani-ki-Vav, Gujarat and Mahabodhi Temple, Gaya");
	*/
		String url = "http://www.gktoday.in/gk-current-affairs-september-1-2-2014/";
		System.out.println(getFileName(url));
	
	
	}
	
	
	

	
	
	/**
	 *  this method will return end point from a url. 
	 *  ex: http://www.gktoday.in/gk-current-affairs-july-29-30-2014/ will 
	 *  give gk-current-affairs-july-29-30-2014
	 * @param url
	 */
	public static String Findendpoint(String url)
	{
		String[] str = url.split("/");
		int len = str.length;
		System.out.println(str.length);
		
		return str[len-1];
	}
	
	public static void printQuestion(List<QuestionAnswer> Q)
	{
		Iterator<QuestionAnswer> it = Q.iterator();
		QuestionAnswer temp=new QuestionAnswer();
		String temp1;
		System.out.println("size of the list---"+Q.size());
		while(it.hasNext())
		{
			
			System.out.println("========================================");
			temp =  it.next();
			
			System.out.println("Question--- "+temp.getquestion());
			System.out.println("OptionA- "+temp.getoptionA());
			System.out.println("OptionB- "+temp.getoptionB());
			System.out.println("OptionC- "+temp.getoptionC());
			System.out.println("OptionD- "+temp.getoptionD());
			System.out.println("Answer- "+temp.getanswer());
			System.out.println("Answer option- "+temp.getansweroption());
			System.out.println("Description- "+temp.getDescription());
			System.out.println("Category- "+temp.getcategory());
			
		}
	}
	
	public static void printQuestion(QuestionAnswer temp)
	{
		System.out.println("================printQuestion ========================");

		System.out.println("Question- "+temp.getquestion());
		System.out.println("OptionA- "+temp.getoptionA());
		System.out.println("OptionB- "+temp.getoptionB());
		System.out.println("OptionC- "+temp.getoptionC());
		System.out.println("OptionD- "+temp.getoptionD());
		System.out.println("Answer- "+temp.getanswer());
		System.out.println("Answer option- "+temp.getansweroption());
		System.out.println("Description- "+temp.getDescription());
		System.out.println("Category- "+temp.getcategory());
	}
	/**
	 * ex: 4. Which two Indian buildings have won the UNESCO Asia-Pacific Heritage Award 2014? 
	 * [A]Esplanade House, Mumbai and Shri Sakhargad Nivasini Devi Temple Complex, Satara 
	 * [B]Hill Forts, Rajasthan and Jantar Mantar, Jaipur
	 * [C]Mahabodhi Temple, Gaya and Sun Temple, Konark 
	 * [D]Rani-ki-Vav, Gujarat and Mahabodhi Temple, Gaya
	 * @param text
	 * @return
	 */
	public static QuestionAnswer getQuestionAnswer(String text)
	{
		QuestionAnswer ques = new QuestionAnswer();
		
		if ((text.contains("[A]") && text.contains("[B]") && text.contains("[C]") && text.contains("[D]")) || 
				( text.contains("[a]") && text.contains("[b]") && text.contains("[c]") && text.contains("[d]")))
		{
			int indexa= text.indexOf("[A]");
			int indexb= text.indexOf("[B]");
			int indexc= text.indexOf("[C]");
			int indexd= text.indexOf("[D]");
			
			String temp = null;
			String replaced_str=null;
			temp= text.substring(0, indexa);
			
			temp = temp.replaceAll("^\\d.", "");
			ques.setquestion(temp.trim());
			//System.out.println(temp);
			temp = text.substring(indexa, indexb);
			replaced_str=temp.replace("[A]", "");
			ques.setoptionA(replaced_str.trim());
			//System.out.println(temp);
			temp = text.substring(indexb, indexc);
			replaced_str=temp.replace("[B]", "");

			ques.setoptionB(replaced_str.trim());
			//System.out.println(temp);
			temp = text.substring(indexc, indexd);
			replaced_str=temp.replace("[C]", "");
			ques.setoptionC(replaced_str.trim());
			//System.out.println(temp);
			temp = text.substring(indexd, text.length());
			replaced_str=temp.replace("[D]", "");
			ques.setoptionD(replaced_str.trim());
			//System.out.println(temp);
		}
		else 
		{
			System.out.println("Question is not proper === unable to create QuestionAnswer Object \n"+ text);
		}
		
		return ques;
	}
	
	/*
	 * get file name from url : 
	 * ex: http://www.gktoday.in/gk-current-affairs-september-1-2-2014/
	 * 
	 * file name - current-affairs-september-1-2-2014. 
	 * 
	 */
	public static String getFileName(String url)
	{
		String filename="";
		String names[]= url.split("/");
		
		filename= names[names.length - 1];
		System.out.println(names[names.length - 1]);
		
		return filename;
	}
	
	public static void printList(List<String> mylist)
	{
		for(int i=0; i< mylist.size(); i++){
			System.out.println(mylist.get(i).toString());
		}
	}
	
	
}
