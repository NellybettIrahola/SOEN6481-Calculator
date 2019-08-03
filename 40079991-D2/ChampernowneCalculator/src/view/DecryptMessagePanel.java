package view;





import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import controller.DecryptMessageListener;


public class DecryptMessagePanel extends JPanel{
	JTextArea messageDecrypt;
	JTextArea decryptedMessage;
	JPanel menu;
	JButton decryptButton;
	JTextField keyInput;
	JComboBox methodSelection;
	
	/**
	 * Getter of the messageDecrypt attribute
	 * @return the value
	 */
	public JTextArea getMessageDecrypt() {
		return messageDecrypt;
	}

	/**
	 * Setter of the messageDecrypt attribute
	 * @param messageDecrypt the new value
	 */
	public void setMessageDecrypt(JTextArea messageDecrypt) {
		this.messageDecrypt = messageDecrypt;
	}

	/**
	 * Getter of the decryptedMessage attribute
	 * @return the value
	 */
	public JTextArea getDecryptedMessage() {
		return decryptedMessage;
	}

	/**
	 * Setter of the decryptedMessage attribute
	 * @param decryptedMessage the new value
	 */
	public void setDecryptedMessage(JTextArea decryptedMessage) {
		this.decryptedMessage = decryptedMessage;
	}

	/**
	 * Getter of the menu attribute
	 * @return the value
	 */
	public JPanel getMenu() {
		return menu;
	}

	/**
	 * Setter of the menu attribute
	 * @param menu the new value
	 */
	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	/**
	 * Getter of the decryptButton attribute
	 * @return the value
	 */
	public JButton getDecryptButton() {
		return decryptButton;
	}

	/**
	 * Setter of the decryptButton attribute
	 * @param decryptButton the new value
	 */
	public void setDecryptButton(JButton decryptButton) {
		this.decryptButton = decryptButton;
	}

	/**
	 * Getter of the keyInput attribute
	 * @return the value
	 */
	public JTextField getKeyInput() {
		return keyInput;
	}

	/**
	 * Setter of the keyInput attribute
	 * @param keyInput the new value
	 */
	public void setKeyInput(JTextField keyInput) {
		this.keyInput = keyInput;
	}

	/**
	 * Getter of the mehodSelection attribute
	 * @return the value
	 */
	public JComboBox getMethodSelection() {
		return methodSelection;
	}

	/**
	 * Setter of the mehodSelection attribute
	 * @param methodSelection the new value
	 */
	public void setMethodSelection(JComboBox methodSelection) {
		this.methodSelection = methodSelection;
	}

	/**
	 * Constructor
	 * @param listener the listener
	 */
	public DecryptMessagePanel(DecryptMessageListener listener){
		String[] methods={"Substitution"};
		JLabel methodText=new JLabel("Decryption Method:");
		JLabel keyText=new JLabel("Key:");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		this.keyInput=new JTextField();
		this.keyInput.setPreferredSize(new Dimension(40,25));
		this.methodSelection=new JComboBox(methods);
		
		Border border = keyText.getBorder();
		Border margin = new EmptyBorder(0,20,0,0);
		keyText.setBorder(new CompoundBorder(border, margin));
        
		this.decryptButton=new JButton("Decrypt Message");
        this.menu=new JPanel();
        this.menu.setLayout(new FlowLayout());
        this.menu.add(methodText);
        this.menu.add(this.methodSelection);
        this.menu.add(keyText);
        this.menu.add(this.keyInput);
        
        this.menu.setPreferredSize(new Dimension(550,400));
        
        this.messageDecrypt=new JTextArea();
        messageDecrypt.setLineWrap(true);
        JScrollPane textDecryptScroll=new JScrollPane(this.messageDecrypt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textDecryptScroll.setPreferredSize(new Dimension(500,200));
        this.menu.add(textDecryptScroll);
        this.menu.add(decryptButton);
        this.add(this.menu);
        
        JPanel textArea=new JPanel();
        textArea.setLayout(new FlowLayout());	
        //JLabel result=new JLabel("Decrypted Message");
        //textArea.add(result);
        textArea.setPreferredSize(new Dimension(550,300));
        
 
        
        this.decryptedMessage=new JTextArea();
        decryptedMessage.setLineWrap(true);
        
        this.decryptedMessage.setEditable(false);
        
        Border borderTextArea = decryptedMessage.getBorder();
		Border marginTextArea = new EmptyBorder(20, 0, 0, 0);
		decryptedMessage.setBorder(new CompoundBorder(borderTextArea, marginTextArea));
        
        JScrollPane textScroll=new JScrollPane(this.decryptedMessage,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textScroll.setPreferredSize(new Dimension(500,200));
        textArea.add(textScroll);
        
        this.add(textArea);
        this.setListener(listener);
        this.repaint();
        this.revalidate();
	}
	
	/**
	 * Listener Setter
	 * @param listener the value of the listener
	 */
	public void setListener(DecryptMessageListener listener){
		this.decryptButton.addMouseListener(listener);
	}
	
	/**
	 * Shows error message in the view
	 * @param errorMessage the message
	 */
	public void showError(String errorMessage){
		JOptionPane.showMessageDialog(this,errorMessage,"WARNING.", JOptionPane.WARNING_MESSAGE);
	}
}
