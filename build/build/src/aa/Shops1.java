package aa;

public class Shops1 {
	public static Shop1[] creatShops(int n) {//创建数组
		Shop1[] shops=new Shop1[n];
		   int i;
		   for(i=0;i<shops.length;i++){
			   shops[i]=new Shop1();
		   }
		   return shops;
	   }
	public static void outPutShops(Shop1[] shops){
		for(int i=0;i<shops.length;i++){
     	System.out.println(shops[i]);
     }
	}
	public static String outPutString(Shop1[] shops){
			String s="";
			for(int i=0;i<shops.length;i++){
				s=s+shops[i];
			}
			return s;
		}
}
