package model;

/**
 * Memento pattern
 * @author nellybett
 *
 */
public class Memento {
	private String state;

	/**
	 * Stores a state
	 * @param state intermediate result
	 */
    public Memento(String state) {
        this.state = state;
    }

    /**
     * Getter of state
     * @return state
     */
    public String getState() {
        return state;
    }
}
