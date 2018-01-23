package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TestHelper {	
		
		//100 data
		public static String best_100_list1 = "input_data\\100data\\100_best_list1.txt";
		public static String best_100_list2 = "input_data\\100data\\100_best_list2.txt";
		public static String best_100_result = "input_data\\100data\\100_best_result.txt";
		public static String avg_100_list1 = "input_data\\100data\\100_avg_list1.txt";
		public static String avg_100_list2 = "input_data\\100data\\100_avg_list2.txt";
		public static String avg_100_result = "input_data\\100data\\100_avg_result.txt";
		public static String worst_100_list1 = "input_data\\100data\\100_worst_list1.txt";
		public static String worst_100_list2 = "input_data\\100data\\100_worst_list2.txt";
		public static String worst_100_result = "input_data\\100data\\100_worst_result.txt";
		
		//10k data
		public static String best_10k_list1 = "input_data\\10kdata\\10k_best_list1.txt";
		public static String best_10k_list2 = "input_data\\10kdata\\10k_best_list2.txt";
		public static String best_10k_result = "input_data\\10kdata\\10k_best_result.txt";
		public static String avg_10k_list1 = "input_data\\10kdata\\10k_avg_list1.txt";
		public static String avg_10k_list2 = "input_data\\10kdata\\10k_avg_list2.txt";
		public static String avg_10k_result = "input_data\\10kdata\\10k_avg_result.txt";
		public static String worst_10k_list1 = "input_data\\10kdata\\10k_worst_list1.txt";
		public static String worst_10k_list2 = "input_data\\10kdata\\10k_worst_list2.txt";
		public static String worst_10k_result = "input_data\\10kdata\\10k_worst_result.txt";
		
		//60k data
		public static String best_60k_list1 = "input_data\\60kdata\\60k_best_list1.txt";
		public static String best_60k_list2 = "input_data\\60kdata\\60k_best_list2.txt";
		public static String best_60k_result = "input_data\\60kdata\\60k_best_result.txt";
		public static String avg_60k_list1 = "input_data\\60kdata\\60k_avg_list1.txt";
		public static String avg_60k_list2 = "input_data\\60kdata\\60k_avg_list2.txt";
		public static String avg_60k_result = "input_data\\60kdata\\60k_avg_result.txt";
		public static String worst_60k_list1 = "input_data\\60kdata\\60k_worst_list1.txt";
		public static String worst_60k_list2 = "input_data\\60kdata\\60k_worst_list2.txt";
		public static String worst_60k_result = "input_data\\60kdata\\60k_worst_result.txt";

	/** 
     * This function gets the list of string from a text file 
     * provided in the parameter
     * 
     * @param FileName 		The full file path of the text file
     * @return				ArrayList containing the string from the file          	
     */
	public static ArrayList<String> getInputData(String FileName)
	{
		ArrayList<String> arr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(FileName)))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
            	if(sCurrentLine.isEmpty()) continue;
                arr.add(sCurrentLine);                
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 		        
        return arr;
	}
	
	/** 
     * This function verifies if the two Arraylist are equal.
     * @param list1     The first list to be compared
     * @param list2     The second list to be compared 
     * @return			Boolean value if the lists are equal.          	
     */
	public static Boolean isListEqual(ArrayList< String> list1, ArrayList<String> list2)
	{
		Boolean result = false;
			
	    if((list1 == null && list2 != null) 
	      || list1 != null && list2 == null
	      || list1.size() != list2.size()){
	        return false;
	    }

	    list1 = new ArrayList<String>(list1); 
	    list2 = new ArrayList<String>(list2);   

	    Collections.sort(list1);
	    Collections.sort(list2);      
	    result = list1.equals(list2);
		
        return result;
	}
}
