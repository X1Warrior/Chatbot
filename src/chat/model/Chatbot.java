package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	private String [] keyboardmash;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [9];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		this.keyboardmash = new String [5];
		
		buildVerbs();
		buildShoppingList();
//		buildFollowups();
		buildQuestions();
		buildChatbotResponse();
		buildTopics();
		buildCuteAnimals();
		buildKeyboardMash();
		buildMovieList();
	}
	private void buildVerbs() 
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
		
	}
		private void buildMovieList()
		{
//			movieList.add("");
//			movieList.add(new Movie("Pacific Rim"));
//			movieList.add("Thor Ragnarok");
//			movieList.add("Happy Death Days");
//			movieList.add("Gladiator");
		}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("slug bait");
		shoppingList.add("Bleh");
	}
	
	private void buildKeyboardMash()
	{
		keyboardmash [0] = "ajsdklfjaslk;jglkasjdlf";
		keyboardmash [1] = "i loveaskljf;lkagdsndgaasd";
		keyboardmash [2] = "S:KDJbhadsfhgabsdlfihewsgdbviyufgbalhshrfaeihbvaeisy";
		keyboardmash [3] = "dfnslgsdlgjadsg;lhadf. [3o49[ afpi adpf9 wq3fpija fpi. rifjsdlhnsdfjsd fl;d sflds";
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()


	{ 
		questions [0] = "what is your full name?";
		questions [1] = "what is your quest?";
		questions [2] = "Do you know what the fox says?";
		questions [3] = "What is most commonly used password";
		questions [4] = "What is your mother's maiden name?";
		questions [5] = "What is your social security number?";
		questions [6] = "How many siblings do you have?";
		questions [7] = "What was your first pets name?";
		questions [8] = "What is your birth date?";
				
		
		
	}

	public void buildTopics()
	{
		topics [0] = "ring-ding-ding-ding-a-ding-a-ding";
		topics [1] = "wa-pa-pa-pa-pa-powpow";
		topics [2] = "AAAooooooooooooooooooo";
		topics [3] = "Cats go meow";
		topics [4] = "hatee-hatee-hatee-ho";
		topics [5] = "tchoff-tchoffo-tchoffo-tchoff-tchoff";
		topics [6] = "Chacha-Chacha-Chacha-Chow";
				
	}
	
	/**
	 * The method collects input from user and repeats back what they said, adds a new line and uses the buildChatbotResponse method to randomly select response.
	 * @param input collects users typed input 
	 * @return returns users response and returns a random response using buildChatbotResponse
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * builds a random response usingMat.random() for the arrays of verbs, topics, and questions.
	 * @return the random sentence built by the predefined arrays
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "/n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		return response; 
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		if (input.length() < 3);
		{
			return false;
		}
//		if (input.contains() );
//		{
//			return true;
//		}
		
		
		
		
		
//		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		if (input == null)
		{
			return false;	
		}
		if (input == "")
		{
			return false;
		}
		if (!input.startsWith("@") )
		{
			return false;
		}
		if (input.substring(1).contains("@"))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int i = 0; i < shoppingList.size(); i++)
		{
			if(	shoppingItem.contains(shoppingList.get(i)))
			 {
				return true; 
			 }
		}
				
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
			{
			return true;
			}
		if (exitString.equals("exit"))
		{
		
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return null;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
