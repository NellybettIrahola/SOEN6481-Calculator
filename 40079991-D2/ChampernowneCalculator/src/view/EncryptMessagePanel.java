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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import controller.EncryptMessageListener;
/**
 * Encrypt Message view
 * @author nellybett
 *
 */
public class EncryptMessagePanel extends JPanel{
	JTextArea messageEncrypt;
	JTextArea encryptedMessage;
	JPanel menu;
	JButton encryptButton;
	JComboBox methodSelectionEncrypt;
	
	/**
	 * Getter of messageEncrypt attribute
	 * @return the value
	 */
	public JTextArea getMessageEncrypt() {
		return messageEncrypt;
	}

	/**
	 * Setter of messageEncrypt attribute
	 * @param messageEncrypt the new value
	 */
	public void setMessageEncrypt(JTextArea messageEncrypt) {
		this.messageEncrypt = messageEncrypt;
	}

	/**
	 * Getter of encryptedMessage attribute
	 * @return the value
	 */
	public JTextArea getEncryptedMessage() {
		return encryptedMessage;
	}

	/**
	 * Setter of the encryptedMessage
	 * @param encryptedMessage the new value
	 */
	public void setEncryptedMessage(JTextArea encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}

	/**
	 * Getter of the menu
	 * @return the value
	 */
	public JPanel getMenu() {
		return menu;
	}

	/**
	 * Setter of the menu
	 * @param menu the new value
	 */
	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	/**
	 * Getter of the encryptButton
	 * @return the value
	 */
	public JButton getEncryptButton() {
		return encryptButton;
	}

	/**
	 * Setter of the encryptButton
	 * @param encryptButton the new value
	 */
	public void setEncryptButton(JButton encryptButton) {
		this.encryptButton = encryptButton;
	}

	/**
	 * Getter of the methodSelectionEncrypt
	 * @return the value
	 */
	public JComboBox getMethodSelectionEncrypt() {
		return methodSelectionEncrypt;
	}

	/**
	 * Setter of the methodSelectionEncrypt
	 * @param methodSelectionEncrypt the new value
	 */
	public void setMethodSelectionEncrypt(JComboBox methodSelectionEncrypt) {
		this.methodSelectionEncrypt = methodSelectionEncrypt;
	}
	
	/**
	 * Constructor
	 * @param listener the listener
	 */
	public EncryptMessagePanel(EncryptMessageListener listener){
		String[] methods={"Substitution"};
		JLabel methodText=new JLabel("Encryption Method:");
		
		this.encryptButton=new JButton("Encrypt Message");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		this.methodSelectionEncrypt=new JComboBox(methods);
		
		
		Border border = methodText.getBorder();
		Border margin = new EmptyBorder(0,25,0,0);
		methodText.setBorder(new CompoundBorder(border, margin));
		
        this.menu=new JPanel();
        this.menu.setLayout(new FlowLayout());
        this.menu.add(methodText);
        this.menu.add(this.methodSelectionEncrypt);
       
        this.menu.setPreferredSize(new Dimension(550,400));
        
        this.messageEncrypt=new JTextArea();
        messageEncrypt.setLineWrap(true);
       
        
        JScrollPane textEncryptScroll=new JScrollPane(this.messageEncrypt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textEncryptScroll.setPreferredSize(new Dimension(500,200));
        this.menu.add(textEncryptScroll);
        this.menu.add(encryptButton);
        
        this.add(this.menu);
        
        JPanel textArea=new JPanel();
        textArea.setLayout(new FlowLayout());	
        textArea.setPreferredSize(new Dimension(550,300));
        
 
        
        this.encryptedMessage=new JTextArea();
        encryptedMessage.setLineWrap(true);
        JScrollPane textScroll=new JScrollPane(this.encryptedMessage,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textScroll.setPreferredSize(new Dimension(500,200));
        textArea.add(textScroll);
        this.encryptedMessage.setEditable(false); 
        this.add(textArea);
        this.setListener(listener);
        this.repaint();
        this.revalidate();
	}
	
	/**
	 * Listener setter
	 * @param listener the listener
	 */
	public void setListener(EncryptMessageListener listener){
		this.encryptButton.addMouseListener(listener);
	}
	
	/**
	 * Show errors in the view
	 * @param errorMessage the message
	 */
	public void showError(String errorMessage){
		JOptionPane.showMessageDialog(this,errorMessage,"WARNING.", JOptionPane.WARNING_MESSAGE);
	}

}
