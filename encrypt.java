import java.util.ArrayList;


public class encrypt {
	
	public String trimCipherKey(String cipherKey){
		//cipherKey.toUpperCase();
		String trimmedCipherKey = "";
		//this will hold our char's the will later be appended to the trimmedCipherKey
		ArrayList<Character> usedChar = new ArrayList<Character>();
		for(int i =0; i<cipherKey.length(); i++){
			if(usedChar.contains(cipherKey.charAt(i))|| cipherKey.charAt(i)==32){
				;
			}else{
				usedChar.add(cipherKey.charAt(i));
			}
		}
		//this will append the usedChars to the trimmedCipherKey
		for(int i = 0; i<usedChar.size(); i++){
			trimmedCipherKey += usedChar.get(i);					
		}
		return trimmedCipherKey;
	}
	
	public String ceaserCipher(String plainText, String cipherKeyIn){
		String cipherKey = cipherKeyIn;
		cipherKey = cipherKey.toUpperCase();
		char[] alphabet = new char[26];
		//lets create an array or alphabets
		for(int i=0; i<26; i++){
			alphabet[i] = (char) (i+65);
			//System.out.print(alphabet[i]);
		}
		ArrayList<Character> usedAlphabet = new ArrayList<Character>();
		cipherKey = trimCipherKey(cipherKey);

		for(int i =0; i<26; i++){			
			//first we put our cipherKey and remove any duplicate letters			
			if(i < cipherKey.length() ){
				usedAlphabet.add(cipherKey.charAt(i));
			}else if(usedAlphabet.contains(alphabet[i])){
				;
			}else{
				usedAlphabet.add(alphabet[i]);
			}
			/*
			 * we are missing some letters in the alphabet append the missing
			 * letters at the end of the list.
			 */
					
		}if(usedAlphabet.size() <26){
				//ArrayList<Character> missingAlphabet = new ArrayList<Character>();
			usedAlphabet = addMissingLetters(usedAlphabet);
				//usedAlphabet.addAll(missingAlphabet);
		}	
		for(int i=0; i<26; i++){			
			System.out.print(usedAlphabet.get(i));
		}
		System.out.println();
		boolean isDone =false;
		/*
		 * This will be our encryption loop that will take the plain text 
		 * and change it into cipher text. Once we are done the encryption
		 * we will set isDone = true.
		 */
		String cipherText = "";
		plainText = plainText.toUpperCase();
		plainText.replaceAll("\\s","");
		// a.replaceAll("\\s+","");
		int currentChar;
		//mathFunction = char - 65
			for(int i = 0; i<plainText.length(); i++){
				if(plainText.charAt(i)<65 || plainText.charAt(i)> 90){
					;
				}else{
					//System.out.println(cipherText);
					//System.out.println(plainText);
					currentChar = plainText.charAt(i) - 65;
					cipherText += usedAlphabet.get(currentChar)+"";
				}
			}
		cipherText = cipherText.replaceAll(".....(?!$)", "$0 ");
		return cipherText;
	}
	public String decryptCeaserCipher(String encryptedText, String key){
		
		String cipherKey = key;
		cipherKey = cipherKey.toUpperCase();
		char[] alphabet = new char[26];
		//lets create an array or alphabets
		for(int i=0; i<26; i++){
			alphabet[i] = (char) (i+65);
			//System.out.print(alphabet[i]);
		}
		ArrayList<Character> usedAlphabet = new ArrayList<Character>();
		cipherKey = trimCipherKey(cipherKey);

		for(int i =0; i<26; i++){			
			//first we put our cipherKey and remove any duplicate letters			
			if(i < cipherKey.length() ){
				usedAlphabet.add(cipherKey.charAt(i));
			}else if(usedAlphabet.contains(alphabet[i])){
				;
			}else{
				usedAlphabet.add(alphabet[i]);
			}
			/*
			 * we are missing some letters in the alphabet append the missing
			 * letters at the end of the list.
			 */
					
		}if(usedAlphabet.size() <26){
				//ArrayList<Character> missingAlphabet = new ArrayList<Character>();
			usedAlphabet = addMissingLetters(usedAlphabet);
				//usedAlphabet.addAll(missingAlphabet);
		}	
		String plainText = "";
		encryptedText = encryptedText.toUpperCase();
		encryptedText.replaceAll("\\s","");
		int currentChar;
			for(int i = 0; i<encryptedText.length(); i++){
				if(encryptedText.charAt(i)<65 || encryptedText.charAt(i)> 90){
					;
				}else{
					currentChar = getPosition(encryptedText.charAt(i), usedAlphabet);
					plainText += alphabet[currentChar]+"";
				}
			}
		plainText = plainText.replaceAll(".....(?!$)", "$0 ");
		return plainText;
	}
	public int getPosition(int currentChar, ArrayList<Character> cipherAlphabet){
		
		for(int i=0; i<cipherAlphabet.size(); i++){
			if(currentChar == cipherAlphabet.get(i)){
				return i;
			}else
				;
		}
		return (Integer) null;
			
	}
	
	private ArrayList<Character> addMissingLetters(ArrayList<Character> usedAlphabet1) {
		for(int i=0; i<26; i++){
			if(usedAlphabet1.contains((char) (i+65))){
				;
			}else{
				usedAlphabet1.add((char) (i+65));
			}
		}
		return usedAlphabet1;
	}

	public static void main(String[] args){
	}
}
