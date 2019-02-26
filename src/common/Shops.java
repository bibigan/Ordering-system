package common;

import common.Shop;

public class Shops {
	public static Shop[] creatShops(int n) {//创建数组
		   Shop[] shops=new Shop[n];
		   int i;
		   for(i=0;i<shops.length;i++){
			   shops[i]=new Shop();
		   }
		   return shops;
	   }
	public static void outPutShops(Shop[] shops){
		for(int i=0;i<shops.length;i++){
        	System.out.println(shops[i]);
        }
	}
}
