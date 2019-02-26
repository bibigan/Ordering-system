package aa;

public class Main2 {

	public static void New(String num1) {
		/*Table1[] tables;
		Table1[] tables1;
		tables=Tables1.creatTables(4);
		TableFile.read(tables);//将foods数组写入文件中	
		tables1=TableFile.write();
        Tables1.outPutTables(tables1);//将文件内容返回给foods1数组里*/
		//Table1[] tables;
		int num=0;
		try{
			num=Integer.parseInt(num1);
		} catch(NumberFormatException e){
			
		}
		Table1 table=new Table1(num,"空");
		num1=table.getNumber()+"";
		Table1 table1;
		//System.out.println("table:"+table);
		//TableFile.findFiles(num);
		TableFile.createFile(num1);//新建文件
		//Main2.New("5");
		//TableFile.findFiles(num);
		TableFile.read(num1, table);//将table写入00桌号文件
		//table1=TableFile.write(num);//将00号文件内容给table1
		//System.out.println("读取文件之后的table1:"+table1);
		//tables=TableFile.changes();//得到所有桌子文件的桌子数组
		//Tables1.outPutTables(tables);
		//TableFile.clearFile(num);
		//TableFile.deleteFile(0+"");
	}

}
