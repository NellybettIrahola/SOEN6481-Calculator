package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import model.ChampernowneModel;
import view.DecryptMessagePanel;

/**
 * Listener to manage events of the Decrypt Message View
 * @author nellybett
 *
 */
public class DecryptMessageListener extends MouseAdapter{
	DecryptMessagePanel decryptMessage;
	ChampernowneModel modelChampernowne;
	

	/**
	 * Setter of the model
	 * @param modelChampernowne the model of the application
	 */
	public DecryptMessageListener(ChampernowneModel modelChampernowne){
		this.modelChampernowne=modelChampernowne;
	}
	
	/**
	 * Setter of its view
	 * @param decryptMessage the new value
	 */
	public void setDecryptPanel(DecryptMessagePanel decryptMessage){
		this.decryptMessage=decryptMessage;
	}
	
	/**
	 * Event Manager
	 */
	public void mouseClicked(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();

        if (!(c instanceof JButton)) {
            return;
        }

        JButton buttonPressed = (JButton) c;
        if (!buttonPressed.isEnabled()) {
            return;
        }
      
        switch (buttonPressed.getText()) {
        case "Decrypt Message":
        	String method=this.decryptMessage.getMethodSelection().getSelectedItem().toString();
        	String message=this.decryptMessage.getMessageDecrypt().getText().toString();
        	String key=this.decryptMessage.getKeyInput().getText().toString();
        	
        	if(message.toCharArray().length<500 && key.matches("\\d+")){
        		if(method.equals("Substitution")){
                	this.decryptMessage.getDecryptedMessage().setText(this.modelChampernowne.decryptSubstitution(message, Integer.valueOf(key)));
                }
        		if(method.equals("One-Time Pad")){
        			this.decryptMessage.getDecryptedMessage().setText(this.modelChampernowne.decryptOneTimePad(message, Integer.valueOf(key)));
        		}
        	}else{
        		this.decryptMessage.showError("Error in message or key format.");
        	} 	
            break;
      
        default:
            break;
        }

    }
}
