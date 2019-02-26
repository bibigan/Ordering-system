package common;

import common.Food;

public class Foods {
	public static Food[] creatFoods(int n) {//创建数组
		   Food[] foods=new Food[n];
		   int i;
		   for(i=0;i<foods.length;i++){
			   foods[i]=new Food();
		   }
		   return foods;
	   }
	public static void outPutFoods(Food[] foods){
		for(int i=0;i<foods.length;i++){
        	System.out.println(foods[i]);
        }
	}
}
