package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

/**
 * manages the Chatbot application including the Model and Frame of the iew package.
 * @author zsto7638
 * @version 11.21.17 Added Frame 1.3
 */
public class ChatbotController

{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	

	public ChatbotController()
	
	{
	    display = new PopupDisplay();
		chatbot = new Chatbot("Zach");
		appFrame = new ChatFrame(this);
	}
		public void start()
		{		
			display.displayText("What do you want to talk about?");
		}
	
		public String interactWithChatbot(String input)
		{
			String chatbotSays = "";
			
			if(chatbot.quitChecker(input)) 
			{
				close();
			}
			
			chatbotSays += chatbot.processConversation(input);
			
			return chatbotSays;
		}

	private String popupChat(String chat)
	{
		String chatbotSays = "";

		chatbotSays += chatbot.processConversation(chat);

		return chatbotSays;
	}
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
}
