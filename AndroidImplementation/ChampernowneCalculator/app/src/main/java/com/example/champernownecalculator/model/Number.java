package com.example.champernownecalculator.model;

public interface Number {
	abstract int getPatternPosition(String pattern, String number);
	abstract String calculate(int decimals, double base);
	abstract String calculateAlternative(int decimals, int base);
	
}
