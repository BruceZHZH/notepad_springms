package service;

import ParseHelper.ParseXML;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by zhao on 6/12/2017.
 */

@SpringBootApplication
@RestController
public class ServiceApplication {
    @GetMapping("/service/add")
    public String add(String name, String time, String thing){
        /*File writeToFile = new File("todo.xml");
        if(!writeToFile.exists()){
            try {
                writeToFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        if(name == null || name.trim().equals("")){
            return "用户名不可以为空";
        }
        ArrayList<String[]> lists = new ArrayList<String[]>();

        ParseXML.preLoad(lists, name);



        String[] todo = new String[3];
        todo[0] = name;
        todo[1] = time;
        todo[2] = thing;
        lists.add(todo);

        /*for(int i = 0; i < lists.size(); i++){
            todo = lists.get(i);
            System.out.println(todo[0]);
            System.out.println(todo[1]);
            System.out.println(todo[2]);
        }*/
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Element root = document.addElement("lists");
        for(int i = 0; i < lists.size(); i++){
            todo = lists.get(i);
            System.out.println(todo[0]);
            System.out.println(todo[1]);
            System.out.println(todo[2]);
            Element element = root.addElement("todo");
            element.addElement("name").addText(todo[0]);
            element.addElement("time").addText(todo[1]);
            element.addElement("thing").addText(todo[2]);
        }


        try {
            FileOutputStream fos = new FileOutputStream("todos.xml");
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

        /*FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(writeToFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("content" + '\n');
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/


        return "新TODO添加成功!</br>" + time + "</br> " + thing;

    }


    @GetMapping("/service/show")
    public String show(String name) {
        if(name == null || name.equals(""))
            return "用户名不能为空！";
        ArrayList<String[]> lists = new ArrayList<>();
        ParseXML.getTodoByName(lists, name);

        JSONObject jsonObject = new JSONObject();
        String[] todo;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < lists.size(); i++) {
            todo = lists.get(i);
            jsonObject.put("id", todo[0]);
            jsonObject.put("time", todo[1]);
            jsonObject.put("thing", todo[2]);
            sb.append(jsonObject.toString());
        }
        return sb.toString();
        //return "show!";
    }


    @GetMapping("/service/clear")
    public String clear(String name) {
        if(name == null || name.equals(""))
            return "用户名不能为空！";
        ArrayList<String[]> lists = new ArrayList<>();
        ParseXML.clearByName(lists, name);
        String[] todo;

        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Element root = document.addElement("lists");

        for(int i = 0; i < lists.size(); i++){
            todo = lists.get(i);
            System.out.println(todo[0]);
            System.out.println(todo[1]);
            System.out.println(todo[2]);
            Element element = root.addElement("todo");
            element.addElement("name").addText(todo[0]);
            element.addElement("time").addText(todo[1]);
            element.addElement("thing").addText(todo[2]);
        }

        try {
            FileOutputStream fos = new FileOutputStream("todos.xml");
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
        return "clear!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
