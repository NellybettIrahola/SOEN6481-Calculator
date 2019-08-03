package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CalculatorListener;


/**
 * Calculator view
 * @author nellybett
 *
 */
public class CalculatorPanel extends JPanel{
	
	JTextArea operations;
	JButton[] calculatorOperation;
	JTextField result;
	
	/**
	 * Getter of operations
	 * @return the value
	 */
	public JTextArea getOperations() {
		return operations;
	}

	/**
	 * Setter of operations
	 * @param operations the new value
	 */
	public void setOperations(JTextArea operations) {
		this.operations = operations;
	}

	/**
	 * Getter of calculator buttons
	 * @return the value
	 */
	public JButton[] getCalculatorOperation() {
		return calculatorOperation;
	}

	/**
	 * Setter of calculator buttons
	 * @param calculatorOperation the new value
	 */
	public void setCalculatorOperation(JButton[] calculatorOperation) {
		this.calculatorOperation = calculatorOperation;
	}

	/**
	 * Getter of result
	 * @return the value
	 */
	public JTextField getResult() {
		return result;
	}

	/**
	 * Setter of result
	 * @param result the new value
	 */
	public void setResult(JTextField result) {
		this.result = result;
	}

	/**
	 * Constructor
	 * @param listener the value
	 */
	public CalculatorPanel(CalculatorListener listener){
		
		String[] elements={"1","2","3","C","C10","4","5","6","(",")","7","8","9","+","-",".","0","+/-","/","*","Get","=","Save"};
		this.calculatorOperation=new JButton[elements.length];
		this.result=new JTextField();
		
		JPanel tittles=new JPanel();
		tittles.setPreferredSize(new Dimension(350,80));
		JLabel tittle=new JLabel("Eternity Numbers Calculator");
		tittle.setFont(new Font("Serif", Font.BOLD, 18));
		
		JLabel subtittle=new JLabel("Champernowne Constant (C10)");
		subtittle.setFont(new Font("Serif", Font.BOLD, 14));
		
		tittles.add(tittle);
		tittles.add(subtittle);
		
		JPanel buttons=new JPanel();
		buttons.setLayout(new GridLayout(5,5));
		int i=0;
		
		for(String x:elements){
			JButton aux=new JButton(x);
			aux.setPreferredSize(new Dimension(70,50));
			this.calculatorOperation[i]=aux;
			buttons.add(aux);
			i++;
		}
		
		this.result.setPreferredSize(new Dimension(350,30));
		this.result.setEditable(false);
		this.result.setHorizontalAlignment(JTextField.RIGHT);
		
		this.operations=new JTextArea();
	    this.operations.setLineWrap(true);
	    this.operations.setEditable(false); 
	    JScrollPane textOperationScroll=new JScrollPane(this.operations,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    textOperationScroll.setPreferredSize(new Dimension(350,70));
	    
	    this.add(tittles);
	    this.add(this.result);
	    this.setListener(listener);
	    this.add(textOperationScroll);
	    this.add(buttons);
	}
	
	/**
	 * Setter of the listener
	 * @param listener the listener
	 */
	public void setListener(CalculatorListener listener){
		for(JButton x:this.calculatorOperation){
			x.addMouseListener(listener);
		}
	}
	
	/**
	 * Show alert message in the view
	 * @param errorMessage the message
	 */
	public void showError(String errorMessage){
		JOptionPane.showMessageDialog(this,errorMessage,"WARNING.", JOptionPane.WARNING_MESSAGE);
	}
}
