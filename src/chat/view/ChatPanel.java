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
import javax.swing.JLabel;
import javax.swing.JScrollPane;

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
			checkerButton = new JButton("Check");
			infoLabel = new JLabel("Type to chat with chatbot");
			chatScrollPane = new JScrollPane();

			
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
			this.setBackground(Color.CYAN);
			this.setLayout(appLayout);
			this.add(chatButton);
			this.add(inputField);
			this.add(chatScrollPane);
			this.add(closeButton);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
			this.add(checkerButton);
			this.add(infoLabel);
			
			
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
			appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
			appLayout.putConstraint(SpringLayout.SOUTH, closeButton, -6, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, closeButton, -18, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, chatButton);
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
	
	
	
	
	
	

