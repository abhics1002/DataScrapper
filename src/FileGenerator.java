import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
 * @description - this class will generate the text file. 
 * the file will be having content from website. 
 * 
 * 
 */
public class FileGenerator {

	private static final String folderLocation = "/Users/abbharadwaj/Desktop/GK_Quiz";
	
	File filepath = new File(folderLocation);
	
	public static void main(String[] args) {
		

	}
	
	public boolean write_content_in_file(List<String> url_list, String fileLocation)
	{
		Iterator<String> it = url_list.iterator();
		
		String file_name = Helper.Findendpoint(it.next());
			
		return false;
	}
	
	public void write_QuestionAnswer_in_file(String urls,QuestionAnswer question)
	{
		
	}
	
	
	public void ListallFiles()
	{
		
	}
	
	/*
	 * this method will see if the file is present with this name. 
	 * if file is not present then it will create file with  this name. 
	 */
	public boolean createFile(String filename, List<QuestionAnswer> ques) throws IOException
	{
		String filePath = folderLocation+filename;
		File file = new File(filePath);
		
		
		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		Iterator<QuestionAnswer> it = ques.iterator();
		QuestionAnswer temp = new QuestionAnswer();
		
		for(;it.hasNext();)
		{	
			temp = it.next();
			bw.write(temp.getquestion());
			
			bw.write("@@");
			bw.write(temp.getoptionA());
			bw.write("@@");
			bw.write(temp.getoptionB());
			bw.write("@@");
			bw.write(temp.getoptionC());
			bw.write("@@");
			bw.write(temp.getoptionD());
			bw.write("@@");
			bw.write(temp.getansweroption());
			bw.write("\n");
		}
		
		bw.close();

		System.out.println("Done");
		
		return false;

	

	}
	
}
