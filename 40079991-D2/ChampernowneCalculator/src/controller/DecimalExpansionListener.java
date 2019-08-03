package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import model.ChampernowneModel;
import view.DecimalExpansionPanel;

/**
 * Listener of the Decimal Expansion View
 * @author nellybett
 *
 */
public class DecimalExpansionListener extends MouseAdapter {
	
	DecimalExpansionPanel decimalExpansion;
	ChampernowneModel modelChampernowne;
	
	/**
	 * Constructor
	 * @param modelChampernowne the model of the application
	 */
	public DecimalExpansionListener(ChampernowneModel modelChampernowne){
		this.modelChampernowne=modelChampernowne;
	}
	
	/**
	 * Setter of its view
	 * @param decimalExpansion the new value
	 */
	public void setDecimalPanel(DecimalExpansionPanel decimalExpansion){
		this.decimalExpansion=decimalExpansion;
	}
	
	/**
	 * Event manager
	 */
	@Override
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
            case "Calculate Number":
            	this.decimalExpansion.getPattern().setText("");
            	this.decimalExpansion.getPosition().setText("");
            	
            	String decimals=this.decimalExpansion.getDecimals().getText();
                int base=Integer.valueOf(this.decimalExpansion.getBaseSelection().getSelectedItem().toString());
                
                if(decimals.matches("\\d+") && Integer.valueOf(decimals)<700)
                	this.decimalExpansion.getNumberResult().setText(this.modelChampernowne.calculateAlternative(Integer.valueOf(decimals), base));
                else
                	this.decimalExpansion.showError("Incorrect Format for number of decimals.\n Number of decimals should be a number and < 700");
                break;
            case " Search ":
            	String number=this.decimalExpansion.getNumberResult().getText().toString();
            	String pattern=this.decimalExpansion.getPattern().getText().toString();
            	
            	if(!number.equals("") && pattern.matches("\\d+") && pattern.toCharArray().length<number.toCharArray().length-2){
            		int position=this.modelChampernowne.getPatternPosition(pattern, number);
            		if(position<3){
            			this.decimalExpansion.showError("Pattern not found");
            		}else
            			this.decimalExpansion.getPosition().setText(String.valueOf(position));
            	}else{
            		this.decimalExpansion.showError("Incorrect Format for number of pattern.");
            	}
                break;
            default:
                break;
        }

    }
}
