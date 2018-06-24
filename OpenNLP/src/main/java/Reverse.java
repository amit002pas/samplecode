import java.util.*;
import java.lang.*;
import java.io.*;

public class Reverse {
	public static void main (String[] args) {
		//code
		int tt;
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		tt=sc.nextInt();
		
		while(tt>0)
		{
			String output="";
		    Stack<String> st=new Stack<String>();
		    String str;

		    int i,k=0;
		    str=sc.next();
		    str=str+".";
		    for(i=0;i<str.length();i++)
		    {
		        if(str.charAt(i)=='.')
		        {
		          st.push(str.substring(k, i));
		          k=i+1;
		        }
		    }
		   while(!st.empty()){
			   output=output+st.pop()+".";
		   }
		   System.out.println(output.substring(0, output.length()-1));
		   tt--;
		}
	}

}
