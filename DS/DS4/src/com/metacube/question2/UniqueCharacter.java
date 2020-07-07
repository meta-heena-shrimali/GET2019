package com.metacube.question2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UniqueCharacter
{

	//HashMap for storing results
	HashMap<String, Integer> cache= new HashMap<>();


	/*
	 * @param input, input string for applying operation on it
	 * @return result
	 * @throws Exception 
	 */
	public int numberOfUniqueCharacter(String input) throws Exception
	{
		if( input == null)
			throw new Exception("Null value passed as input");
		if(input.length() == 0)
			throw new Exception("Empty string passed as input");
		int result=0;
		HashMap<Character, Integer> uniquecharacter= new HashMap<>();
		
		if(cache.containsKey(input)){
			result = cache.get(input);
			return result;
		}

		for(int i=0;i<input.length();i++){
			char tempChar= input.charAt(i);
			
		    if(uniquecharacter.containsKey(tempChar)){
				int val= uniquecharacter.get(tempChar);
				uniquecharacter.put(tempChar,val+1);
			}
			else
				uniquecharacter.put(tempChar, 1);
		}	
		Set<Character> keyset= uniquecharacter.keySet();
		Iterator<Character> iterator = keyset.iterator(); 
		while(iterator.hasNext()) {
			if(uniquecharacter.get(iterator.next()) == 1 )
				result ++;
		}
		cache.put(input, result);
		return result;
	}


}




