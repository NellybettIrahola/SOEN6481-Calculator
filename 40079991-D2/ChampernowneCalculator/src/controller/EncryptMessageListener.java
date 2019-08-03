package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import model.ChampernowneModel;
import view.EncryptMessagePanel;

/**
 * Listener of the Encrypt Message view
 * @author nellybett
 *
 */
public class EncryptMessageListener extends MouseAdapter{
	EncryptMessagePanel encryptMessage;
	ChampernowneModel modelChampernowne;
	
	/**
	 * Setter of its view
	 * @param encryptMessage the new value
	 */
	public void setEncryptPanel(EncryptMessagePanel encryptMessage){
		this.encryptMessage=encryptMessage;
	}
	
	/**
	 * Setter of the model. Constructor
	 * @param modelChampernowne the model of the application
	 */
	public EncryptMessageListener(ChampernowneModel modelChampernowne){
		this.modelChampernowne=modelChampernowne;
	}
	
	/**
	 * Event manager
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
            case "Encrypt Message":
            	String method=this.encryptMessage.getMethodSelectionEncrypt().getSelectedItem().toString();
            	String message=this.encryptMessage.getMessageEncrypt().getText().toString();
            	
            	if(message.toCharArray().length<500){
            		if(method.equals("Substitution")){
                    	this.encryptMessage.getEncryptedMessage().setText(this.modelChampernowne.encryptSubtitution(message));
                    }
            		if(method.equals("One-Time Pad")){
            			this.encryptMessage.getEncryptedMessage().setText(this.modelChampernowne.encryptOneTimePad(message));
            		}
            	}else{
            		this.encryptMessage.showError("The message should have less than 500 characteres.");
            	} 	
                break;
          
            default:
                break;
        }

    }
}
