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
	   public static void createFile(String TableNumber) {//创建文件（已完成）fileName为文件名
			try{//异常处理
				//如果文件夹下没有fileName.txt就会创建该文件
				BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt"));
				bw.close();//一定要关闭文件
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	   public static void clearFile(String TableNumber) {//清空文件（已完成）fileName名字
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
	    * 删除单个文件
	    *
	    * @param fileName
	    *            要删除的文件的文件名
	    * @return 单个文件删除成功返回true，否则返回false
	    */
	   public static boolean deleteFile(String TableNumber) {
	       File file = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt");
	       // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	       if (file.exists() && file.isFile()) {
	           if (file.delete()) {
	               System.out.println("删除单个文件" + TableNumber+ "成功！");
	               return true;
	           } else {
	               System.out.println("删除单个文件" + TableNumber + "失败！");
	               return false;
	           }
	       } else {
	           System.out.println("删除单个文件失败：" + TableNumber + "不存在！");
	           return false;
	       }
	   }
	   /**  
		 * 递归查找文件  
		 * @param baseDirName  查找的文件夹路径  
		 * @param targetShopNumber  需要查找的文件名  
		 * @param fileList  查找到的文件集合  
		 */  
		public static String findFiles(String targetTableNumber) {   //返回目标文件的路径

			File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// 创建一个File对象
			//System.out.println("路径："+baseDir.getAbsolutePath());
			if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
				System.out.println("文件查找失败：ShopFiles不是一个目录！");
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
				if(tempName.equals(targetTableNumber+".txt")){
					System.out.println("找到"+targetTableNumber);
					return tempFile.getAbsolutePath();
				}
			}
			System.out.println("没找到"+targetTableNumber);
			return null;
		}    
		   /**  
			 * 递归查找文件  
			 * @param baseDirName  查找的文件夹路径  
			 * @param targetShopNumber  需要查找的文件名  
			 * @param fileList  查找到的文件集合  
			 */  
			public static boolean findFiles1(String targetTableNumber) {   //返回是否找到

				File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// 创建一个File对象
				//System.out.println("路径："+baseDir.getAbsolutePath());
				if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
					System.out.println("文件查找失败：ShopFiles不是一个目录！");
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
					if(tempName.equals(targetTableNumber+".txt")){
						System.out.println("找到"+targetTableNumber);
						return true;
					}
				}
				System.out.println("没找到"+targetTableNumber);
				return false;
			}    	
			public static void read(String TableNumber,Shop1[] Shops) {//读取对象数据，保存到本地文件中
			        //声明一个文件（创建文件）ShopNumber为桌号//桌子文件的名字
			        File file = null;
			        //声明文件输出字节流
			        FileOutputStream fos = null;
			        //声明对象处理流
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
			                //关闭资源
			                fos.close();
			                oos.close();
			            } catch (IOException e) {
			                e.printStackTrace();
			            }
			        }
			    }

				
				public static Shop1[] write(String TableNumber) {//从文件中把对象数据读取出来打印
				        File file = null;
				        Shop1[] Shops=null;
				       // System.out.println("未读取文件之前的Shop1:"+Shop);
				        FileInputStream fis = null;
				        ObjectInputStream ois = null;
				        try {
				            file = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles\\"+TableNumber+".txt"); 
				            fis = new FileInputStream(file);
				            ois = new ObjectInputStream(fis);         
				            //反序列化一个对象。
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
			
				public static Shop1[][] changes(){//遍历所有购物车文件，把单个购物车文件的对象Shop搞成一个二维数组Shops
					File baseDir = new File("D:\\HellloJavaFxx\\src\\file\\ShopFiles");		// 创建一个File对象
					if (!baseDir.exists() || !baseDir.isDirectory()) {	// 判断目录是否存在
						System.out.println("文件查找失败：ShopFiles不是一个目录！");
						return null;
					}
					File[] files = baseDir.listFiles();//文件夹下的文件数组
					if(files.length==0){//该文件夹下没有文件，为空文件夹
						System.out.println("为空文件夹");
						return null;
					}
					//System.out.println("files.length:"+files.length);
					Shop1[][] Shops=new Shop1[files.length][];//有多少个桌子文件就有多少个桌子,桌号为文件名，每个文件的菜品数量为读取的数组长度
					for (int i = 0; i < files.length; i++){
						String not=".txt";
						Shops[i]=write(files[i].getName().replace(not,""));//返回的是当前桌号下的菜品信息数组
					}
					return Shops;
				}

//一个购物车文件存有当前桌子的购物车内菜品信息数组，一个桌子文件存有当前桌子的信息，一个菜单文件存有菜谱内所有菜品的信息（菜品数组）
//二维数组，行为桌号，列元素为当前桌号下的一个菜品信息
}
