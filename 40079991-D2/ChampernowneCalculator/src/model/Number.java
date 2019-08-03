package model;

/**
 * Interface to add more numbers in the future
 * @author nellybett
 *
 */
public interface Number {
	abstract int getPatternPosition(String pattern, String number);
	abstract String calculateAlternative(int decimals, int base);
	
}
