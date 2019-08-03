package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.CalculatorListener;
import controller.ChampernowneController;
import controller.DecimalExpansionListener;
import controller.DecryptMessageListener;
import controller.EncryptMessageListener;

import javax.swing.JComponent;

/**
 * Main View of the app
 * @author nellybett
 *
 */
public class ChampernowneView extends JFrame{
	JTabbedPane multiplePanels;
	ChampernowneController controllerChampernowne;
	
	/**
	 * Setter of the Controller
	 * @param controllerChampernowne the controller of the application
	 */
	public void setControllerChampernowne(ChampernowneController controllerChampernowne) {
		this.controllerChampernowne = controllerChampernowne;
	}

	/**
	 * Constructor
	 * @param decimalListener listener of the Decimal Expansion view
	 * @param calculatorListener listener of the Calculator view
	 * @param encryptMessageListener listener of the Encrypt Message view
	 * @param decryptMessageListener listener of the Decrypt Message view
	 */
	public ChampernowneView(DecimalExpansionListener decimalListener,CalculatorListener calculatorListener, EncryptMessageListener encryptMessageListener,DecryptMessageListener decryptMessageListener ){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        //this.getContentPane().setLayout(new BorderLayout());	
        
        this.multiplePanels = new JTabbedPane();
        
        String[] titles = {"Calculator","Champernowne Constant", "Encrypt Message","Decrypt Message"};
        JComponent[] components = {new CalculatorPanel(calculatorListener),new DecimalExpansionPanel(decimalListener), new EncryptMessagePanel(encryptMessageListener), new DecryptMessagePanel(decryptMessageListener)};
        
        calculatorListener.setCalculatorPanel((CalculatorPanel)components[0]);
        decimalListener.setDecimalPanel((DecimalExpansionPanel)components[1]);
        encryptMessageListener.setEncryptPanel((EncryptMessagePanel)components[2]);
        decryptMessageListener.setDecryptPanel((DecryptMessagePanel)components[3]);
        for (int i = 0; i < components.length; i++){
            components[i].setSize(200,200);
            this.multiplePanels.addTab(titles[i], components[i]);
        }

        this.getContentPane().add(this.multiplePanels);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
      
		this.setVisible(true);
        
	}
    
}
