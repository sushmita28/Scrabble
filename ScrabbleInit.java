package wordsFreq;

import java.util.ArrayList;

public class ScrabbleInit {
		
		String largestWord;
		int maxScore;
		static char[] letters = {'A','b'};
		int[] scores = {4,2,6,1};
		static ArrayList<String> poss = new ArrayList<String>();;
		
		public void checkMax(String checkString){

			int newWordScore = 0;
			
			int index = -1;
			
			for(int i=0; i<checkString.length(); i++){
			char alphabet = checkString.charAt(i);
			for (int j = 0; j < letters.length; i++) {
				  if (letters[j] == alphabet) {
				    index = j;
				    break;
				  }
				}
			{
			newWordScore += scores[index];
			}
			if(newWordScore > maxScore)
			{
			largestWord = checkString;
			maxScore = newWordScore;
			}
			}
		}

	public static void permutation(String str) { 
	    permutation("", str); 
	    
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    poss.add(prefix);
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	/*
	public static String[] readFile(String filename,int size)
	{
		File file = new File(filename);
		
		 String[] words = new String[size];
		  Scanner input;
		try {
			input = new Scanner(file);
			for (int i = 0; i < size; i++) {
		            words[i] = input.next();
		       }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		return words;
	      
	}
	
	public static boolean searchWord(String[] words,String value)
	{
		  if(binarySearch(words,value)>=0)
	        {
	        return true;
	        }
	        else
	        {
	        return false;
	        }
	}
    
    public static int binarySearch(String[] words, String value) {
        return binarySearch(words, value, 0, words.length - 1);
    }
    
    
    public static int binarySearch(String[] words, String value, int min, int max) {
        if (min > max) {
            return -1;
        }
        
        int mid = (max + min) / 2;
        
        if (words[mid].equals(value)) {
            return mid;
        } else if(words[mid].compareTo(value) > 0) {
            return binarySearch(words, value, min, mid - 1);
        } else {
            return binarySearch(words, value, mid + 1, max);
        }
    }
    */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = String.valueOf(letters);
		permutation(str);
		System.out.println(poss);
		
		
	}

}
