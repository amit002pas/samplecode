package mongoDB;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String output="";
		Document doc = Jsoup.connect("https://www.nscu.org/maintenance").get();
		Elements el = doc.select("body");
		for (Element e : el) {
			output+=e.text();
		    System.out.println(e.text());
		}
		OpenNlpMessageParser onlp=new OpenNlpMessageParser();
		onlp.getNLPProcessedDate(output);
	}

}
