package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
		private ChatbotController appController;
		private JButton chatButton;
		private JTextField inputField;
		private JTextArea chatArea;
		private SpringLayout appLayout;
		private JButton closeButton;
		
		public ChatPanel(ChatbotController appController)
		{
			
			super();
			this.appController = appController;
			
			//Initialize GUI data members
			chatButton = new JButton("chat");
			chatArea = new JTextArea(10, 25);
			inputField = new JTextField(20);
			appLayout = new SpringLayout();
			closeButton = new JButton("Close");



			
			
			
			setupPanel();
			setupLayout();
			setupListeners();
			
		}
		
		private void setupPanel()
		{
			this.setBackground(Color.CYAN);
			this.setLayout(appLayout);
			this.add(chatButton);
			this.add(inputField);
			this.add(chatArea);
			this.add(closeButton);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
			
			
		}
		/**
		 * this is how everything is laid out in the GUI.
		 */
		private void setupLayout()
		{
			appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, chatArea, 28, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, chatArea, -22, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
			appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -37, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
			appLayout.putConstraint(SpringLayout.WEST, closeButton, 0, SpringLayout.WEST, chatButton);
			appLayout.putConstraint(SpringLayout.SOUTH, closeButton, -6, SpringLayout.NORTH, chatButton);
		}
		
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
		
		}	
	
	
	
	
	
	
	

