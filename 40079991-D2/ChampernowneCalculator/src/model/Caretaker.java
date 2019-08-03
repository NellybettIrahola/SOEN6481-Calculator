package model;

import java.util.ArrayList;

/**
 * Caretaker of Memento pattern
 * @author nellybett
 *
 */
public class Caretaker {
	public int size=0;
	private ArrayList<Memento> mementos = new ArrayList<>();

	/**
	 * Adds a memento to the list
	 * @param m memento
	 */
    public void addMemento(Memento m) {
        if(mementos.size()>9)
        	mementos.remove(1);
    	mementos.add(m);
    	this.size++;
    }

    /**
     * Gets a memento given a position
     * @param pos postition
     * @return memento
     */
    public Memento getMemento(int pos) {
        return mementos.get(pos);
    }
}
