package frequentNwords;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class ScrabbleInit{
		
		static String largestWord = null;
		static int maxScore = 0;
		static char[] letters = {' ','b','c', 'd' , 'e', 'f','g'};
		static int[] scores = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
//		static int[] scores = {0,3,3,2,1,4,2};
		static ArrayList<String> poss = new ArrayList<String>();;
		
		
		
		public static void checkMax(String checkString){

			int newWordScore = 0;
			
			int index = -1;
			
			for(int i=0; i<checkString.length();i++) {
				if(checkString.charAt(i)!=' ')
					newWordScore += scores[(int)checkString.charAt(i)-(int)'a'];
			}
			if(newWordScore > maxScore) {
				maxScore = newWordScore;
				largestWord = checkString;
			}
		}

	public static void permutation(String str) { 
	    permutation("", str); 
	    
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if(prefix.length()!=0)
	    poss.add(prefix);
	    if(n!=0){
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static String[] readFile(int size) throws IOException
	{
		String[] words = new String[size];
		File file = new File("sowpods.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		int i = 0;
		while ((line = br.readLine()) != null) {
				words[i] = line;
				i++;
		}
		br.close();
		return words;     
	}
	
	public static boolean searchWord(String[] words,String value)
	{
		  if(linearSearch(words,value))
	        {
			checkMax(value);
	        return true;
	        }
	        else
	        {
	        return false;
	        }
	}
    private static boolean linearSearch(String[] words, String value) {
//    	System.out.println("hi");
    	for(int i=0 ; i<words.length;i++) {
    		if(words[i]!=null && scrabbleEquals(value,words[i])) {
    			return true;
    		}
    	}
		return false;
	}

	private static boolean scrabbleEquals(String str1, String str2) {
		
		if(str1.length()!=str2.length())
			return false;
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i) != str2.charAt(i) && str1.charAt(i)!= ' ')
				return false;
		}
		return true;
	}

	public static int binarySearch(String[] words, String value) {
        return binarySearch(words, value, 0, words.length - 1);
    }
    
    
    public static int binarySearch(String[] words, String value, int min, int max) {
        if (min > max) {
            return -1;
        }
        
        int mid = (max + min) / 2;
        
        if (words[mid]!=null&&words[mid].equals(value)) {
            return mid;
        } else if(words[mid]!=null&&words[mid].compareTo(value) > 0) {
            return binarySearch(words, value, min, mid - 1);
        } else {
            return binarySearch(words, value, mid + 1, max);
        }
    }
    
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String str = String.valueOf(letters);
		permutation(str);
		String[] sowpodsWords = readFile(267752);
		for(int i = 0; i< poss.size();i++) {
//			System.out.println("hi1");
			searchWord(sowpodsWords,poss.get(i));
		}
		
		//poss represents possible combination of strings
		//Now loop through each entry of poss 
		//check for each entry to be in sowpods or not
		System.out.println(maxScore);
		System.out.println("LARGEST:"+largestWord);
		
	}

}