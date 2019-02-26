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
   public static void createFile(String tableNumber) {//创建文件（已完成）fileName为文件名
		try{//异常处理
			//如果文件夹下没有fileName.txt就会创建该文件
			BufferedWriter bw=new BufferedWriter(new FileWriter("src/file/TableFiles/"+tableNumber+".txt"));
			bw.close();//一定要关闭文件
		}catch(IOException e){
			e.printStackTrace();
		}
}
   public static void clearFile(String tableNumber) {//清空文件（已完成）fileName名字
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
    * 删除单个文件
    *
    * @param fileName
    *            要删除的文件的文件名
    * @return 单个文件删除成功返回true，否则返回false
    */
   public static boolean deleteFile(String tableNumber) {
       File file = new File("src/file/TableFiles/"+tableNumber+".txt");
       // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
       if (file.exists() && file.isFile()) {
           if (file.delete()) {
               System.out.println("删除单个文件" + tableNumber+ "成功！");
               return true;
           } else {
               System.out.println("删除单个文件" + tableNumber + "失败！");
               return false;
           }
       } else {
           System.out.println("删除单个文件失败：" + tableNumber + "不存在！");
           return false;
       }
   }
   /**  
	 * 递归查找文件  
	 * @param baseDirName  查找的文件夹路径  
	 * @param targettableNumber  需要查找的文件名  
	 * @param fileList  查找到的文件集合  
	 */  
	public static String findFiles(String targettableNumber) {   //返回目标文件的路径

		File baseDir = new File("src/file/TableFiles");		// 创建一个File对象
		//System.out.println("路径："+baseDir.getAbsolutePath());
		if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
			System.out.println("文件查找失败：TableFiles不是一个目录！");
			return null;
		}
		String tempName = null;   

		File tempFile;
		File[] files = baseDir.listFiles();//文件夹下的文件数组
		if(files.length==0){//该文件夹下没有文件，为空文件夹
			System.out.println("为空文件夹");
			return null;
		}
		for (int i = 0; i < files.length; i++) {
			tempFile = files[i];
			tempName = tempFile.getName();
			if(tempName.equals(targettableNumber+".txt")){
				System.out.println("找到"+targettableNumber);
				return tempFile.getAbsolutePath();
			}
		}
		System.out.println("没找到"+targettableNumber);
		return null;
	}    
	   /**  
		 * 递归查找文件  
		 * @param baseDirName  查找的文件夹路径  
		 * @param targettableNumber  需要查找的文件名  
		 * @param fileList  查找到的文件集合  
		 */  
		public static boolean findFiles1(String targettableNumber) {   //返回是否找到

			File baseDir = new File("src/file/TableFiles");		// 创建一个File对象
			//System.out.println("路径："+baseDir.getAbsolutePath());
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
				System.out.println("文件查找失败：TableFiles不是一个目录！");
				return false;
			}
			String tempName = null;   

			File tempFile;
			File[] files = baseDir.listFiles();//文件夹下的文件数组
			if(files.length==0){//该文件夹下没有文件，为空文件夹
				System.out.println("为空文件夹");
				return false;
			}
			for (int i = 0; i < files.length; i++) {
				tempFile = files[i];
				tempName = tempFile.getName();
				if(tempName.equals(targettableNumber+".txt")){
					System.out.println("找到"+targettableNumber);
					return true;
				}
			}
			System.out.println("没找到"+targettableNumber);
			return false;
		}    	
		public static void read(String tableNumber,Table1 table) {//读取对象数据，保存到本地文件中
		        //声明一个文件（创建文件）tableNumber为桌号//桌子文件的名字
		        File file = null;
		        //声明文件输出字节流
		        FileOutputStream fos = null;
		        //声明对象处理流
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
		                //关闭资源
		                fos.close();
		                oos.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }

			
			public static Table1 write(String tableNumber) {//从文件中把对象数据读取出来打印
			        File file = null;
			        Table1 table=new Table1(1,"有");
			       // System.out.println("未读取文件之前的table1:"+table);
			        FileInputStream fis = null;
			        ObjectInputStream ois = null;
			        try {
			            file = new File("src/file/TableFiles/"+tableNumber+".txt"); 
			            fis = new FileInputStream(file);
			            ois = new ObjectInputStream(fis);         
			            //反序列化一个对象。
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
		
			public static Table1[] changes(){//遍历所有桌子文件，把单个桌子文件的对象table搞成一个数组Tables
			File baseDir = new File("src/file/TableFiles");		// 创建一个File对象
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
				System.out.println("文件查找失败：TableFiles不是一个目录！");
				return null;
			}
			File[] files = baseDir.listFiles();//文件夹下的文件数组
			if(files.length==0){//该文件夹下没有文件，为空文件夹
				System.out.println("为空文件夹");
				return null;
			}
			//System.out.println("files.length:"+files.length);
			Table1[] tables=new Table1[files.length];//有多少个桌子文件就有多少个tables数组元素
			for (int i = 0; i < files.length; i++){
				String not=".txt";
				tables[i]=write(files[i].getName().replace(not,""));
			}
			return tables;
		}
			
}
