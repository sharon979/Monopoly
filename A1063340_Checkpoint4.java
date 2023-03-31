import java.io.*;
import java.util.*;

public class A1063340_Checkpoint4 {
	public static ArrayList<String> listname=new ArrayList<String>();  
	public static ArrayList<String> item=new ArrayList<String>(); 
	public static int player;
	public static int statusaddress=3;
	public static int locationaddress=0;
	public static Character[] Character;
	public static A1063340_GUI GameWindow;
	public static int Dicenumber=0;
	public static int Round=1;
	public static int flag=0;
	public static int nowCharacter=0;
	public static int diceCharacter=1;
	public static int walkCharacter=1;
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
				   for(String newline:line.split(",|:")) {
					   listname.add(newline); 
				   }              	 
			    flag++;
			    continue;
			   }
			   for(String newline:line.split(",")) {
			   item.add(newline);                      
			   }
			  }
			  br.close();	
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		int j=0;
		Round=Integer.parseInt(listname.get(1));
		diceCharacter=Integer.parseInt(listname.get(3));
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
		 fw.write(listname.get(0));
		 fw.write(":");
		 fw.write(listname.get(1));
		 fw.write(",");
		 fw.write(listname.get(2));
		 fw.write(":");
		 fw.write(listname.get(3));  
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
		System.out.println(diceCharacter);
		walkCharacter=diceCharacter;
		Dicenumber=(int)(Math.random()*6)+1;
		locationaddress1=(diceCharacter-1)*5+0;
		statusaddress1=(diceCharacter-1)*5+3;
		step=(Dicenumber+Integer.parseInt(item.get(locationaddress1)))%20;
		status=Integer.parseInt(item.get(statusaddress1))-1;
		item.set(locationaddress1,""+step); 
		item.set(statusaddress1,""+status); 
		
		statusaddress1=3;
		locationaddress1=0;
		if(diceCharacter==player) {
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
			System.out.println("diceCharacter"+diceCharacter);
			while(Character[diceCharacter-1].status<=0 && diceCharacter<player) {
					diceCharacter++;
			}
			if(diceCharacter==player && Character[diceCharacter-1].status<=0) {
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
			
		}
		listname.set(1,""+Round);
	    listname.set(3,""+diceCharacter);
	}	
}
