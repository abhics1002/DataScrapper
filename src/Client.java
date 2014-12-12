
import java.io.IOException;
import java.util.List;


public class Client {

	UrlDownloader urldownloader;
	static FileGenerator filegenerator;
	ContentDownloader contentdownloader;
	//private static final String folderLocation = "C:\\Users\\abbharadwaj\\Documents\\QUIZ_QUESTION_DB";


	public static void main(String[] args) throws IOException {
		
		UrlDownloader urldownloader = new UrlDownloader();
		String page = "http://www.gktoday.in/category/current-affairs-quiz-questions/";
		
		List<String> urls_from_page = urldownloader.download_All_Urls(page);
		
		System.out.println("====================printing all urls ==================");
		Helper.printList(urls_from_page);
		
		List<String> urls_with_keyword = urldownloader.download_Urls_with_keyword(urls_from_page, "gk-current-affairs");

		System.out.println("====================printing all urls with keyword 'gk-current-affairs'==================");
		Helper.printList(urls_with_keyword);
		
		ContentDownloader contentdownloader = new ContentDownloader();
		for(int i =0; i<urls_with_keyword.size() ; i++)
		{
			System.out.println("downloading content from ----"+ urls_with_keyword.get(i));
			List<QuestionAnswer> data = contentdownloader.getcontent(urls_with_keyword.get(i));
			
			// write question in file and meta data in file. 
			System.out.println("=====printing questions from client =============");
			Helper.printQuestion(data);
			
			String filename= Helper.getFileName(urls_with_keyword.get(i));
			FileGenerator filewrite = new FileGenerator();
			
			filewrite.createFile(filename+".txt", data);
			
		}
	}

}
