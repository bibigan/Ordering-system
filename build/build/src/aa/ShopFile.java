package aa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ShopFile {
	   public static void createFile(String TableNumber) {//�����ļ�������ɣ�fileNameΪ�ļ���
			try{//�쳣����
				//����ļ�����û��fileName.txt�ͻᴴ�����ļ�
				BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt"));
				bw.close();//һ��Ҫ�ر��ļ�
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	   public static void clearFile(String TableNumber) {//����ļ�������ɣ�fileName����
			File file =new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt");
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
	   public static boolean deleteFile(String TableNumber) {
	       File file = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt");
	       // ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
	       if (file.exists() && file.isFile()) {
	           if (file.delete()) {
	               System.out.println("ɾ�������ļ�" + TableNumber+ "�ɹ���");
	               return true;
	           } else {
	               System.out.println("ɾ�������ļ�" + TableNumber + "ʧ�ܣ�");
	               return false;
	           }
	       } else {
	           System.out.println("ɾ�������ļ�ʧ�ܣ�" + TableNumber + "�����ڣ�");
	           return false;
	       }
	   }
	   /**  
		 * �ݹ�����ļ�  
		 * @param baseDirName  ���ҵ��ļ���·��  
		 * @param targetShopNumber  ��Ҫ���ҵ��ļ���  
		 * @param fileList  ���ҵ����ļ�����  
		 */  
		public static String findFiles(String targetTableNumber) {   //����Ŀ���ļ���·��

			File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// ����һ��File����
			//System.out.println("·����"+baseDir.getAbsolutePath());
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
				System.out.println("�ļ�����ʧ�ܣ�ShopFiles����һ��Ŀ¼��");
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
				if(tempName.equals(targetTableNumber+".txt")){
					System.out.println("�ҵ�"+targetTableNumber);
					return tempFile.getAbsolutePath();
				}
			}
			System.out.println("û�ҵ�"+targetTableNumber);
			return null;
		}    
		   /**  
			 * �ݹ�����ļ�  
			 * @param baseDirName  ���ҵ��ļ���·��  
			 * @param targetShopNumber  ��Ҫ���ҵ��ļ���  
			 * @param fileList  ���ҵ����ļ�����  
			 */  
			public static boolean findFiles1(String targetTableNumber) {   //�����Ƿ��ҵ�

				File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// ����һ��File����
				//System.out.println("·����"+baseDir.getAbsolutePath());
				if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
					System.out.println("�ļ�����ʧ�ܣ�ShopFiles����һ��Ŀ¼��");
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
					if(tempName.equals(targetTableNumber+".txt")){
						System.out.println("�ҵ�"+targetTableNumber);
						return true;
					}
				}
				System.out.println("û�ҵ�"+targetTableNumber);
				return false;
			}    	
			public static void read(String TableNumber,Shop1[] Shops) {//��ȡ�������ݣ����浽�����ļ���
			        //����һ���ļ��������ļ���ShopNumberΪ����//�����ļ�������
			        File file = null;
			        //�����ļ�����ֽ���
			        FileOutputStream fos = null;
			        //������������
			        ObjectOutputStream oos = null;
			        try {
			            file = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt");
			            fos = new FileOutputStream(file);
			            oos = new ObjectOutputStream(fos);
			            oos.writeObject(Shops);
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

				
				public static Shop1[] write(String TableNumber) {//���ļ��аѶ������ݶ�ȡ������ӡ
				        File file = null;
				        Shop1[] Shops=null;
				       // System.out.println("δ��ȡ�ļ�֮ǰ��Shop1:"+Shop);
				        FileInputStream fis = null;
				        ObjectInputStream ois = null;
				        try {
				            file = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt"); 
				            fis = new FileInputStream(file);
				            ois = new ObjectInputStream(fis);         
				            //�����л�һ������
				            /*String not=".txt";
				            System.out.println("file.getName():"+file.getName().replace(not, ""));*/
				            Shops= (Shop1[])ois.readObject();		            
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
				        return Shops; 
				    }
			
				public static Shop1[][] changes(){//�������й��ﳵ�ļ����ѵ������ﳵ�ļ��Ķ���Shop���һ����ά����Shops
					File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// ����һ��File����
					if (!baseDir.exists() || !baseDir.isDirectory()) {	// �ж�Ŀ¼�Ƿ����
						System.out.println("�ļ�����ʧ�ܣ�ShopFiles����һ��Ŀ¼��");
						return null;
					}
					File[] files = baseDir.listFiles();//�ļ����µ��ļ�����
					if(files.length==0){//���ļ�����û���ļ���Ϊ���ļ���
						System.out.println("Ϊ���ļ���");
						return null;
					}
					//System.out.println("files.length:"+files.length);
					Shop1[][] Shops=new Shop1[files.length][];//�ж��ٸ������ļ����ж��ٸ�����,����Ϊ�ļ�����ÿ���ļ��Ĳ�Ʒ����Ϊ��ȡ�����鳤��
					for (int i = 0; i < files.length; i++){
						String not=".txt";
						Shops[i]=write(files[i].getName().replace(not,""));//���ص��ǵ�ǰ�����µĲ�Ʒ��Ϣ����
					}
					return Shops;
				}

//һ�����ﳵ�ļ����е�ǰ���ӵĹ��ﳵ�ڲ�Ʒ��Ϣ���飬һ�������ļ����е�ǰ���ӵ���Ϣ��һ���˵��ļ����в��������в�Ʒ����Ϣ����Ʒ���飩
//��ά���飬��Ϊ���ţ���Ԫ��Ϊ��ǰ�����µ�һ����Ʒ��Ϣ
}
