package chat.model;

import java.util.List;
import java.time.LocalDate;
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
	/**
	 * This loads values into the buildChatbotRepsonse method.
	 */
	private void buildVerbs() 
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
		
	}
	/**
	 * loads movies into the arrayList for movies
	 */
		private void buildMovieList()
		{
//		movieList.add(new Movie("Spiderman", "Action", "PG-13", "Clever, funny, and true to the Spider-Man spirit.", 133, LocalDate.of(2017, 6, 28), 4));
			movieList.add(new Movie("Movie Name", "Documentary", "R", "The worst movie i have ever seen", 120, LocalDate.now(), 1.2));
			movieList.add(new Movie("Pacific Rim", "Action Packed", "pg13", "The best movie i have ever seen created for men", 132, LocalDate.of(2013, 6, 12), 1.2));
			movieList.add(new Movie("Thor ragnarock", "Movie", "pg13", "Definently one of the best superhero Movies", 130, LocalDate.of(2017, 11, 3), 1.2));
			movieList.add(new Movie("Movie Name", "Movie", "R", "The worst movie i have ever seen", 120, LocalDate.now(), 1.2));
			movieList.add(new Movie("Hidden Figures", "History/Drama", "PG", "Hidden Figures is a way to show the importance of all races in nasa.", 127, LocalDate.of(2016, 12, 25), 4));

		}
	/**
	 * loads values into the shoppinList array
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("slug bait");
		shoppingList.add("Bleh");
	}
	/**
	 * loads mashing examples into the KeyboardMashChecker
	 */
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
	/**
	 * Loads questions into the BuildChatbotResponse
	 */
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
/**
 * Loads Topics into the BuildChatbot Response
 */
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
		
//		if (random % 2 == 0)
//		{
//			random = (int) (Math.random() * movieList.size());
//			response += "/n" + movieList.get(random).getTitle() + " is a great movie!";
//		}
		return response; 
	}
	/**
	 * 
	 * @param collects user input checks if it is long enough 
	 * @return if the word they put in is long enough to continue (a true or false).
	 */
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
	/**
	 * @param collects user input and checks for a user name with parameters specified.	
	 * @return if meets parameters true if fails a parameter return false
	 */
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
			if(contentCheck == null)
				return false;
			if(contentCheck.equals(" "))
				return false;
			if(contentCheck.contains(content))
				return true;
			return false;
	}
	/**
	 * @param goes through and checks users input to see if it matches a list and if it does it...
	 * @returns true if it doesnt it returns false.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		{
			int index = 0;
			
			for (index = 0; index < cuteAnimalMemes.size(); index +=1)
			{
				if (input.contains("pupper") || input.contains("otter") || input.contains("kittie"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		}

	/**
	 * @param Searches through the shopping list going up each one and checking if user typed a matching item.
	 * @return if user matched an item returns true, if not returns false.
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		for (int i = 0; i < shoppingList.size(); i++)
		{
			if (	shoppingItem.contains(shoppingList.get(i)))
			 {
				return true; 
			 }
		}
				
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		title = title.trim().toLowerCase();
		
		for (int i = 0; i<movieList.size(); i++)
		{
			if (title.equals(movieList.get(i).getTitle().toLowerCase()))
				
				return true;
		}
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if(genre.equals(""))
			
			return false;
		
		genre = genre.trim().toLowerCase();
		
		for (int i = 0; i<movieList.size(); i++)
		{
			if (movieList.get(i).getGenre().toLowerCase().contains(genre))
				return true;
		}
		return false;
	}
/**
 * makes it so only exit will quit the program
 */
	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
			{
			return false;
			}
		if (exitString.equalsIgnoreCase("exit"))
		{
		return true;
		}
		return false;
	}

//	public boolean keyboardMashChecker(String keyboardMash)
	{
//		String keyboardMash = a;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	/**
	 * gets ShoppingList
	 * @return shoppinglist
	 */
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
		return questions;
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
/**
 * gets Username
 * @return username
 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * gets Content
	 * @return content
	 */
	public String getContent()
	{
		return content;
	}
/**
 * gets Intro
 * @return intro
 */
	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
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
