import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
public class NameFinderSentences {  
   public static void main(String args[]) throws Exception{
	
      //Loading the tokenizer model 
      InputStream inputStreamTokenizer = new FileInputStream("en-token.bin");
      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
       
      //Instantiating the TokenizerME class 
      TokenizerME tokenizer = new TokenizerME(tokenModel); 
       
      String sentence="Internet Banking Due to planned maintenance some services won’t be available from 12.30am to 4am on Saturday 7th October. During this period you will be unable to:Make International PaymentsAll other services are unaffected.We’re sorry for any inconvenience and thank you for your patience.Mobile AppDue to planned maintenance some services won’t be available from 12.30am to 4am on Saturday 7th October";
      String tokens[] = tokenizer.tokenize(sentence); 
      
      //Loading the NER-person model 
      System.out.println("start");
      InputStream inputStreamNameFinder = new FileInputStream("test.bin");       
      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
      
      //Instantiating the NameFinderME class 
      NameFinderME nameFinder = new NameFinderME(model);       
      
      //Finding the names in the sentence 
      Span nameSpans[] = nameFinder.find(tokens);        
      
      //Printing the names and their spans in a sentence
      String output="";
      LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
      for(Span s: nameSpans)    {    
	         System.out.println(s.toString()+"  "+tokens[s.getStart()]);
	         String ss=s+"";
	         output=output+tokens[s.getStart()]+" ";
	         hm.put(s.toString(), tokens[s.getStart()]);
	         System.out.println("in loop");
	         }
	      System.out.println(output);
	   
	   System.out.println("END");
	   System.out.println(hm.size());
	   for(Map.Entry<String, String> m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
} }