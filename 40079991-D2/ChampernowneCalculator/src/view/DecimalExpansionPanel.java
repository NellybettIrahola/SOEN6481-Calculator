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

import controller.DecimalExpansionListener;

/**
 * Decimal Expansion view
 * @author nellybett
 *
 */
public class DecimalExpansionPanel extends JPanel {
	private JTextArea numberResult;
	private JPanel menu;
	private JButton calculateButton;
	private JTextField decimals;
	private JComboBox baseSelection;
	private JTextField pattern;
	private JTextField position;
	private JButton findPattern;
	
	/**
	 * Getter of the numberResult attribute
	 * @return the value
	 */
	public JTextArea getNumberResult() {
		return numberResult;
	}

	/**
	 * Setter of the numberResult attribute
	 * @param numberResult the new value
	 */
	public void setNumberResult(JTextArea numberResult) {
		this.numberResult = numberResult;
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
	 * Getter of the calculateButton attribute
	 * @return the value
	 */
	public JButton getCalculateButton() {
		return calculateButton;
	}

	/**
	 * Setter of the calculateButton attribute
	 * @param calculateButton the new value
	 */
	public void setCalculateButton(JButton calculateButton) {
		this.calculateButton = calculateButton;
	}

	/**
	 * Getter of the decimals attribute
	 * @return the value
	 */
	public JTextField getDecimals() {
		return decimals;
	}

	/**
	 * Setter of the decimals attribute
	 * @param decimals the new value
	 */
	public void setDecimals(JTextField decimals) {
		this.decimals = decimals;
	}

	/**
	 * Getter of the baseSelection attribute
	 * @return the value
	 */
	public JComboBox getBaseSelection() {
		return baseSelection;
	}

	/**
	 * Setter of the baseSelection attribute
	 * @param baseSelection the new value
	 */
	public void setBaseSelection(JComboBox baseSelection) {
		this.baseSelection = baseSelection;
	}

	/**
	 * Getter of the patter attribute
	 * @return the value
	 */
	public JTextField getPattern() {
		return pattern;
	}

	/**
	 * Setter of the patter attribute
	 * @param pattern the new value
	 */
	public void setPattern(JTextField pattern) {
		this.pattern = pattern;
	}

	/**
	 * Getter of the position attribute
	 * @return the value
	 */
	public JTextField getPosition() {
		return position;
	}

	/**
	 * Setter of the position attribute
	 * @param position the new value
	 */
	public void setPosition(JTextField position) {
		this.position = position;
	}

	/**
	 * Getter of the findPatter attribute
	 * @return the value
	 */
	public JButton getFindPattern() {
		return findPattern;
	}

	/**
	 * Setter of the findPatter attribute
	 * @param findPattern the new value
	 */
	public void setFindPattern(JButton findPattern) {
		this.findPattern = findPattern;
	}
	
	/**
	 * Constructor
	 * @param listener the value of listener
	 */
	public DecimalExpansionPanel(DecimalExpansionListener listener){
		String[] bases={"10","2"};
		JLabel baseText=new JLabel("Select Base:");
		JLabel decimalsText=new JLabel("Number of decimals:");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		this.decimals=new JTextField();
		this.decimals.setPreferredSize(new Dimension(40,25));
		this.baseSelection=new JComboBox(bases);
		
		Border border = decimalsText.getBorder();
		Border margin = new EmptyBorder(0,20,0,0);
		decimalsText.setBorder(new CompoundBorder(border, margin));
        
		this.calculateButton=new JButton("Calculate Number");
        this.menu=new JPanel();
        this.menu.setLayout(new FlowLayout());
        this.menu.add(baseText);
        this.menu.add(this.baseSelection);
        this.menu.add(decimalsText);
        this.menu.add(this.decimals);
        
        this.menu.setPreferredSize(new Dimension(550,400));
        
        this.numberResult=new JTextArea();
        this.numberResult.setLineWrap(true);
        this.numberResult.setEditable(false);
        JScrollPane textDecryptScroll=new JScrollPane(this.numberResult,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textDecryptScroll.setPreferredSize(new Dimension(500,200));
        this.menu.add(textDecryptScroll);
        this.menu.add(calculateButton);
        this.add(this.menu);
        
        
        
        JPanel textArea=new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.LEFT));	
        textArea.setPreferredSize(new Dimension(500,300));
        
        Border borderText = textArea.getBorder();
		Border marginText = new EmptyBorder(0,40,0,40);
		textArea.setBorder(new CompoundBorder(borderText, marginText));
        
        JLabel patternLabel=new JLabel("Introduce Pattern:");
        this.pattern=new JTextField();
        this.pattern.setPreferredSize(new Dimension(200, 30));
        textArea.add(patternLabel);
        textArea.add(this.pattern);
        
        this.findPattern=new JButton(" Search ");
        textArea.add(findPattern);
        
        JLabel positionLabel=new JLabel("Position of pattern:");
        this.position=new JTextField();
        this.position.setEditable(false);
        this.position.setPreferredSize(new Dimension(50, 30));
        textArea.add(positionLabel);
        textArea.add(this.position);
        
        this.add(textArea);
        this.setListener(listener);
        this.repaint();
        this.revalidate();
	}
	
	/**
	 * Listener setter
	 * @param listener the listener
	 */
	public void setListener(DecimalExpansionListener listener){
		this.calculateButton.addMouseListener(listener);
		this.findPattern.addMouseListener(listener);
	}
	
	/**
	 * Show error messages
	 * @param errorMessage the message
	 */
	public void showError(String errorMessage){
		JOptionPane.showMessageDialog(this,errorMessage,"WARNING.", JOptionPane.WARNING_MESSAGE);
	}
}
