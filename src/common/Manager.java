package common;

import java.io.Serializable;

public class Manager implements Serializable {
	    private String SecretNumber;
	    public Manager(){
          this("123456");
	    }
	    public Manager(String NumberSecret){
	        SecretNumber=NumberSecret;
	    }
	    public void setSecretNumber(String secretNumber) {
	        SecretNumber = secretNumber;
	    }
	    public String getSecretNumber() {
	        return SecretNumber;
	    }
	   /* public void AddFood(){
	    	String Name;
	    	int Number;
	    	String Type;
	    	int Price;
	    	String Introduce;
	    	Scanner input=new Scanner(System.in);
	    	Name=input.next();
	    	Number=input.nextInt();
	    	Type=input.next();
	    	Price=input.nextInt();
	    	Introduce=input.next();
	    	Menu.AddFood(Name,Number,Type,Price,Introduce);
	    }*/
	    @Override
	    public String toString() {
	        return "Manager{" +"SecretNumber=" + SecretNumber +'}';
	    }

}
