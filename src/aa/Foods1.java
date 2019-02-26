package aa;

public class Foods1 {
	public static Food1[] creatFoods(int n) {//创建数组
		   Food1[] foods=new Food1[n];
		   int i;
		   for(i=0;i<foods.length;i++){
			   foods[i]=new Food1();
		   }
		   return foods;
	   }
	public static void outPutFoods(Food1[] foods){
		for(int i=0;i<foods.length;i++){
        	System.out.println(foods[i]);
        }
	}
}
