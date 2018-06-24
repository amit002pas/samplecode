
import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSSample; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer;  

public class PosTaggerExample { 
  
   public static void main(String args[]) throws Exception{ 
    
      //Loading Parts of speech-maxent model       
      InputStream inputStream = new FileInputStream("da-pos-maxent.bin"); 
      POSModel model = new POSModel(inputStream); 
       
      //Instantiating POSTaggerME class 
      POSTaggerME tagger = new POSTaggerME(model); 
       
      String sentence = "We will be going to maintenance on tonight from 09:30 to 10:30 pm"; 
       
      //Tokenizing the sentence using WhitespaceTokenizer class  
      WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
      String[] tokens = whitespaceTokenizer.tokenize(sentence); 
       
      //Generating tags 
      String[] tags = tagger.tag(tokens);
      int i=0;
      for(String str:tokens){
    	  
    		  System.out.println(str+" "+tags[i]);
    		  i++;
    		 
      }
      
      //Instantiating the POSSample class 
      POSSample sample = new POSSample(tokens, tags); 
      System.out.println(sample.toString()); 
   
   } 
}      