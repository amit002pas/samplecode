import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class JPython {
	String arg1;
	public String getArg1() {
		return arg1;
	}
	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JPython obj=new JPython();
		obj.setArg1("hello");
		System.out.println(obj.getArg1());
		 String []cmd ={"python", "a.py", "Amit"};
			    Process p=Runtime.getRuntime().exec(cmd);
			    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			    String s = br.readLine(); 
			    System.out.println(s);

	}

}
