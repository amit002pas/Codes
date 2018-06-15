import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JSOUP {

	
    public static void main(String[] args) throws IOException {

final Document doc =  Jsoup.connect("http://cbseaff.nic.in/cbse_aff/schdir_Report/AppViewdir.aspx?affno=880015").get();

PrintWriter out= new PrintWriter("Output.txt");
PrintWriter outcsv= new PrintWriter("Output.csv");
System.out.println("text from site: "+doc.title());

for (Element data : doc.select("body :nth-child(2) table tbody tr :nth-child(2)")) 
{

 System.out.println("\""+data.text()+"\""+",");
 out.write("\""+data.text()+"\""+","+"\n"+"\n");
 outcsv.write(data.text()+",");

}out.close();
outcsv.close();


    }

}
