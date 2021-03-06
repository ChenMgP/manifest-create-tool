package com.kcn;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Scanner;
import java.util.UUID;

public class addon {

    //Notice: Please put the gson-2.8.8 into your External library, or this code will fail
    /*
    How to use this tool?
    One way is to run it in your code editor
    The another way is to compress it into a jar package and write a xxx.Bat(such as start.bat) file to run it
    
    How to write the start.bat?
    Easy!!!
    Here this the code:
    java -jar <your jar file's name>(such as "java -jar tool.jar)
    pause
    
    If you don't want to write this bat file, you can download it at the com/kcn path
    */

    public static void main(String[] args) throws IOException {
        String uid1 = UUID.randomUUID().toString();
        String uid2 = UUID.randomUUID().toString();
        String uid3 = UUID.randomUUID().toString();
        String uid4 = UUID.randomUUID().toString();
        /**
         * behavior_packs
         * */
        //-------------------------------------------------------------------
        JsonObject object = new JsonObject();
        object.addProperty("format_version", 2);
        //-------------------------------------------------------------------
        JsonObject header = new JsonObject();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a description for this addon: ");
        String description = sc.next();
        header.addProperty("description", description);
        System.out.print("Please enter the name of this addon: ");
        String name = sc.next();
        header.addProperty("name", name);
        header.addProperty("uuid", uid1);
        JsonArray version1 = new JsonArray();
        version1.add(1);
        version1.add(0);
        version1.add(0);
        header.add("version", version1);
        JsonArray min_engine_version1 = new JsonArray();
        min_engine_version1.add(1);
        min_engine_version1.add(16);
        min_engine_version1.add(0);
        header.add("min_engine_version", min_engine_version1);
        object.add("header", header);
        //-------------------------------------------------------------------
        JsonArray modules = new JsonArray();
        JsonObject o1 = new JsonObject();
        o1.addProperty("description", description);
        o1.addProperty("type", "data");
        o1.addProperty("uuid", uid2);
        o1.add("version", version1);
        modules.add(o1);
        object.add("modules", modules);
        //-------------------------------------------------------------------
        /**
         * resource_packs
         * */
        JsonObject object1 = new JsonObject();
        object.addProperty("format_version", 2);
        //-------------------------------------------------------------------
        JsonObject header1 = new JsonObject();
        header1.addProperty("description", description);
        header1.addProperty("name", name);
        header1.addProperty("uuid", uid3);
        header1.add("version", version1);
        header1.add("min_engine_version", min_engine_version1);
        object1.add("header", header1);
        //-------------------------------------------------------------------
        JsonArray modules1 = new JsonArray();
        JsonObject o2 = new JsonObject();
        o2.addProperty("description", description);
        o2.addProperty("type", "resources");
        o2.addProperty("uuid", uid4);
        o2.add("version", version1);
        modules1.add(o2);
        object1.add("modules", modules1);
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        File f = new File(com + "\\"+name);
        f.mkdir();
        File f1 = new File(com + "\\"+name+"\\bp");
        f1.mkdir();
        File f2 = new File(com + "\\"+name+"\\rp");
        f2.mkdir();
        File j1 = new File(com + "\\"+name+"\\bp\\manifest.json");
        j1.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(com + "\\"+name+"\\bp\\manifest.json"));
        bw.write(object.toString());
        bw.close();
        File j2 = new File(com + "\\"+name+"\\rp\\manifest.json");
        j2.createNewFile();
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(com + "\\"+name+"\\rp\\manifest.json"));
        bw1.write(object1.toString());
        bw1.close();
        Img img = new Img();
        img.newWrite(new FileOutputStream(com + "\\"+name+"\\bp\\pack_icon.png"));
        Img img1 = new Img();
        img1.newWrite(new FileOutputStream(com + "\\"+name+"\\rp\\pack_icon.png"));
    }
}
