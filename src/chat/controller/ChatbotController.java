package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatbotController

{
	private PopupDisplay display = new PopupDisplay();
	private Chatbot chatbot = new Chatbot("Zach");
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");

		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}

	private String popupChat(String chat)
	{
		String chatbotSays = "";

		chatbotSays += chatbot.processConversation(chat);

		return chatbotSays;
	}
}
