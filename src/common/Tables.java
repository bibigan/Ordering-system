package common;

public interface Tables {
	public static Table[] creatTables(int n) {//创建数组
		   Table[] tables=new Table[n];
		   int i;
		   for(i=0;i<tables.length;i++){
			   tables[i]=new Table();
		   }
		   return tables;
	   }
	public static void outPutTables(Table[] tables){
		for(int i=0;i<tables.length;i++){
     	System.out.println(tables[i]);
     }
	}
}
