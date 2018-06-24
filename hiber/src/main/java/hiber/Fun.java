package hiber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

public class Fun {
	

	String url;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Fun f=new Fun();
		System.out.println(f.url);
		
		Configuration con=new Configuration();
		
		Properties prop= new Properties();
		prop.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@192.168.84.20:1521/repalda");
		prop.setProperty("hibernate.connection.driver_class" ,"oracle.jdbc.driver.OracleDriver");
		prop.setProperty("hibernate.connection.username", "read");
		prop.setProperty("hibernate.connection.password", "read");
		con.configure("hibernate.cfg.xml");
		con.addProperties(prop);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Query query = sess.createQuery("from Site where isReady=1");
		
		List<Site> rows = query.list();
		System.out.println("Total size: "+rows.size());
		File fi= new File("a.csv");
		 FileWriter fw=new FileWriter(fi);   
		 int counter=0;
		for (Site row: rows) {
		    
		    System.out.println(counter+++" " +row.getName());
		    
		    
			 Document doc = null;
			try {
				doc = Jsoup.connect(row.getName()).get();
			 
				 String title = doc.body().text();
		            Elements link1=doc.select("a");
		            
		            
		            for(Element e:link1)
		            {
		           	 	String str=e.attr("href");
		           	 		if(str.contains("twitter"))
		           	 		{
		           	 			fw.write(row.getSiteId()+" "+row.getName());
		           	 			fw.write("\n");
		           	 			System.out.println(row.getSiteId()+" "+str);
		           	 			break;
		           	 		}
		            }
			
				
				  
           
			}
		
		 catch (Exception e) {
			 continue;
				// TODO Auto-generated catch block
			}
            
          
	}
		
fw.close();
}
}
