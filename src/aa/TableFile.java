package aa;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TableFile {
   public static void createFile(String tableNumber) {//�����ļ�������ɣ�fileNameΪ�ļ���
		try{//�쳣����
			//����ļ�����û��fileName.txt�ͻᴴ�����ļ�
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/file/TableFiles/"+tableNumber+".txt"));
			bw.close();//һ��Ҫ�ر��ļ�
		}catch(IOException e){
			e.printStackTrace();
		}
}
   public static void clearFile(String tableNumber) {//����ļ�������ɣ�fileName����
		File file =new File("src/file/TableFiles/"+tableNumber+".txt");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
   /**
    * ɾ�������ļ�
    *
    * @param fileName
    *            Ҫɾ�����ļ����ļ���
    * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
    */
   public static boolean deleteFile(String tableNumber) {
       File file = new File("src/file/TableFiles/"+tableNumber+".txt");
       // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
       if (file.exists() && file.isFile()) {
           if (file.delete()) {
               System.out.println("ɾ�������ļ�" + tableNumber+ "�ɹ���");
               return true;
           } else {
               System.out.println("ɾ�������ļ�" + tableNumber + "ʧ�ܣ�");
               return false;
           }
       } else {
           System.out.println("ɾ�������ļ�ʧ�ܣ�" + tableNumber + "�����ڣ�");
           return false;
       }
   }
   /**  
	 * �ݹ�����ļ�  
	 * @param baseDirName  ���ҵ��ļ���·��  
	 * @param targettableNumber  ��Ҫ���ҵ��ļ���  
	 * @param fileList  ���ҵ����ļ�����  
	 */  
	public static String findFiles(String targettableNumber) {   //����Ŀ���ļ���·��

		File baseDir = new File("src/file/TableFiles");		// ����һ��File����
		//System.out.println("·����"+baseDir.getAbsolutePath());
		if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
			System.out.println("�ļ�����ʧ�ܣ�TableFiles����һ��Ŀ¼��");
			return null;
		}
		String tempName = null;   

		File tempFile;
		File[] files = baseDir.listFiles();//�ļ����µ��ļ�����
		if(files.length==0){//���ļ�����û���ļ���Ϊ���ļ���
			System.out.println("Ϊ���ļ���");
			return null;
		}
		for (int i = 0; i < files.length; i++) {
			tempFile = files[i];
			tempName = tempFile.getName();
			if(tempName.equals(targettableNumber+".txt")){
				System.out.println("�ҵ�"+targettableNumber);
				return tempFile.getAbsolutePath();
			}
		}
		System.out.println("û�ҵ�"+targettableNumber);
		return null;
	}    
	   /**  
		 * �ݹ�����ļ�  
		 * @param baseDirName  ���ҵ��ļ���·��  
		 * @param targettableNumber  ��Ҫ���ҵ��ļ���  
		 * @param fileList  ���ҵ����ļ�����  
		 */  
		public static boolean findFiles1(String targettableNumber) {   //�����Ƿ��ҵ�

			File baseDir = new File("src/file/TableFiles");		// ����һ��File����
			//System.out.println("·����"+baseDir.getAbsolutePath());
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
				System.out.println("�ļ�����ʧ�ܣ�TableFiles����һ��Ŀ¼��");
				return false;
			}
			String tempName = null;   

			File tempFile;
			File[] files = baseDir.listFiles();//�ļ����µ��ļ�����
			if(files.length==0){//���ļ�����û���ļ���Ϊ���ļ���
				System.out.println("Ϊ���ļ���");
				return false;
			}
			for (int i = 0; i < files.length; i++) {
				tempFile = files[i];
				tempName = tempFile.getName();
				if(tempName.equals(targettableNumber+".txt")){
					System.out.println("�ҵ�"+targettableNumber);
					return true;
				}
			}
			System.out.println("û�ҵ�"+targettableNumber);
			return false;
		}    	
		public static void read(String tableNumber,Table1 table) {//��ȡ�������ݣ����浽�����ļ���
		        //����һ���ļ��������ļ���tableNumberΪ����//�����ļ�������
		        File file = null;
		        //�����ļ�����ֽ���
		        FileOutputStream fos = null;
		        //������������
		        ObjectOutputStream oos = null;
		        try {
		            file = new File("src/file/TableFiles/"+tableNumber+".txt");
		            fos = new FileOutputStream(file);
		            oos = new ObjectOutputStream(fos);
		            oos.writeObject(table);
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

			
			public static Table1 write(String tableNumber) {//���ļ��аѶ������ݶ�ȡ������ӡ
			        File file = null;
			        Table1 table=new Table1(1,"��");
			       // System.out.println("δ��ȡ�ļ�֮ǰ��table1:"+table);
			        FileInputStream fis = null;
			        ObjectInputStream ois = null;
			        try {
			            file = new File("src/file/TableFiles/"+tableNumber+".txt"); 
			            fis = new FileInputStream(file);
			            ois = new ObjectInputStream(fis);         
			            //�����л�һ������
			            /*String not=".txt";
			            System.out.println("file.getName():"+file.getName().replace(not, ""));*/
			            table= (Table1)ois.readObject();		            
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
			        return table; 
			    }
		
			public static Table1[] changes(){//�������������ļ����ѵ��������ļ��Ķ���table���һ������Tables
			File baseDir = new File("src/file/TableFiles");		// ����һ��File����
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
				System.out.println("�ļ�����ʧ�ܣ�TableFiles����һ��Ŀ¼��");
				return null;
			}
			File[] files = baseDir.listFiles();//�ļ����µ��ļ�����
			if(files.length==0){//���ļ�����û���ļ���Ϊ���ļ���
				System.out.println("Ϊ���ļ���");
				return null;
			}
			//System.out.println("files.length:"+files.length);
			Table1[] tables=new Table1[files.length];//�ж��ٸ������ļ����ж��ٸ�tables����Ԫ��
			for (int i = 0; i < files.length; i++){
				String not=".txt";
				tables[i]=write(files[i].getName().replace(not,""));
			}
			return tables;
		}
			
}
