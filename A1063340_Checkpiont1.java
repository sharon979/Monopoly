import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Checkpiont1 {
	public static ArrayList<String> listname=new ArrayList<String>();  //�� 1_Character.txt���Ĥ@���r����
	public static ArrayList<String> item=new ArrayList<String>();      //�� 1_Character.txt�����a�ƭ�
	public static ArrayList<String> output=new ArrayList<String>();    //�˭noutput�X�Ӫ����e
	public static void main(String[] args) throws IOException {

		//// TODO: Declare the object of Character. ////
		
	    //// Then, Load the information from the "1_Character.txt" file, ////
		Load("1_Character.txt");  //Ū�� 1_Character.txt
		
		int player;
		int j=0;
		player=item.size()/5;  //��X���a�ƶq
		
		Character[] Character = new Character[player];
		for(int i=0;i<player;i++) {
			Character[i] = new Character();  //�ŧi���aCharacter()
		}
	    for(int i=0;i<player;i++) {   //���w�U���a�C�����
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
	    
	    Save("1_Character.txt");      //�x�s�B��᪺�C���ƭ�
		
	    int [] width=new int [player];
	    int [] height=new int [player];
	    for(int i=0;i<player;i++) {       //Ū������Ϥ����e��
	    	BufferedImage image1 = ImageIO.read(new File(Character[i].IMAGE_FILENAME));
	    	width[i]=image1.getWidth();
	    	height[i]=image1.getHeight();
	    }
	    
	    for(int i=0;i<player;i++) {       //�N�̫�n��X����Ʃ�Joutput�̭�
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
        	FileWriter fw = new FileWriter("output.txt");         //��Xoutput��output.txt�ɮפ�
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
				   listname.add(line);             //�� 1_Character.txt���Ĥ@���r����
			    flag++;
			    continue;
			   }
			   for(String newline:line.split(",")) {
			   item.add(newline);                      //�� 1_Character.txt�����a�ƭ�
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
	        fw.write(listname.get(i));                      //�N�Ĥ@���r�����g�^�ɮ�
	      }
		fw.write("\r\n");
		for (int i = 0; i <item.size(); i++) {         //�N���a�ƭȼg�^�ɮ�
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