package sm.hris.struts2.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXML {
public String value="";
public String ReadXmlAttribute(String path,final String AtttributeName)
//private static final long serialVersionUID = 7353477345330099548L;
{
    value="";
    SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser;
    try {
        saxParser = factory.newSAXParser();


      DefaultHandler handler = new DefaultHandler() {

        boolean flag = false;


        public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

         // System.out.println("Start Element :" + qName);

          if (qName.equalsIgnoreCase(AtttributeName)) {
              flag = true;
          }

        }

        public void endElement(String uri, String localName,
                String qName)
                throws SAXException {

              //System.out.println("End Element :" + qName);

        }

        public void characters(char ch[], int start, int length)
            throws SAXException {

          //System.out.println(new String(ch, start, length));


          if (flag) {
              value =  new String(ch, start, length);
              System.out.println("Attribute Found : "
                +value);


            flag = false;
          }
        }
      };

    File file = new File(path);
    InputStream inputStream = new FileInputStream(file);

    Reader reader = new InputStreamReader(inputStream,"UTF-8");


    InputSource is = new InputSource(reader);
    is.setEncoding("UTF-8");

    saxParser.parse(is, handler);

    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return value;
}
}    

