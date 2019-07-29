package com.example.champernownecalculator.model;


import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Class to manage operations with the Champernowne Constant
 * @author Nellybett Irahola
 *
 */
public class Champernowne implements Number {
	LinkedHashMap<Integer,String> hashLetters=new LinkedHashMap<Integer,String>();
	
	/**
	 * Constructor: initialize the hashes
	 */
	public Champernowne(){
		
		//Cipher Hash
		
		this.hashLetters.put(0, "A");
		this.hashLetters.put(1, "B");
		this.hashLetters.put(2, "C");
		this.hashLetters.put(3, "D");
		this.hashLetters.put(4, "E");
		this.hashLetters.put(5, "F");
		this.hashLetters.put(6, "G");
		this.hashLetters.put(7, "H");
		this.hashLetters.put(8, "I");
		this.hashLetters.put(9, "J");
		this.hashLetters.put(10, "K");
		this.hashLetters.put(11, "L");
		this.hashLetters.put(12, "M");
		this.hashLetters.put(13, "N");
		this.hashLetters.put(14, "O");
		this.hashLetters.put(15, "P");
		this.hashLetters.put(16, "Q");
		this.hashLetters.put(17, "R");
		this.hashLetters.put(18, "S");
		this.hashLetters.put(19, "T");
		this.hashLetters.put(20, "U");
		this.hashLetters.put(21, "V");
		this.hashLetters.put(22, "W");
		this.hashLetters.put(23, "X");
		this.hashLetters.put(24, "Y");
		this.hashLetters.put(25, "Z");

		this.hashLetters.put(26, "a");
		this.hashLetters.put(27, "b");
		this.hashLetters.put(28, "c");
		this.hashLetters.put(29, "d");
		this.hashLetters.put(30, "e");
		this.hashLetters.put(31, "f");
		this.hashLetters.put(32, "g");
		this.hashLetters.put(33, "h");
		this.hashLetters.put(34, "i");
		this.hashLetters.put(35, "j");
		this.hashLetters.put(36, "k");
		this.hashLetters.put(37, "l");
		this.hashLetters.put(38, "m");
		this.hashLetters.put(39, "n");
		this.hashLetters.put(40, "o");
		this.hashLetters.put(41, "p");
		this.hashLetters.put(42, "q");
		this.hashLetters.put(43, "r");
		this.hashLetters.put(44, "s");
		this.hashLetters.put(45, "t");
		this.hashLetters.put(46, "u");
		this.hashLetters.put(47, "v");
		this.hashLetters.put(48, "w");
		this.hashLetters.put(49, "x");
		this.hashLetters.put(50, "y");
		this.hashLetters.put(51, "z");
		
		this.hashLetters.put(52," ");
		this.hashLetters.put(53,"!");
		this.hashLetters.put(54,"\"");
		this.hashLetters.put(55,"#");
		this.hashLetters.put(56,"$");
		this.hashLetters.put(57,"%");
		this.hashLetters.put(58,"&");
		this.hashLetters.put(59,"'");
		this.hashLetters.put(60,"(");
		this.hashLetters.put(61,")");
		this.hashLetters.put(62,"*");
		this.hashLetters.put(63,"+");
		this.hashLetters.put(64,",");
		this.hashLetters.put(65,"-");
		this.hashLetters.put(66,".");
		this.hashLetters.put(67,"/");
		this.hashLetters.put(68,"0");
		this.hashLetters.put(69,"1");
		this.hashLetters.put(70,"2");
		this.hashLetters.put(71,"3");
		this.hashLetters.put(72,"4");
		this.hashLetters.put(73,"5");
		this.hashLetters.put(74,"6");
		this.hashLetters.put(75,"7");
		this.hashLetters.put(76,"8");
		this.hashLetters.put(77,"9");
		this.hashLetters.put(78,":");
		this.hashLetters.put(79,";");
		this.hashLetters.put(80,"<");
		this.hashLetters.put(81,"=");
		this.hashLetters.put(82,">");
		this.hashLetters.put(83,"?");
		this.hashLetters.put(84,"@");
		this.hashLetters.put(85,"_");
		this.hashLetters.put(86,"[");
		this.hashLetters.put(87,"\\");
		this.hashLetters.put(88,"]");
		this.hashLetters.put(89,"^");
		this.hashLetters.put(90,"`");
		this.hashLetters.put(91,"{");	
		this.hashLetters.put(92,"|");
		this.hashLetters.put(93,"}");
		this.hashLetters.put(94,"~");
		this.hashLetters.put(95,"Ç");
		this.hashLetters.put(96,"ç");
		this.hashLetters.put(97,"è");	
		this.hashLetters.put(98,"é");
		this.hashLetters.put(99,"ê");
		this.hashLetters.put(100,"ë");
		this.hashLetters.put(101,"È");	
		this.hashLetters.put(102,"É");	
		this.hashLetters.put(103,"Ê");
		this.hashLetters.put(104,"Ë");
		this.hashLetters.put(105,"À");
		this.hashLetters.put(106,"Â");
		this.hashLetters.put(107,"à");
		this.hashLetters.put(108,"â");
		this.hashLetters.put(109,"Ù");
		this.hashLetters.put(110,"Û");
		this.hashLetters.put(111,"Ü");
		this.hashLetters.put(112,"ù");
		this.hashLetters.put(113,"û");
		this.hashLetters.put(114,"ü");
		this.hashLetters.put(115,"ô");
		this.hashLetters.put(116,"Ô");
		this.hashLetters.put(117,"Œ");
		this.hashLetters.put(118,"œ");
		this.hashLetters.put(119,"Ï");
		this.hashLetters.put(120,"Î");
		this.hashLetters.put(121,"¿");
		this.hashLetters.put(122,"¡");
		this.hashLetters.put(123,"î");
		this.hashLetters.put(124,"ï");

		
	}
	
	/**
	 * Identifies a pattern in the Champernowne Constant
	 * @return position of the pattern
	 */
	@Override
	public int getPatternPosition(String pattern, String number) {
		return number.indexOf(pattern);
	}

	/**
	 * Calculates the Champernowne Constant by formula
	 * @return the number
	 */
	@Override
	public String calculate(int decimals, double base) {
		double result;
		double finalResult=0;
		for(int i=1;i<=decimals;i++){
			result=0;
			for(int j=1;j<=i;j++){
				double aux=j;
				result=result+Math.floor(log(base,aux));
			}
			result=result+i;
			result=Math.pow(base,result);
			result=i/result;
			finalResult=finalResult+result;
		}
		return String.valueOf(finalResult);
	}

	/**
	 * Change bases of algorithms
	 * @param base the base to transform
	 * @param valor the element
	 * @return the new base
	 */
	 public static double log(double base, double valor) {
	        return Math.log(valor) / Math.log(base);
	 }
	 
	 /**
	  * Transform a number from one base to another
	  * @param number 
	  * @param sBase source base
	  * @param dBase destiny base
	  * @return number in new base
	  */
	 public String baseConversion(String number, int sBase, int dBase) 
	 { 
		 return Integer.toString(Integer.parseInt(number, sBase), dBase); 
	 }

	 /**
	  * Calculates the number in a determine base by construction
	  */
	@Override
	public String calculateAlternative(int decimals, int base) {
		String result="0.";
		for(int i=1;i<=decimals;i++){
			result=result+baseConversion(String.valueOf(i),10,base);
		}
		return result.substring(0, decimals+2);
	}
	
	/**
	 * Encrypts a message using substitution cipher
	 * @param message
	 * @param number
	 * @return encrypted message
	 */
	public String encryptMessage(String message, String number){
		Random rand = new Random();
		int n = rand.nextInt(50)+1;
		
		String newMessage="";
		
		for(int i=0;i<message.toCharArray().length;i++){
			int modifyBy=Character.getNumericValue(number.charAt(n+i+2));
			int j=0;
			boolean founded=false;
			for (String x: this.hashLetters.values()){
				if(x.equals(Character.toString(message.charAt(i)))){
					founded=true;	
					break;
				}
				j=j+1;
			}
			
			
			if(founded==false){
				newMessage=newMessage+Character.toString(message.charAt(i));
			}else{
				newMessage=newMessage+this.hashLetters.get((modifyBy+j)%124);
			}
			
		}
		return newMessage+". The key is: "+n;
		
	}
	
	/**
	 * Decrypts a message using substitution cipher
	 * @param message
	 * @param number
	 * @param key
	 * @return decrypted message
	 */
	public String decryptMessage(String message, String number,int key){
		
		String newMessage="";
		String letter="";
		for(int i=0;i<message.toCharArray().length;i++){
			int modifyBy=Character.getNumericValue(number.charAt(key+i+2));
			int j=0;
			boolean founded=false;
			for (String x: this.hashLetters.values()){
				if(x.equals(Character.toString(message.charAt(i)))){
					founded=true;
					break;
				}
				j=j+1;
			}
			
			if(j-modifyBy-1<0)
				letter=this.hashLetters.get(124+(j-modifyBy));
			else
				letter=this.hashLetters.get(j-modifyBy);
			
			if(founded==false){
				newMessage=newMessage+Character.toString(message.charAt(i));
			}else{
				newMessage=newMessage+letter;
			}
		}
		return newMessage;
	}
	
	/**
	 * Executes the encryption
	 * @param messageToEncrypt
	 * @return encrypted message
	 */
	public String encryptSubtitution(String messageToEncrypt){
		String numeroAlter=calculateAlternative(120,10);
		String message=encryptMessage(messageToEncrypt, numeroAlter);
		
		return message;
	}
	
	/**
	 * Executes decryption
	 * @param message
	 * @param key
	 * @return decrypted message
	 */
	public String decryptSubstitution(String message,int key){
		String numeroAlter=calculateAlternative(120,10);
		String messageDec=decryptMessage(message, numeroAlter,key);
		
		return messageDec;
	}

	/**
	 * Ecrypt Message given a number
	 * @param message
	 * @param number
	 * @return encrypted message using one-time pad
	 */
	public String encryptMessageOneTime(String message, String number){
		Random rand = new Random();
		int n = rand.nextInt(50)+1;
		String letter="";
		String newMessage="";
		
		for(int i=0;i<message.toCharArray().length;i++){
			int j=0;
			boolean founded=false;
			for (String x: this.hashLetters.values()){
				if(x.equals(Character.toString(message.charAt(i)))){
					founded=true;
					break;
				}
				j=j+1;
			}
		
			if(founded){
				int numberBinary=Integer.valueOf(baseConversion(number.substring((n+i*7+2),(n+i*7+2)+7),2,10));
				int intermediate=j^numberBinary;
				//System.out.println("posicion encontrado:"+j+" numero binario:"+numberBinary+" resultado de xor:"+intermediate);
				letter=this.hashLetters.get(intermediate);
			}else{
				letter=Character.toString(message.charAt(i));
			}
			
			newMessage=newMessage+letter;
		}
		//System.out.println(newMessage);
		return newMessage+". The key is: "+n;
		
	}

	/**
	 *
	 * @param message
	 * @param number
	 * @param key
	 * @return
	 */
	public String decryptMessageOneTime(String message, String number,int key){
		String newMessage="";
		String letter="";
		
		for(int i=0;i<message.toCharArray().length;i++){
			int j=0;
			boolean founded=false;
			for (String x: this.hashLetters.values()){
				if(x.equals(Character.toString(message.charAt(i)))){
					founded=true;
					break;
				}
				j=j+1;
			}
			
			if(founded){
				int numberBinary=Integer.valueOf(baseConversion(number.substring((key+i*7+2),(key+i*7+2)+7),2,10));
				int intermediate=j^numberBinary;
				letter=this.hashLetters.get(intermediate);
			}else{
				letter=Character.toString(message.charAt(i));
			}
			
			newMessage=newMessage+letter;
		}
		
		return newMessage;
	}

	/**
	 * Provides an specific number to call the method that encrypts a message given a number
	 * @param message
	 * @return Encrypted message
	 */
	public String encryptOneTimePad(String message){
		return encryptMessageOneTime(message, calculateAlternative(message.toCharArray().length*8+60,2));
	}


	/**
	 *
	 * @param message
	 * @param key
	 * @return
	 */
	public String decryptOneTimePad(String message, int key){
		return decryptMessageOneTime(message, calculateAlternative(message.toCharArray().length*8+60,2), key);
	}
	
	

}
