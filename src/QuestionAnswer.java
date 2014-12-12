/**
 * @author abbharadwaj
 * this class is for question answer
 */
public class QuestionAnswer {



	String question;
	String optionA;
	String optionB;
	String optionC;
	String optionD;
	String answer;
	String answeroption;
	String category;
	String description;

	QuestionAnswer()
	{
		this.question="";
		this.optionA="";
		this.optionB="";
		this.optionC="";
		this.optionD="";
		this.answer="";
		this.answeroption="";
		this.category="";
		this.description="";
	}
	
	QuestionAnswer(QuestionAnswer q)
	{
		this.question=q.getquestion();
		this.optionA=q.getoptionA();
		this.optionB=q.getoptionB();
		this.optionC=q.getoptionC();
		this.optionD=q.getoptionD();
		this.answer=q.getanswer();
		this.answeroption=q.getansweroption();
		this.category=q.getcategory();
		this.description=q.getDescription();
		this.setansweroption();
	}

	public void reset()
	{
		this.question="";
		this.optionA="";
		this.optionB="";
		this.optionC="";
		this.optionD="";
		this.answer="";
		this.answeroption="";
		this.category="";
		this.description="";
	}
	public void setquestion(String ques)
	{
		this.question= ques;
	}

	public void setoptionA(String optA)
	{
		this.optionA = optA;
	}

	public void setoptionB(String optB)
	{
		this.optionB = optB;
	}

	public void setoptionC(String optC)
	{
		this.optionC = optC;

	}

	public void setoptionD(String optD)
	{
		this.optionD = optD;
	}

	public void setanswer(String ans)
	{
		this.answer = ans;
	}
	
	public void setansweroption(String ansoption)
	{
		this.answeroption = ansoption;
	}
	
	public void setansweroption()
	{
		if(answer.isEmpty())
		{
			System.out.println("======== can not set answer option======");
			answeroption="";
		}
		else
		{
			if(this.answer.toLowerCase().trim().equals(this.optionA.toLowerCase().trim()))
			{
				this.answeroption="a";
			}
			else if(this.answer.toLowerCase().trim().equals(this.optionB.toLowerCase().trim()))
			{
				this.answeroption="b";
			}
			else if(this.answer.toLowerCase().trim().equals(this.optionC.toLowerCase().trim()))
			{
				this.answeroption="c";
			}
			else if(this.answer.toLowerCase().trim().equals(this.optionD.toLowerCase().trim()))
			{
				this.answeroption="d";
			}
			else 
			{
				this.answeroption="unknown";
			}
		}
	}
	public void setcategory(String category)
	{
		this.category = category;
	}
	public void setdescription(String desc)
	{
		this.description = desc;
	}

	public String getquestion()
	{
		return this.question;
	}

	public String getoptionA()
	{
		return this.optionA;
	}
	public String getoptionB()
	{
		return this.optionB;
	}
	public String getoptionC()
	{
		return this.optionC;
	}
	public String getoptionD()
	{
		return this.optionD;
	}
	public String getanswer()
	{
		return this.answer;
	}
	public String getansweroption()
	{
		return this.answeroption;
	}
	public String getcategory()
	{
		return this.category;
	}

	public String getDescription()
	{
		return this.description;
	}
	public String getQuestionAnswer()
	{
		String ques= this.getquestion()+ "\n"+ this.getoptionA()+"\n"+this.getoptionB()+""+
				this.getoptionC()+"\n"+this.getoptionD()+"\n"+this.getanswer()+"\n"+this.getansweroption()+"\n"+this.getDescription();

		return ques;
	}
}
