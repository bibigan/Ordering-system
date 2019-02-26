package aa;

public class Tables1 {
	public static Table1[] creatTables(int n) {//创建数组
		   Table1[] tables=new Table1[n];
		   int i;
		   for(i=0;i<tables.length;i++){
			   tables[i]=new Table1();
		   }
		   return tables;
	   }
	public static void outPutTables(Table1[] tables){
		for(int i=0;i<tables.length;i++){
     	System.out.println(tables[i]);
     }
	}
}
