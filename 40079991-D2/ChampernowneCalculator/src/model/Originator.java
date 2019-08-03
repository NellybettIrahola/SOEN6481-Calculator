package model;

/**
 * Originator from Memento pattern, to save intermediate results
 * @author nellybett
 *
 */
public class Originator {
	 private String state;
	 	/**
	 	 * Stores a state
	 	 * @param state the new state
	 	 */
	    public void setState(String state) {
	        this.state = state;
	    }
	    
	    /**
	     * Stores the state in a memento
	     * @return memento
	     */
	    public Memento save() {
	        return new Memento(state);
	    }
	    
	    /**
	     * Restore the state
	     * @param m restores a memento state
	     */
	    public void restore(Memento m) {
	        state = m.getState();
	    }
}
