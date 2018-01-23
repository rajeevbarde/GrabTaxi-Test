package Solution;

import java.util.ArrayList;
import java.util.HashSet;

public class CmnWords {
	 /** 
     * This function will get list of comman word using brute force
     *
     * @param list1     The first list to be compared
     * @param list2     The second list to be compared               
     * @return          List containing comman words 
     */
	public static ArrayList<String> brute_getCommonWords(ArrayList< String> list1, ArrayList<String> list2){
		
		if(list1 == null || list2 == null) 
			return  null;
		
		ArrayList<String> result = new ArrayList<String>();					
		
		for(String item1 : list1)
			for(String item2 : list2)
				if(item1.equals(item2) && !result.contains(item2))
					result.add(item2);
				
		return result;

	}
	
	 /** 
     * This function will get list of comman word using HashSet
     *
     * @param list1     The first list to be compared
     * @param list2     The second list to be compared           
     * @return          List containing comman words 
     */		
	public static ArrayList<String> smart_getCommonWords(ArrayList< String> list1, ArrayList<String> list2){
		
		if(list1 == null || list2 == null) 
			return null;
		
		HashSet<String> list_1 = new HashSet<String>(list1);
		HashSet<String> list_2 = new HashSet<String>(list2);
		
		list_1.retainAll(list_2);				    
		ArrayList<String> result1 = new ArrayList<String>(list_1); //convert Hashset to ArrayList since the return type.
		 
		return result1;
	}
}
