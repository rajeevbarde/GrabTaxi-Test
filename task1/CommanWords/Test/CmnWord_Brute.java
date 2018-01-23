package Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/** 
 * USING BRUTE FORCE TECHNIQUE
 * 
 * The test involves 3 types of input data to check performance
 * for finding the comman words - 100, 10k, 60k
 *   
 * Each input has data contains unique data classified as 
 * BEST - Both list contain all comman words.
 * AVERAGE - Both list contain some amount of comman words.
 * WORST -  Both list contain extreme less amount of comman words.
 */
public class CmnWord_Brute {
	
	//100 data
	@Test
	public void brute_100_best(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.best_100_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.best_100_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.best_100_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);			
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);		
		assertTrue(answer);		
	}
	
	@Test
	public void brute_100_avg(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.avg_100_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.avg_100_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.avg_100_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.smart_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
		
	@Test
	public void brute_100_worst(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.worst_100_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.worst_100_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.worst_100_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.smart_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
		
	//10k data
	@Test
	public void brute_10k_best(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.best_10k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.best_10k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.best_10k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
		
	@Test
	public void brute_10k_avg(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.avg_10k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.avg_10k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.avg_10k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
		
	@Test
	public void brute_10k_worst(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.worst_10k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.worst_10k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.worst_10k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
	
	//60k data
	@Test
	public void brute_60k_best(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.best_60k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.best_60k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.best_60k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
		
	@Test
	public void brute_60k_avg(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.avg_60k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.avg_60k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.avg_60k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
	
	@Test
	public void brute_60k_worst(){
		
		ArrayList<String> list1 = TestHelper.getInputData(TestHelper.worst_60k_list1);
		ArrayList<String> list2 = TestHelper.getInputData(TestHelper.worst_60k_list2);		
		ArrayList<String> result_file = TestHelper.getInputData(TestHelper.worst_60k_result);
		
		ArrayList<String> commanWords = Solution.CmnWords.brute_getCommonWords(list1,list2);		
		Boolean answer =  TestHelper.isListEqual (result_file,commanWords);			
		assertTrue(answer);						
	}
}
