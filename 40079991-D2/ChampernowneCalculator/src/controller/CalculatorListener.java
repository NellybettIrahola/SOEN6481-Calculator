package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;

import model.Caretaker;
import model.ChampernowneModel;
import model.Memento;
import model.Originator;
import view.CalculatorPanel;

/**
 * Class to listen to the events of the Calculator Panel
 * @author nellybett
 *
 */
public class CalculatorListener extends MouseAdapter {
	
	CalculatorPanel calculatorPanel;
	ChampernowneModel modelChampernowne;
	String text;
	int pos=0;
	
	/**
	 * Setter of the Calculator Panel
	 * @param calculatorPanel the view
	 */
	public void setCalculatorPanel(CalculatorPanel calculatorPanel){
		this.calculatorPanel=calculatorPanel;
		this.text="";
	}
	
	/**
	 * Setter of the model of the application
	 * @param modelChampernowne the model
	 */
	public CalculatorListener(ChampernowneModel modelChampernowne){
		this.modelChampernowne=modelChampernowne;
	}
	
	/**
	 * Event manager of the Calculator Panel
	 */
	public void mouseClicked(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();
        Caretaker caretaker=this.modelChampernowne.getCalculator().getCaretaker();
    	Originator originator=this.modelChampernowne.getCalculator().getOriginator();
    	
        if (!(c instanceof JButton)) {
            return;
        }

        JButton buttonPressed = (JButton) c;
        if (!buttonPressed.isEnabled()) {
            return;
        }
      
        switch (buttonPressed.getText()) {
            case "+":
            case "-":
            case "/":
            case "*":
            	this.text=this.text+" "+buttonPressed.getText()+" ";
            	this.calculatorPanel.getOperations().setText(this.text);
                break;
            case "C":
            	this.text="";
            	this.calculatorPanel.getResult().setText("");
            	this.calculatorPanel.getOperations().setText("");
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
            case "(":
            case ")":
            	this.text=this.text+buttonPressed.getText();
            	this.calculatorPanel.getOperations().setText(this.text);
                break;
            case "C10":
            	this.text=this.text+"0.1234";
            	this.calculatorPanel.getOperations().setText(this.text);
            	break;
            case "+/-":
            	this.text=this.text+"-";
            	this.calculatorPanel.getOperations().setText(this.text);
            	break;
            case "=":
            	this.calculatorPanel.getResult().setText("");
            	if(validateExpression(this.text)==-1){
            		this.text="";
            		this.calculatorPanel.getOperations().setText("");
            		this.calculatorPanel.showError("Invalid Expression. The - should not be use to indicate \n a negative number, use +/- instead.");
            	}else{
            		try{
            			this.calculatorPanel.getResult().setText(String.valueOf(this.modelChampernowne.getCalculator().calculate(this.text)));
            		}catch(Exception ex){
            			this.text="";
            			this.calculatorPanel.getResult().setText("");
            			this.calculatorPanel.getOperations().setText("");
                		this.calculatorPanel.showError("Invalid ExpressionInvalid Expression. The - should not be use to indicate \n a negative number, use +/- instead.");
            		}
            		
            	}
            	break;
            case "Save":
            	pos=0;
            	if(!this.calculatorPanel.getResult().getText().toString().equals("")){
            		originator.setState(this.calculatorPanel.getResult().getText().toString());
            		caretaker.addMemento(originator.save());
            	}else{
            		this.calculatorPanel.showError("You don't have an intermediate result.");
            	}
            	break;
            case "Get":
            	this.text="";
            	Memento memento;
            	if(caretaker.size==0)
            		this.calculatorPanel.showError("You have not save an intermediate result.");
            	else{
            		if(caretaker.size==1)
            			memento=caretaker.getMemento(0);
            		else if(caretaker.size==2)
            			memento=caretaker.getMemento(pos%2);
            		else
            			memento=caretaker.getMemento(pos%caretaker.size);
            		
            		this.calculatorPanel.getResult().setText(memento.getState());
            		this.calculatorPanel.getOperations().setText(memento.getState());
            		this.text=memento.getState();
            	}
            	pos++;
            	break;
            default:
            	this.text="";
            	this.calculatorPanel.getOperations().setText("");
                break;
        }

    }
	
	/**
	 * Validates the input expressions
	 * @param text the expression
	 * @return -1 error, 0 no error
	 */
	public int validateExpression(String text){
		int numberParenthesis=0;
		int numberOfNumbers=0;
		char lastElem='$';//no existing value
		int numberPoints=0;
		//N numbers
		//O operators
		//# negative no operator
		
		char[] textDecom=text.toCharArray();
		
		if(text.equals(""))
			return -1;
		try{
			for(int i=0;i<textDecom.length;i++){
				//this.calculatorPanel.showError("ELEM"+String.valueOf(textDecom[i]));
				if(textDecom[i]=='+' || (i+1<textDecom.length && textDecom[i]=='-' && textDecom[i+1]==' ') || textDecom[i]=='/' || textDecom[i]=='*'){
					
					if(lastElem!='N' && lastElem!=')')
						return -1;
					else{
						lastElem='O';
						numberOfNumbers=0;
						numberPoints=0;
					}
				}else if(textDecom[i]<='9' && textDecom[i]>='0'){
					
					if(numberOfNumbers==0 && numberPoints==0){
						if(lastElem=='.')
							return -1;	
					}else{
						if(lastElem!='.' && lastElem!='N')
							return -1;
					}
					numberOfNumbers++;
					lastElem='N';
				}else if(textDecom[i]=='-'){
					
					if(lastElem!='(' && lastElem!='$'){
						return -1;
					}
				
					if(i<textDecom.length && !(textDecom[i+1]<='9' && textDecom[i+1]>='0')){
						return -1;
					}
						
					lastElem='#';
				}else if(textDecom[i]=='.'){
					if(numberPoints>0 || !(i+1<textDecom.length && textDecom[i+1]<='9' && textDecom[i+1]>='0') || lastElem!='N')
						return -1;
					lastElem='.';
					numberPoints++;
					numberOfNumbers=0;
				}else if(textDecom[i]=='('){
					if(lastElem!='O' && lastElem!='$' && lastElem!='(')
						return -1;
					
					if(i<textDecom.length && !((textDecom[i+1]<='9' && textDecom[i+1]>='0') || textDecom[i+1]=='(') || textDecom[i+1]=='-'){
						return -1;
					}
					
					lastElem='(';
					numberParenthesis++;
					numberPoints=0;
				}else if(textDecom[i]==')'){
					if(lastElem!='N' && lastElem!=')')
						return -1;
					lastElem=')';
					numberParenthesis--;
					numberPoints=0;
					numberOfNumbers=0;
				}else if(textDecom[i]==' ')
					continue;
				
			}
			
			if(numberParenthesis!=0)
				return -1;

		}catch(Exception e){
			return -1;
		}
				
		
		return 0;
	}
}
