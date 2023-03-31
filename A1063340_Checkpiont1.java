import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Checkpiont1 {
	public static ArrayList<String> listname=new ArrayList<String>();  //裝 1_Character.txt的第一行文字說明
	public static ArrayList<String> item=new ArrayList<String>();      //裝 1_Character.txt的玩家數值
	public static ArrayList<String> output=new ArrayList<String>();    //裝要output出來的內容
	public static void main(String[] args) throws IOException {

		//// TODO: Declare the object of Character. ////
		
	    //// Then, Load the information from the "1_Character.txt" file, ////
		Load("1_Character.txt");  //讀取 1_Character.txt
		
		int player;
		int j=0;
		player=item.size()/5;  //算出玩家數量
		
		Character[] Character = new Character[player];
		for(int i=0;i<player;i++) {
			Character[i] = new Character();  //宣告玩家Character()
		}
	    for(int i=0;i<player;i++) {   //給定各玩家遊戲資料
	    		Character[i].location=Integer.parseInt(item.get(j++));
		        Character[i].CHARACTER_NUMBER=Integer.parseInt(item.get(j++));
		        Character[i].money=Integer.parseInt(item.get(j++));
		        Character[i].status=Integer.parseInt(item.get(j++));
		        Character[i].IMAGE_FILENAME=item.get(j++);
	    }
	    
	    //// and modify the variables which we ask you to do and then Save it. ////
	    int moneyaddress=2;
	    int locationaddress=0;
	    for(int i=0;i<player;i++) {   // "money-100","location+1"
	    	Character[i].money=Character[i].money-100;
	        Character[i].location=Character[i].location+1;
	        item.set(moneyaddress,""+Character[i].money);
	        item.set(locationaddress,""+Character[i].location);
	        moneyaddress=moneyaddress+5;
	        locationaddress=locationaddress+5;
	    }
	    
	    Save("1_Character.txt");      //儲存運算後的遊戲數值
		
	    int [] width=new int [player];
	    int [] height=new int [player];
	    for(int i=0;i<player;i++) {       //讀取角色圖片的寬高
	    	BufferedImage image1 = ImageIO.read(new File(Character[i].IMAGE_FILENAME));
	    	width[i]=image1.getWidth();
	    	height[i]=image1.getHeight();
	    }
	    
	    for(int i=0;i<player;i++) {       //將最後要輸出的資料放入output裡面
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
	   
         
		//// Finally, output the outcome this section need. ////
        	FileWriter fw = new FileWriter("output.txt");         //輸出output到output.txt檔案中
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
				   listname.add(line);             //裝 1_Character.txt的第一行文字說明
			    flag++;
			    continue;
			   }
			   for(String newline:line.split(",")) {
			   item.add(newline);                      //裝 1_Character.txt的玩家數值
			   }
			   
			  }
			  }
			  catch(IOException e){
			   System.out.println(e.getMessage());
			  }
	}

	static void Save(String filename) throws IOException {
		//// TODO: You should save the changed variables into original data (filename) ////
		FileWriter fw = new FileWriter(filename); 
		for (int i = 0; i <listname.size(); i++) {
	        fw.write(listname.get(i));                      //將第一行文字說明寫回檔案
	      }
		fw.write("\r\n");
		for (int i = 0; i <item.size(); i++) {         //將玩家數值寫回檔案
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
}