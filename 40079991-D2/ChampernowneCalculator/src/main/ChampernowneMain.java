package main;

import controller.CalculatorListener;
import controller.ChampernowneController;
import controller.DecimalExpansionListener;
import controller.DecryptMessageListener;
import controller.EncryptMessageListener;
import model.ChampernowneModel;
import view.ChampernowneView;

/**
 * Main class of the app
 * @author nellybett
 *
 */
public class ChampernowneMain {

	/**
	 * Main method of the class
	 * @param args parameters
	 */
	public static void main(String[] args) {
		ChampernowneModel modelChampernowne=new ChampernowneModel();
		CalculatorListener calculatorListener=new CalculatorListener(modelChampernowne);
		DecimalExpansionListener decimalListener=new DecimalExpansionListener(modelChampernowne);
		DecryptMessageListener decryptListener=new DecryptMessageListener(modelChampernowne);
		EncryptMessageListener encryptListener=new EncryptMessageListener(modelChampernowne);
		
		ChampernowneView viewChampernowne = new ChampernowneView(decimalListener,calculatorListener,encryptListener,decryptListener);
	    ChampernowneController controllerChampernowne = new ChampernowneController(modelChampernowne,viewChampernowne);
	    viewChampernowne.setControllerChampernowne(controllerChampernowne);

	}

}
