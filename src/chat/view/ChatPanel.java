package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.*;

public class ChatPanel extends JPanel
/**
 * declaring data members.
 */
{
		private ChatbotController appController;
		private JButton chatButton;
		private JTextField inputField;
		private JTextArea chatArea;
		private SpringLayout appLayout;
		private JButton closeButton;
		private JButton checkerButton;
		private JLabel infoLabel;
		private JScrollPane chatScrollPane;
		private JButton searchButton;
		private JButton tweetButton;
		private JButton loadButton;
		
		public ChatPanel(ChatbotController appController)
		{
			
			super();
			this.appController = appController;
			
			//Initialize GUI data members
			chatArea = new JTextArea(10, 25);
			inputField = new JTextField(20);
			appLayout = new SpringLayout();
			closeButton = new JButton("Close");
			checkerButton = new JButton("Check");
			appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -37, SpringLayout.SOUTH, this);
			infoLabel = new JLabel("Type to chat with chatbot");
			chatScrollPane = new JScrollPane();
			tweetButton = new JButton("Tweet", new ImageIcon("/Chatbot/chat.view.images/Tweet.png"));
			chatButton = new JButton("Chat", new ImageIcon("/Chatbot/chat.view.images/Chat.png"));
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 293, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -53, SpringLayout.NORTH, checkerButton);
			loadButton = new JButton("Load", new ImageIcon("/Chatbot/chat.view.images/Load.png"));
			searchButton = new JButton("Tweet", new ImageIcon("/Chatbot/chat.view.images/Tweet.png"));
			

			
			setupScrollPane();			
			setupPanel();
			setupLayout();
			setupListeners();
			
		}
		/**
		 * this allows the chat area to be scrollable vertically but not horizontally.
		 */
		private void setupScrollPane()
		{
			chatScrollPane.setViewportView(chatArea);
			chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			chatArea.setLineWrap(true);
			chatArea.setWrapStyleWord(true);
			
		}
		/**
		 * this is what adds the components to the panel itself
		 */
		private void setupPanel()
		{
			this.setMinimumSize(new Dimension(800, 600));
			this.setBackground(Color.CYAN);
			this.setLayout(appLayout);
			this.add(chatButton);
			this.add(inputField);
			this.add(chatScrollPane);
			this.add(tweetButton);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
			this.add(checkerButton);
			this.add(infoLabel);
			this.add(searchButton);
			this.add(loadButton);
			
			
		}
		/**
		 * this is how everything is laid out in the GUI.
		 */
		private void setupLayout()
		{
			appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 28, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -22, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.SOUTH, inputField, -40, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, closeButton, -6, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, closeButton, -18, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.WEST, checkerButton, 10, SpringLayout.WEST, closeButton);
			appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 0, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, infoLabel, 133, SpringLayout.WEST, this);
		}
	/**
	 * let the buttons "listen" for actions so basically it will do something if it is clicked.	
	 */
		private void setupListeners()
		{
			chatButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent click) 
				{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
			closeButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent closing) 
				{ 					
				 System.exit(0);
				}
		});
			checkerButton.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.useCheckers(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
					});
		}	

}
	
	
	
	
	
	

