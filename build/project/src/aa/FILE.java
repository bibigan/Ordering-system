package aa;
//Food
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FILE {
	//��ȡ�������ݣ����浽�����ļ���
	public static void read(Food1[] foods) {
	        //����һ���ļ��������ļ���
	        File file = null;
	        //�����ļ�����ֽ���
	        FileOutputStream fos = null;
	        //������������
	        ObjectOutputStream oos = null;
	        try {
	            file = new File("D:\\HellloJavaFxx\\src\\file\\Foods.txt");
	            fos = new FileOutputStream(file);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(foods);//������
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

		//���ļ��аѶ������ݶ�ȡ������ӡ
		public static Food1[] write() {
		        File file = null;
		        Food1[] foods=null;
		        FileInputStream fis = null;
		        ObjectInputStream ois = null;
		        try {
		            file = new File("D:\\HellloJavaFxx\\src\\file\\Foods.txt");
		            fis = new FileInputStream(file);
		            ois = new ObjectInputStream(fis);         
		            //�����л�һ�����
                    foods= (Food1[])ois.readObject();//���ص�������		            
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
		        return foods; 
		    }
}
