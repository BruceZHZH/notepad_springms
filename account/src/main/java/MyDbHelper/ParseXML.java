/*package MyDbHelper;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

*//**
 * Created by zhao on 6/12/2017.
 *//*
public class ParseXML {
    public static int preLoad(String name, String password){
        if(name == null || name.trim().equals("") || password == null || password.trim().equals(""))
            return  -1;
        ArrayList<String[]> lists = new ArrayList<>();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("accounts.xml"));
            Element root = document.getRootElement();
            Iterator it = root.elementIterator();
            String[] todo;
            while(it.hasNext()){
                todo = new String[2];
                Element element = (Element) it.next();
System.out.println(element.elementText("name"));
System.out.println(element.elementText("password"));
                if(name.equals(element.elementText("name"))){
                    return 0;
                }
                todo[0] = element.elementText("name");
                todo[1] = element.elementText("password");
                lists.add(todo);
            }
            //listNodes(root, lists);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        createNewAccount(lists, name, password);
        return 1;
    }

    public static void createNewAccount(ArrayList<String[]> lists, String name, String password){
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Element root = document.addElement("accounts");
        String[] todo = new String[2];
        for(int i = 0; i < lists.size(); i++){
            todo = lists.get(i);
            System.out.println(todo[0]);
            System.out.println(todo[1]);
            Element element = root.addElement("account");
            element.addElement("name").addText(todo[0]);
            element.addElement("password").addText(todo[1]);
        }
        Element element = root.addElement("account");
        element.addElement("name").addText(name);
        element.addElement("password").addText(password);

        try {
            FileOutputStream fos = new FileOutputStream("accounts.xml");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
            OutputFormat of = new OutputFormat();
            of.setEncoding("utf-8");
            of.setIndent(true);
            of.setIndent("    ");
            of.setNewlines(true);
            XMLWriter writer = new XMLWriter(osw, of);
            writer.write(document);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
*/