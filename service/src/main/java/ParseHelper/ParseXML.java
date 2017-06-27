/*package ParseHelper;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

*//**
 * Created by zhao on 6/12/2017.
 *//*
public class ParseXML {
    public static void preLoad(ArrayList<String[]> lists, String name){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("todos.xml"));
            Element root = document.getRootElement();

            Iterator it = root.elementIterator();
            String[] todo;
            while(it.hasNext()){
                todo = new String[3];
                Element element = (Element) it.next();
                System.out.println(element.elementText("id"));
                System.out.println(element.elementText("time"));
                System.out.println(element.elementText("thing"));
                todo[0] = element.elementText("name");
                todo[1] = element.elementText("time");
                todo[2] = element.elementText("thing");
                lists.add(todo);
            }
            //listNodes(root, lists);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public static void getTodoByName(ArrayList<String[]> lists, String name){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("todos.xml"));
            Element root = document.getRootElement();

            Iterator it = root.elementIterator();
            String[] todo;
            while(it.hasNext()){
                todo = new String[3];
                Element element = (Element) it.next();
                String str = element.elementText("name");
                if(!str.equals(name))
                    continue;
                todo[0] = str;
                todo[1] = element.elementText("time");
                todo[2] = element.elementText("thing");
                lists.add(todo);
            }
            //listNodes(root, lists);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void clearByName(ArrayList<String[]> lists, String name){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("todos.xml"));
            Element root = document.getRootElement();

            Iterator it = root.elementIterator();
            String[] todo = new String[3];
            while(it.hasNext()){
                Element element = (Element) it.next();
                String str = element.elementText("name");
                if(str.equals(name))
                    continue;
                todo[0] = element.elementText("name");
                todo[1] = element.elementText("time");
                todo[2] = element.elementText("thing");
                lists.add(todo);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
*/