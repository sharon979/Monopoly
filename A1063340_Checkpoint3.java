import java.io.*;
import java.util.*;


public class A1063340_Checkpoint3 {
	public static ArrayList<String> listname=new ArrayList<String>();  
	public static ArrayList<String> item=new ArrayList<String>();         
	public static  int player;
	public static int statusaddress=3;
	public static int locationaddress=0;
	public static Character[] Character;
	public static A1063340_GUI GameWindow;
	public static int Dicenumber=0;
	public static int Round=1;
	public static int flag=0;
	public static int nowCharacter=0;
	public static int diceCharacter=1;
	public static int step=0;
	public static int statusaddress1=3;
	public static int locationaddress1=0;
	public static int status;
	public static int count=0;
	
	public static void main(String[] args) throws IOException{
		 
		Load("Character.txt");  
	    GameWindow=new A1063340_GUI(); 
	    GameWindow.setVisible(true);
	}
	
	static void Load(String filename) throws IOException {
		//// TODO: You should load the variables from the file. ////
		try {
			  FileReader fr=new FileReader(filename);
			  BufferedReader br=new BufferedReader(fr);
			  String line="";
			  int flag=0;
			  while((line=br.readLine())!=null) {
			   if(flag==0) {
				   listname.add(line);                  
			    flag++;
			    continue;
			   }
			   for(String newline:line.split(",")) {
			   item.add(newline);                      
			   }
			  }
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		int j=0;
		player=item.size()/5;  
		Character=new Character[player];
		for(int i=0;i<player;i++) {
			Character[i] = new Character(i, i, i, i, null);  
		}
		
	    for(int i=0;i<player;i++) {   
	    		Character[i].location=Integer.parseInt(item.get(j++));
		        Character[i].CHARACTER_NUMBER=Integer.parseInt(item.get(j++));
		        Character[i].money=Integer.parseInt(item.get(j++));
		        Character[i].status=Integer.parseInt(item.get(j++));
		        Character[i].IMAGE_FILENAME=item.get(j++);
	    }
	}

	static void Save(String filename) throws IOException {
		//// TODO: You should save the changed variables into original data (filename). ////

		FileWriter fw = new FileWriter(filename); 
		for (int i = 0; i <listname.size(); i++) {
	        fw.write(listname.get(i));                 
	      }
		fw.write("\r\n");
		for (int i = 0; i <item.size(); i++) {         
			fw.write(item.get(i));
	        if(i%5==4) {
	        	fw.write("\r\n");
	        }
	        else {
	        	fw.write(",");
	        } 
	      }

		fw.flush();
		fw.close();	
	}
	
	static void Random() {
		//// TODO: while calling the Random function, Character.location should plus the random value, and Character.status should minus one.
		//// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
		Dicenumber=(int)(Math.random()*6)+1;
		locationaddress1=(diceCharacter-1)*5+0;
		statusaddress1=(diceCharacter-1)*5+3;
		step=Dicenumber+Integer.parseInt(item.get(locationaddress1));
		status=Integer.parseInt(item.get(statusaddress1))-1;
		item.set(locationaddress1,""+step); 
		item.set(statusaddress1,""+status); 
		
		statusaddress1=3;
		locationaddress1=0;
		if(diceCharacter==4) {
			Round++;
			diceCharacter=1;
				for(int i=0;i<player;i++) {
					int temp;
					temp=Integer.parseInt(item.get(statusaddress1))+1;
					item.set(statusaddress1,""+temp); 
					Character[i].status=Integer.parseInt(item.get(statusaddress1));
					statusaddress1+=5;		
				}
				while(Character[diceCharacter-1].status<=0) {
					diceCharacter++;
				}
		}
		else {
			diceCharacter++;
			while(Character[diceCharacter-1].status<=0) {
				diceCharacter++;
			}
		}
	}	
}
