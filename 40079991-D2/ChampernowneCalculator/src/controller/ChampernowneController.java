package controller;

import model.ChampernowneModel;
import view.ChampernowneView;

/**
 * App Main Controller
 * @author nellybett
 *
 */
public class ChampernowneController {
	ChampernowneModel modelChampernowne;
	ChampernowneView viewChampernowne;
	
	/**
	 * Initial setting of the model and view. Constructor.
	 * @param modelChampernowne the model of the application
	 * @param viewChampernowne the view of the application
	 */
	public ChampernowneController(ChampernowneModel modelChampernowne, ChampernowneView viewChampernowne){
		this.modelChampernowne=modelChampernowne;
		this.viewChampernowne=viewChampernowne;
		//this.viewChampernowne.initialMenu(this.modelChampernowne,MenuListener menuListener);
		this.viewChampernowne.setVisible(true);
	}
    
}
