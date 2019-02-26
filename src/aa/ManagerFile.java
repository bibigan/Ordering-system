package aa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import common.Manager;

public class ManagerFile {
	public static void read(Manager man) {//读取对象数据，保存到本地文件中
        //声明一个文件（创建文件）
        File file = null;
        //声明文件输出字节流
        FileOutputStream fos = null;
        //声明对象处理流
        ObjectOutputStream oos = null;
        try {
            file = new File("src/file/ManagerFile/Manager.txt");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(man);
            //oos.writeObject(null);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭资源
                fos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	
	public static Manager write() {//从文件中把对象数据读取出来打印
	        File file = null;
	        Manager man=new Manager();
	       // System.out.println("未读取文件之前的table1:"+table);
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            file = new File("src/file/ManagerFile/Manager.txt"); 
	            fis = new FileInputStream(file);
	            ois = new ObjectInputStream(fis);         
	            //反序列化一个对象。
	            /*String not=".txt";
	            System.out.println("file.getName():"+file.getName().replace(not, ""));*/
	            man= (Manager)ois.readObject();		            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();		            
	        } 
	          catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	          finally {
	            try {
	                fis.close();
	                ois.close();
	               
	            } catch (IOException e) {
	                e.printStackTrace();
	                
	            }
	        }
	        return man; 
	    }
}
