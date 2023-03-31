import java.io.IOException;
import java.io.PrintWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class A1063340_Checkpoint2 {
	public static ArrayList<String> listname=new ArrayList<String>();  //The first line of text description of "1_Character.txt"
	public static ArrayList<String> item=new ArrayList<String>();      //Player value of "1_Character.txt"
	public static ArrayList<String> output=new ArrayList<String>();    //Loading the content to be output
	public static  int player;   //player number
	public static int statusaddress=3;     //status address
	public static int locationaddress=0;   //location address
	
	public static void main(String[] args) throws IOException{

		//// TODO: Announce the object of Character.////

		Load("1_Character.txt");  //load "1_Character.txt"
		int j=0;
		player=item.size()/5;  //player number
		
		Character[] Character = new Character[player];
		for(int i=0;i<player;i++) {
			Character[i] = new Character();  //Declare player Character()
		}
		
		

	    for(int i=0;i<player;i++) {   //Given each player's game data
	    		Character[i].location=Integer.parseInt(item.get(j++));
		        Character[i].CHARACTER_NUMBER=Integer.parseInt(item.get(j++));
		        Character[i].money=Integer.parseInt(item.get(j++));
		        Character[i].status=Integer.parseInt(item.get(j++));
		        Character[i].IMAGE_FILENAME=item.get(j++);
	    }

	    //// TODO: Call and execute the Random function.
	    Random();
	    
	    for(int i=0;i<player;i++) {    //Change player address and status
	    	Character[i].location=Integer.parseInt(item.get(locationaddress));
	    	Character[i].status=Integer.parseInt(item.get(statusaddress));
	    	statusaddress+=5;
		locationaddress+=5;
	    }
	    
	    //// TODO: And Save it.
	    Save("1_Character.txt");  //Store the calculated game value
		
	    int [] width=new int [player];
	    int [] height=new int [player];
	    for(int i=0;i<player;i++) {     //Read the width and height of the character image
	    	BufferedImage image1 = ImageIO.read(new File(Character[i].IMAGE_FILENAME));
	    	width[i]=image1.getWidth();
	    	height[i]=image1.getHeight();
	    }
	    
	    for(int i=0;i<player;i++) {     //Put the last data to be output into the output
	    	output.add("CHARACTER_"+Character[i].CHARACTER_NUMBER+"\r\n");
			output.add("location:");
			output.add(""+Character[i].location+"\r\n");
			output.add("CHARACTER_NUMBER:");
			output.add(""+Character[i].CHARACTER_NUMBER+"\r\n");
			output.add("money:");
			output.add(""+Character[i].money+"\r\n");
			output.add("status:");
			output.add(""+Character[i].status+"\r\n");
			output.add("IMAGE_FILENAME:");
			output.add(""+Character[i].IMAGE_FILENAME+"\r\n");
			output.add("IMAGE_WIDTH:");
			output.add(""+width[i]+"\r\n");
			output.add("IMAGE_HEIGHT:");
			output.add(""+height[i]+"\r\n");
	    }
	   
         	//// TODO: Output a "output.txt" file

	   FileWriter fw = new FileWriter("output.txt");    
		for (int i = 0; i <output.size(); i++) {
	        fw.write(output.get(i));
	    }
	    fw.close();
				
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
				   listname.add(line);                  //The first line of text description of "1_Character.txt"
			    flag++;
			    continue;
			   }
			   for(String newline:line.split(",")) {
			   item.add(newline);                      //Player value of "1_Character.txt"
			   }
			   
			  }
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	static void Save(String filename) throws IOException {
		//// TODO: You should save the changed variables into original data (filename). ////
		FileWriter fw = new FileWriter(filename); 
		for (int i = 0; i <listname.size(); i++) {
	        fw.write(listname.get(i));                 //Write the first line of text description back to the file
	      }
		fw.write("\r\n");
		for (int i = 0; i <item.size(); i++) {         //Write the player value back to the file
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
		//// TODO: Each Character object which you had loaded should be modified after calling the Random function.
		//// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
		//// TODO: Before the next Character objects will be modified and after the previous Character has been modified, you should press ENTER to do next step(Let the next Character object be modified)
		//// TODO: In brief, before you modified the Character object, you should press ENTER, and then stop(wait) for another ENTER in order to modified next Character object
		//// TODO: While each of Character object has been modified or Character.status is zero, the Random function end.
		int step=0;
		int statusaddress1=3;
		int locationaddress1=0;
		for(int i=0;i<player;i++) {     //Randomly roll the dice and write to the new address and status
			for(int j=0;j<Integer.parseInt(item.get(statusaddress1));j++) {
				step=step+(int)(Math.random()*6)+1;
			}
			step=step+Integer.parseInt(item.get(locationaddress1));
			item.set(locationaddress1,""+step); 
			try{
				Scanner useradvice = new Scanner(System.in);
				System.out.print("player"+(i+1)+"end(enter to continue)");
				//write in to the file
				String line = useradvice.nextLine();
				while(!line.equals("")) {
					line = useradvice.nextLine();
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			item.set(statusaddress1,""+0);
			statusaddress1+=5;
			locationaddress1+=5;
			step=0;
		}
		
		
	}

}
