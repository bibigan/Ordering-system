package aa;

public class Main2 {

	public static void New(String num1) {
		/*Table1[] tables;
		Table1[] tables1;
		tables=Tables1.creatTables(4);
		TableFile.read(tables);//��foods����д���ļ���	
		tables1=TableFile.write();
        Tables1.outPutTables(tables1);//���ļ����ݷ��ظ�foods1������*/
		//Table1[] tables;
		int num=0;
		try{
			num=Integer.parseInt(num1);
		} catch(NumberFormatException e){
			
		}
		Table1 table=new Table1(num,"��");
		num1=table.getNumber()+"";
		Table1 table1;
		//System.out.println("table:"+table);
		//TableFile.findFiles(num);
		TableFile.createFile(num1);//�½��ļ�
		//Main2.New("5");
		//TableFile.findFiles(num);
		TableFile.read(num1, table);//��tableд��00�����ļ�
		//table1=TableFile.write(num);//��00���ļ����ݸ�table1
		//System.out.println("��ȡ�ļ�֮���table1:"+table1);
		//tables=TableFile.changes();//�õ����������ļ�����������
		//Tables1.outPutTables(tables);
		//TableFile.clearFile(num);
		//TableFile.deleteFile(0+"");
	}

}
