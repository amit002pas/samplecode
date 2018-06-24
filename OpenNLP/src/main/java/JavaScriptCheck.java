import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JavaScriptCheck {
	public static void main(String args[]) throws ScriptException, IOException, NoSuchMethodException, ParseException{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("dateHandler.js"));
		Invocable invocable = (Invocable) engine;
		
		Object result = invocable.invokeFunction("parseDate", "2a.m 17 sep");	
		System.out.println("Result: "+result.toString());
		String date=result+"";
		String date1=date.substring(6, date.length()-6);
		date1=date1.replace("T", " ");
		date1=date1+" GMT";
		
		SimpleDateFormat sdfPST=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
		sdfPST.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		SimpleDateFormat sdfPST3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
		//sdfPST3.setTimeZone(TimeZone.getTimeZone("IST"));
		System.out.println("Date1: "+date1);
		Date d=sdfPST.parse(date1);
		System.out.println("datefff:"+d);

		String f=sdfPST3.format(d);
		System.out.println("fffff:"+f);
		
		Date d21=sdfPST3.parse(f);
		System.out.println("ddddd:"+d21);
		

	}

}
