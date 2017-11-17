package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

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
