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
	public static void read(Manager man) {//��ȡ�������ݣ����浽�����ļ���
        //����һ���ļ��������ļ���
        File file = null;
        //�����ļ�����ֽ���
        FileOutputStream fos = null;
        //������������
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
                //�ر���Դ
                fos.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	
	public static Manager write() {//���ļ��аѶ������ݶ�ȡ������ӡ
	        File file = null;
	        Manager man=new Manager();
	       // System.out.println("δ��ȡ�ļ�֮ǰ��table1:"+table);
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        try {
	            file = new File("src/file/ManagerFile/Manager.txt"); 
	            fis = new FileInputStream(file);
	            ois = new ObjectInputStream(fis);         
	            //�����л�һ������
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
