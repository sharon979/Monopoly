import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class A1063340_Checkpoint6 extends JFrame {
	private static final String driver = "com.mysql.cj.jdbc.Driver" ;
    private static final String protocol = "jdbc:mysql:" ;
    private static Statement s;
   	private static ResultSet rs;
   	private static JButton Start,Load,Exit;
   	public static ArrayList<String> newCharacter=new ArrayList<String>();  
	public static ArrayList<String> newLand=new ArrayList<String>();
	public static ArrayList<String> listname=new ArrayList<String>();  
	public static ArrayList<String> listname2=new ArrayList<String>();
	public static ArrayList<String> item=new ArrayList<String>(); 
	public static ArrayList<String> landitem=new ArrayList<String>(); 
	public static ArrayList<String> PLACE_NUMBER=new ArrayList<String>();
	public static ArrayList<String> LAND_PRICE=new ArrayList<String>();
	public static ArrayList<String> TOLLS=new ArrayList<String>();
	public static ArrayList<String> LOCATION_NUMBER=new ArrayList<String>();
	public static ArrayList<String> owner=new ArrayList<String>();
	public static int player;
	public static int statusaddress=3;
	public static int locationaddress=0;
	public static Character[] Character;
	public static Land[] Land;
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
		newCharacter.add(""+0);
		newCharacter.add(""+1);
		newCharacter.add(""+2000);
		newCharacter.add(""+1);
		newCharacter.add("Character_1.png");
		newCharacter.add(""+0);
		newCharacter.add(""+2);
		newCharacter.add(""+2000);
		newCharacter.add(""+1);
		newCharacter.add("Character_2.png");
		newCharacter.add(""+0);
		newCharacter.add(""+3);
		newCharacter.add(""+2000);
		newCharacter.add(""+1);
		newCharacter.add("Character_3.png");
		newCharacter.add(""+0);
		newCharacter.add(""+4);
		newCharacter.add(""+2000);
		newCharacter.add(""+4);
		newCharacter.add("Character_4.png");
		newLand.add(""+1);
		newLand.add(""+0);
		newLand.add(""+2);
		newLand.add(""+0);
		newLand.add(""+3);
		newLand.add(""+0);
		newLand.add(""+4);
		newLand.add(""+0);
		newLand.add(""+5);
		newLand.add(""+0);
		newLand.add(""+6);
		newLand.add(""+0);
		newLand.add(""+7);
		newLand.add(""+0);
		newLand.add(""+8);
		newLand.add(""+0);
		newLand.add(""+9);
		newLand.add(""+0);
		newLand.add(""+10);
		newLand.add(""+0);
		newLand.add(""+11);
		newLand.add(""+0);
		newLand.add(""+12);
		newLand.add(""+0);
		newLand.add(""+13);
		newLand.add(""+0);
		newLand.add(""+14);
		newLand.add(""+0);
		newLand.add(""+15);
		newLand.add(""+0);
		newLand.add(""+16);
		newLand.add(""+0);
		newLand.add(""+17);
		newLand.add(""+0);
		newLand.add(""+18);
		newLand.add(""+0);
		newLand.add(""+19);
		newLand.add(""+0);
		JFrame startgame=new JFrame();
		startgame.setSize(200,200);
		startgame.setDefaultCloseOperation(startgame.DO_NOTHING_ON_CLOSE);
		startgame.setResizable(false);
		startgame.setLayout(new FlowLayout());
		JPanel N1=new JPanel();
		N1.setPreferredSize(new Dimension(200,15));
		startgame.add(N1);
		JPanel N2=new JPanel();
		N2.setPreferredSize(new Dimension(200,5));
		JPanel N3=new JPanel();
		N3.setPreferredSize(new Dimension(200,5));
		Start=new JButton("Start");
		Load=new JButton("Load");
		Exit=new JButton("Exit");
		Start.setPreferredSize(new Dimension(100,25));
		Load.setPreferredSize(new Dimension(100,25));
		Exit.setPreferredSize(new Dimension(100,25));
		startgame.add(Start);
		startgame.add(N2);
		startgame.add(Load);
		startgame.add(N3);
		startgame.add(Exit);
		
		
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Start) {
					try {
						FileWriter fw1 = new FileWriter("Character.txt");
						fw1.write("Round");
						 fw1.write(":");
						 fw1.write(""+1);
						 fw1.write(",");
						 fw1.write("Turn");
						 fw1.write(":");
						 fw1.write(""+1);  
						 fw1.write("\r\n");
						 for (int i = 0; i <newCharacter.size(); i++) {         
							fw1.write(newCharacter.get(i));
					        if(i%5==4) {
					        	fw1.write("\r\n");
					        }
					        else {
					        	fw1.write(",");
					        } 
					      }

						fw1.flush();
						fw1.close();	
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					try {
						FileWriter fw2 = new FileWriter("Land.txt"); 
						fw2.write("LOCATION_NUMBER");
						fw2.write(",");
						fw2.write("owner");
						fw2.write("\r\n");
						
						 for (int i = 0; i <newLand.size(); i++) { 
							 if(i%2==0) {
								 fw2.write(newLand.get(i));
								 fw2.write(",");
							 }
							 else {
								 fw2.write(newLand.get(i));
								 fw2.write("\r\n");
							 }
							
					      }

						fw2.flush();
						fw2.close();	
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					Load("Character.txt","Land.txt");
					GameWindow=new A1063340_GUI();
					GameWindow.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
			}
		});
		
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Load) {
					File file1=new File("Character.txt");
					File file2=new File("Land.txt");
					if(file1.exists()&&file2.exists()) {
						try {
						Load("Character.txt","Land.txt");
						GameWindow=new A1063340_GUI();
						 GameWindow.setVisible(true);
						} catch (IOException e1) {
							e1.printStackTrace();
						}  
					}
					else {
						JFrame error=new JFrame();
						error.setSize(150,100);
						error.setDefaultCloseOperation(error.DO_NOTHING_ON_CLOSE);
						error.setResizable(false);
						error.setLayout(new FlowLayout());
						JLabel text=new JLabel("Without record");
						JButton Confirm=new JButton("Confirm");
						error.add(text);
						error.add(Confirm);
						Confirm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(e.getSource()==Confirm) {
									error.setVisible(false);
								}
							}
						});
						error.setVisible(true);
					}
				}
			}
		});
		
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Exit) {
					System.exit(0);
				}
			}
		});
		startgame.setVisible(true);
	}
	
	public static void Load(String filename, String filename2) throws IOException {
		//// TODO: You should load the variables from the files. ////
		 String url = "//140.127.220.220/";
	        String username = "checkpoint";
	        String password = "ckppwd";
	        try {
				Class.forName(driver);
				System.out.println("Loaded the embedded driver.");
			}catch(Exception err) {
				System.err.println("Unable to load the embedded driver.");
				err.printStackTrace(System.err);
				System.exit(0);
			}
			String dbName = "CHECKPOINT";
			Connection conn = null;
	        try {
				conn = DriverManager.getConnection(protocol + url + "?serverTimezone=UTC", username, password);
	            s = conn.createStatement();
	            s.execute("USE "+dbName);
				Scanner sc = new Scanner(System.in);
	            String query = "SELECT PLACE_NUMBER,LAND_PRICE,TOLLS FROM LAND";
	            rs = s.executeQuery(query);
	            while(rs.next()){
	            	int P=rs.getInt("PLACE_NUMBER");
	            	int L=rs.getInt("LAND_PRICE");
	            	int T=rs.getInt("TOLLS");
	            	PLACE_NUMBER.add(""+P);
	            	LAND_PRICE.add(""+L);
	            	TOLLS.add(""+T);
	            }
				conn.close();
				sc.close();
				System.out.println("end");
			}catch(SQLException err) {
				err.printStackTrace(System.err);
			}
	        try {
	        	FileReader fr=new FileReader(filename2);
				  BufferedReader br=new BufferedReader(fr);
				  String line="";
				  int flag=0;
				  while((line=br.readLine())!=null) {
				   if(flag==0) {
					   for(String newline:line.split(",")) {
						   listname2.add(newline); 
					   }              	 
				    flag++;
				    continue;
				   }
				   for(String newline:line.split(",")) {
				   landitem.add(newline);                      
				   }
				  }
				  br.close();	
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}    
	        
	        for(int i=0;i<landitem.size();i++) {
	        	if(i%2==0) {
	        		LOCATION_NUMBER.add(landitem.get(i));
	        	}
	        	else 
	        		owner.add(landitem.get(i));
	        }
	        System.out.println(PLACE_NUMBER);
	        System.out.println(LAND_PRICE);
	        System.out.println(TOLLS);
	        System.out.println(LOCATION_NUMBER);
	        System.out.println(owner);
	        
	        Land=new Land[16];
	        for(int i=0;i<16;i++) {
	        	Land[i]=new Land(i,i,i,i);
	        }
	        
	        for(int i=0;i<16;i++) {
	        	Land[i].PLACE_NUMBER=Integer.parseInt(PLACE_NUMBER.get(i));
	        	Land[i].owner=Integer.parseInt(owner.get(i));
	        	Land[i].LAND_PRICE=Integer.parseInt(LAND_PRICE.get(i));
	        	Land[i].TOLLS=Integer.parseInt(TOLLS.get(i));
	        	
	        }
	        
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

	public static void Save(String filename, String filename2) throws IOException {
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
		
		FileWriter fw2 = new FileWriter(filename2); 
		fw2.write(listname2.get(0));
		fw2.write(",");
		fw2.write(listname2.get(1));
		fw2.write("\r\n");
		
		 for (int i = 0; i <LOCATION_NUMBER.size(); i++) {         
			fw2.write(LOCATION_NUMBER.get(i));
			fw2.write(",");
			fw2.write(owner.get(i));
			fw2.write("\r\n");
	      }

		fw2.flush();
		fw2.close();	
	}
	
	public static void Random() {
		//// TODO: while calling the Random function, Character.location should plus the random value, and Character.status should minus one.
		//// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
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

	