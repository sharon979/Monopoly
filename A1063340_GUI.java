import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class A1063340_GUI extends JFrame implements ActionListener,Runnable{
	public static final int WIDTH=700;
	public static final int HEIGHT=700;
	public static final int[] x = {575,470,375,290,200,95,95,95,95,95,95,200,290,375,470,575,575,575,575,575};
	public static final int[] y = {605,605,605,605,605,605,500,410,320,230,130,130,130,130,130,130,230,320,410,500};
	public static ArrayList<Integer> location=new ArrayList<>(); 
	public static int[][] character=new int[A1063340_Checkpoint6.player][2];
	public static int whichCharacter=0;
	private JButton Save,Load,Exit,Dicebutton;
	private JLabel playerlocation,round,turnCharacter;
	private JLabel playername[]=new JLabel[A1063340_Checkpoint6.player];
	private JLabel playermoney[]=new JLabel[A1063340_Checkpoint6.player];
	private boolean CanGo=true;
	private Image img[];
	
	public A1063340_GUI() throws IOException {
		super();
		for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			location.add(A1063340_Checkpoint6.Character[i].location);
		}
		for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			for(int j=0;j<2;j++) {
				character[i][0]=x[location.get(i)];
				character[i][1]=y[location.get(i)];
			}	
		}
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		 FlowLayout layout = new FlowLayout(); 
		 BorderLayout border = new BorderLayout(); 
		 setLayout(layout);
		 layout.setHgap(0);
		 layout.setVgap(0);
		 
		 JPanel Panel1 = new JPanel();
		 Panel1.setBackground(Color.WHITE);
		 JPanel Panel2= new JPanel();
		 Panel2.setBackground(Color.WHITE);
		 Panel1.setLayout(layout);
		 Panel2.setLayout(layout);
		 
		 JPanel Panel21= new JPanel();
		 Panel21.setBackground(Color.WHITE);
		 JPanel Panel22=new JPanel();
		 Panel22.setBackground(Color.WHITE);
		 JPanel Panel23= new JPanel();
		 Panel23.setBackground(Color.WHITE);
		 JPanel Panel23Q= new JPanel();
		 Panel23Q.setBackground(Color.WHITE);
		 JPanel Panel23QQ= new JPanel();
		 Panel23QQ.setBackground(Color.WHITE);
		 
		 JPanel Panel11= new JPanel();
		 Panel11.setBackground(Color.WHITE);
		 JPanel Panel111=new JPanel();
		 Panel111.setBackground(Color.WHITE);
		 
		 JPanel Panel12= new JPanel();
		 Panel12.setBackground(Color.WHITE);
		 JPanel Panel121= new JPanel();
		 Panel121.setBackground(Color.WHITE);
		 JPanel Panel122= new JPanel();
		 Panel122.setBackground(Color.WHITE);
		 
		 JPanel Panelword1= new JPanel();
		 Panelword1.setBackground(Color.WHITE);
		 JPanel Panelword11= new JPanel();
		 Panelword11.setBackground(Color.WHITE);
		 JPanel Panelword12= new JPanel();
		 Panelword12.setBackground(Color.WHITE);
		 
		 JPanel Panelword2= new JPanel();
		 Panelword2.setBackground(Color.WHITE);
		 JPanel Panelword21= new JPanel();
		 Panelword21.setBackground(Color.WHITE);
		 JPanel Panelword22= new JPanel();
		 Panelword22.setBackground(Color.WHITE);
		 
		 JPanel Panelword3= new JPanel();
		 Panelword3.setBackground(Color.WHITE);
		 JPanel Panelword31= new JPanel();
		 Panelword31.setBackground(Color.WHITE);
		 JPanel Panelword32= new JPanel();
		 Panelword32.setBackground(Color.WHITE);
		 
		 JPanel Panelword4= new JPanel();
		 Panelword4.setBackground(Color.WHITE);
		 JPanel Panelword41= new JPanel();
		 Panelword41.setBackground(Color.WHITE);
		 JPanel Panelword42= new JPanel();
		 Panelword42.setBackground(Color.WHITE);
		 
		 JPanel Panel222= new JPanel();
		 Panel222.setBackground(Color.WHITE);
		 JPanel Panel223= new JPanel();
		 Panel223.setBackground(Color.WHITE);
		 JPanel Panel224= new JPanel();
		 Panel224.setBackground(Color.WHITE);
		 
		 JPanel Panel2231=new JPanel();
		 Panel2231.setBackground(Color.WHITE);
		 JPanel Panel2232=new JPanel();
		 Panel2232.setBackground(Color.WHITE);
		 JPanel Panel2233=new JPanel();
		 Panel2233.setBackground(Color.WHITE);
		 
		 JPanel insidetop=new JPanel();
		 insidetop.setBackground(Color.WHITE);
		 JPanel insidedown=new JPanel();
		 insidedown.setBackground(Color.WHITE);
		 
		 JPanel insidedown1=new JPanel();
		 insidedown1.setBackground(Color.WHITE);
		 JPanel insidedown2=new JPanel();
		 insidedown2.setBackground(Color.WHITE);
		 
		 JPanel insidedown11=new JPanel();
		 insidedown11.setBackground(Color.WHITE);
		 JPanel insidedown12=new JPanel();
		 insidedown12.setBackground(Color.WHITE);
		 
		 JPanel insidedown12location=new JPanel() {
			 @Override
				protected void paintComponent(Graphics g) {
					ImageIcon icon = new ImageIcon("display_dicenum.png");
					Image img = icon.getImage();
					g.drawImage(img, 35, 14, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
				}
		 };
		 insidedown12location.setBackground(Color.WHITE);
		 JPanel insidedown12round=new JPanel();
		 insidedown12round.setBackground(Color.WHITE);
		 
		 Panel21.setLayout(layout);
		 Panel22.setLayout(layout);
		 Panel23.setLayout(layout);
		 Panel23Q.setLayout(layout);
		 Panel23QQ.setLayout(layout);
		 Panel11.setLayout(layout);
		 Panel111.setLayout(layout);
		 Panel12.setLayout(layout);
		 Panel121.setLayout(layout);
		 Panel122.setLayout(layout);
		 Panelword1.setLayout(layout);
		 Panelword2.setLayout(layout);
		 Panelword3.setLayout(layout);
		 Panelword4.setLayout(layout);
		 Panel222.setLayout(layout);
		 Panel223.setLayout(layout);
		 Panel224.setLayout(layout);
		 
		 Panel2231.setLayout(layout);
		 Panel2232.setLayout(layout);
		 Panel2233.setLayout(layout);
		 
		 insidetop.setLayout(border);
		 insidedown.setLayout(layout);
		 insidedown1.setLayout(layout);
		 insidedown11.setLayout(layout);
		 insidedown12.setLayout(layout);
		 
		 insidedown12location.setLayout(layout);
		 insidedown12round.setLayout(layout);
		 insidedown2.setLayout(border);
		 
		 Panel1.setPreferredSize(new Dimension(700,50));
		 Panel2.setPreferredSize(new Dimension(700,650));
		 
		 Panel11.setPreferredSize(new Dimension(200,50));
		 Panel111.setPreferredSize(new Dimension(200,5));
		 Panel12.setPreferredSize(new Dimension(460,50));
		 Panel121.setPreferredSize(new Dimension(460,20));
		 Panel122.setPreferredSize(new Dimension(460,20));
		
		 Panelword1.setPreferredSize(new Dimension(115,50));
		 Panelword11.setPreferredSize(new Dimension(115,25));
		 Panelword12.setPreferredSize(new Dimension(115,25));
		 
		 Panelword2.setPreferredSize(new Dimension(115,50));
		 Panelword21.setPreferredSize(new Dimension(115,25));
		 Panelword22.setPreferredSize(new Dimension(115,25));
		 
		 Panelword3.setPreferredSize(new Dimension(115,50));
		 Panelword31.setPreferredSize(new Dimension(115,25));
		 Panelword32.setPreferredSize(new Dimension(115,25));
		 
		 Panelword4.setPreferredSize(new Dimension(115,50));
		 Panelword41.setPreferredSize(new Dimension(115,25));
		 Panelword42.setPreferredSize(new Dimension(115,25));
		 
		 Panel21.setPreferredSize(new Dimension(50,650));
		 Panel22.setPreferredSize(new Dimension(600,650));
		 Panel23.setPreferredSize(new Dimension(50,650));
		 
		 Panel23Q.setPreferredSize(new Dimension(50,575));
		 Panel23QQ.setPreferredSize(new Dimension(50,75));
		 
		 Panel222.setPreferredSize(new Dimension(650,120));
		 Panel223.setPreferredSize(new Dimension(650,360));
		 Panel224.setPreferredSize(new Dimension(650,120));
		 
		 Panel2231.setPreferredSize(new Dimension(120,360));
		 Panel2232.setPreferredSize(new Dimension(360,360));
		 Panel2233.setPreferredSize(new Dimension(120,360));
		 
		 insidetop.setPreferredSize(new Dimension(360,90));
		 insidedown.setPreferredSize(new Dimension(360,270));
		 
		 insidedown1.setPreferredSize(new Dimension(360,170));
		 insidedown2.setPreferredSize(new Dimension(360,100));
		 
		 insidedown11.setPreferredSize(new Dimension(180,190));
		 insidedown12.setPreferredSize(new Dimension(180,140));
		 
		 insidedown12location.setPreferredSize(new Dimension(180,110));
		 insidedown12round.setPreferredSize(new Dimension(180,60));
		 
		 
		 for(int i=10;i<=15;i++){
			 JLabel Labelimg = new JLabel();
			 ImageIcon img = new ImageIcon(i+".png");
			 Labelimg.setIcon(img);
			 Panel222.add(Labelimg);
		 }
		 
		 for(int i=5;i>=0;i--){
			 JLabel Labelimg = new JLabel();
			 ImageIcon img = new ImageIcon(i+".png");
			 Labelimg.setIcon(img);
			 Panel224.add(Labelimg);
		 }
		 
		 
		 for(int i=6;i<=9;i++){
			 JLabel Labelimg = new JLabel();
			 ImageIcon img = new ImageIcon(i+".png");
			 Labelimg.setIcon(img);
			 Panel2231.add(Labelimg);
		 }
		 
		 for(int i=16;i<=19;i++){
			 JLabel Labelimg = new JLabel();
			 ImageIcon img = new ImageIcon(i+".png");
			 Labelimg.setIcon(img);
			 Panel2233.add(Labelimg);
		 }
		 
		 JLabel title = new JLabel();
		 ImageIcon Titleimg = new ImageIcon("title.png");
		 title.setIcon(Titleimg);
		 insidetop.add(title,BorderLayout.WEST);
		 
		 JLabel Dice = new JLabel();
		 ImageIcon Diceimg = new ImageIcon("Dice.png");
		 Dicebutton=new JButton("",Diceimg);
		 Dicebutton.setBorder(null);
		 Dicebutton.setBackground(Color.WHITE);
		 Dicebutton.addActionListener(this);
		 insidedown11.add(Dicebutton,BorderLayout.NORTH);
		 
		 playerlocation=new JLabel();
		 playerlocation.setText("<html><body><p align=\"center\"><br/>"+A1063340_Checkpoint6.Dicenumber+"</p></body></html>");
		 playerlocation.setFont(new Font("Dialog", Font.BOLD, 27));
		 insidedown12location.add(playerlocation);
		 
		 
		
		 
		 int count=0;
		 int statusaddress1=3;
		 for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			 count++;
			 if(count==A1063340_Checkpoint6.player && A1063340_Checkpoint6.Character[i].status<=0) {
				 A1063340_Checkpoint6.Round++;
				 A1063340_Checkpoint6.diceCharacter=1;
				 for(int j=0;j<A1063340_Checkpoint6.player;j++) {
						int temp;
						temp=Integer.parseInt(A1063340_Checkpoint6.item.get(statusaddress1))+1;
						A1063340_Checkpoint6.item.set(statusaddress1,""+temp); 
						A1063340_Checkpoint6.Character[j].status=Integer.parseInt(A1063340_Checkpoint6.item.get(statusaddress1));
						statusaddress1+=5;		
					}
				 break;
			 }
			 else if(A1063340_Checkpoint6.Character[i].status!=0) {
				 A1063340_Checkpoint6.diceCharacter=i+1;
				 break;
			 }
		 }
		 turnCharacter=new JLabel();
		 turnCharacter.setText("Turn  Character "+(A1063340_Checkpoint6.diceCharacter));
		 turnCharacter.setFont(new Font("Dialog", Font.BOLD, 28));
		 insidedown2.add(turnCharacter,BorderLayout.EAST);
		
		 round=new JLabel();
		 round.setText("Round  "+A1063340_Checkpoint6.Round);
		 round.setFont(new Font("Dialog", Font.BOLD, 24));
		 insidedown12round.add(round,BorderLayout.SOUTH);
		 
		for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			 playername[i]=new JLabel();
			 playername[i].setText("Character"+" "+A1063340_Checkpoint6.Character[i].CHARACTER_NUMBER+"     ");
			 playername[i].setFont(new Font("Dialog", Font.BOLD, 13));
			 Panel121.add(playername[i]);
		 }
		
		 for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			 playermoney[i]=new JLabel();
			 playermoney[i].setText("  "+A1063340_Checkpoint6.Character[i].money+"        ");
			 playermoney[i].setFont(new Font("Dialog", Font.BOLD, 13));
			 Panel122.add(playermoney[i]);
		 }
		 
		
		 Save =new JButton("Save");
		 Load =new JButton("Load");
		 Exit =new JButton("Exit");
		 Exit.addActionListener(this);
		 Save.addActionListener(this);
		 Load.addActionListener(this);
		 add(Exit);
		 
		 Save.setPreferredSize(new Dimension(80,30));
		 Load.setPreferredSize(new Dimension(80,30));
		 Exit.setPreferredSize(new Dimension(60,30));
		 
		 add(Panel1);
		 add(Panel2);
		
		 Panel1.add(Panel11);
		 Panel1.add(Panel12);
		 Panel12.add(Panel121);
		 Panel12.add(Panel122);
		 Panel11.add(Panel111);
		 Panel11.add(Save);
		 Panel11.add(Load);
		 Panel23.add(Panel23Q);
		 Panel23.add(Panel23QQ);
		 Panel23QQ.add(Exit);
		 
		 Panel2.add(Panel21);
		 Panel2.add(Panel22);
		 Panel2.add(Panel23);
		 
		 Panel22.add(Panel222);
		 Panel22.add(Panel223);
		 Panel22.add(Panel224);
		 
		 Panel223.add(Panel2231);
		 Panel223.add(Panel2232);
		 Panel223.add(Panel2233);
		
		 Panel2232.add(insidetop);
		 Panel2232.add(insidedown);

		 insidedown.add(insidedown1);
		 insidedown.add(insidedown2);
		 
		 insidedown1.add(insidedown11);
		 insidedown1.add(insidedown12);
		 
		 insidedown12.add(insidedown12location);
		 insidedown12.add(insidedown12round);
		
	}

	public void actionPerformed(ActionEvent e) { 
		if(e.getSource()==Exit) {
			System.exit(0);
		}
		if(e.getSource()==Save) {
			try {
				A1063340_Checkpoint6.Save("Character.txt","Land.txt");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Load) {
			try {
				A1063340_Checkpoint6.listname.clear();
				A1063340_Checkpoint6.item.clear();
				A1063340_Checkpoint6.listname2.clear();
				A1063340_Checkpoint6.landitem.clear();
				A1063340_Checkpoint6.PLACE_NUMBER.clear();
				A1063340_Checkpoint6.LAND_PRICE.clear();
				A1063340_Checkpoint6.TOLLS.clear();
				A1063340_Checkpoint6.LOCATION_NUMBER.clear();
				A1063340_Checkpoint6.owner.clear();
				A1063340_Checkpoint6.Dicenumber=0;
				A1063340_Checkpoint6.Load("Character.txt","Land.txt");
				A1063340_Checkpoint6.GameWindow.setVisible(false);
			    A1063340_GUI newGamewindows=new A1063340_GUI();
			    newGamewindows.setVisible(true);
			    
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource()==Dicebutton && CanGo==true) {
			CanGo=false;
			A1063340_Checkpoint6.Random();
			startThread();
			playerlocation.setText("<html><body><p align=\"center\"><br/>"+A1063340_Checkpoint6.Dicenumber+"</p></body></html>");
			
		}	
	}
	public void paint(Graphics g) {
		super.paint(g);
		img=new Image[A1063340_Checkpoint6.player];
		for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			img[i]=Toolkit.getDefaultToolkit().getImage(A1063340_Checkpoint6.Character[i].IMAGE_FILENAME);
		}
		int r1[]= {-15,15,-15,15};
		int r2[]= {-15,-15,15,15};
		for(int i=0;i<16;i++) {
			if(A1063340_Checkpoint6.Land[i].owner!=0) {
				 g.setFont(new Font("Dialog",Font.BOLD,48)); 
				 g.drawString(""+A1063340_Checkpoint6.Land[i].owner,x[A1063340_Checkpoint6.Land[i].PLACE_NUMBER]+5,y[A1063340_Checkpoint6.Land[i].PLACE_NUMBER]+25); 
			}
		}
		int count=0;
		for(int i=0;i<A1063340_Checkpoint6.player;i++) {
			g.drawImage(img[i], character[i][0]+r1[i], character[i][1]+r2[i], this);
		}
	}
	
	public void run() {
		int now=A1063340_Checkpoint6.walkCharacter-1;
		int lastlocation=location.get(now);
		int last=location.get(now);
		int newlocation=((A1063340_Checkpoint6.Dicenumber+location.get(now))%20);
		System.out.println("last"+last);
		System.out.println("newlocation"+newlocation);
		location.set(now,newlocation);
		int count1=x[newlocation]-x[lastlocation];
		int count2=y[newlocation]-y[lastlocation];
		int sleep=0;
		if(count1<0) {
			count1=count1*(-1);
		}
		if(count2<0) {
			count2=count2*(-1);
		}
		if(A1063340_Checkpoint6.Dicenumber<=3) {
			sleep=2000/(count1+count2);
		}
		else if(A1063340_Checkpoint6.Dicenumber>3) {
			sleep=3000/(count1+count2);
		}
			while(lastlocation!=newlocation) {
				int first=lastlocation;
				int next=lastlocation+1;
				if(next==20) {
					next=0;
				}
				if(now==0) {
					if(x[first]!=x[next]) {
						if(x[first]<x[next]) {
							for(int j=x[first];j<=x[next];j++) {
								character[now][0]++;
								repaint();
								doNothing(sleep);
							}
						}
						else {
							for(int j=x[first];j>=x[next];j--) {
								character[now][0]--;
								repaint();
								doNothing(sleep);	
							}	
						}
					}
					if(y[first]!=y[next]) {
						if(y[first]<y[next]) {
							for(int j=y[first];j<=y[next];j++) {
								character[now][1]++;
								repaint();
								doNothing(sleep);	
							}	
						}
						else {
							for(int j=y[first];j>=y[next];j--) {
								character[now][1]--;
								repaint();
								doNothing(sleep);
							}	
						}
					}
					location.set(now,next);
					lastlocation++;
					if(lastlocation==20) {
						lastlocation=0;
					}
				}
				if(now==1) {
					if(x[first]!=x[next]) {
						if(x[first]<x[next]) {
							for(int j=x[first];j<=x[next];j++) {
								character[now][0]++;
								repaint();
								doNothing(sleep);
							}
						}
						else {
							for(int j=x[first];j>=x[next];j--) {
								character[now][0]--;
								repaint();
								doNothing(sleep);	
							}	
						}
					}
					if(y[first]!=y[next]) {
						if(y[first]<y[next]) {
							for(int j=y[first];j<=y[next];j++) {
								character[now][1]++;
								repaint();
								doNothing(sleep);	
							}	
						}
						else {
							for(int j=y[first];j>=y[next];j--) {
								character[now][1]--;
								repaint();
								doNothing(sleep);
							}	
						}
					}
					location.set(now,next);
					lastlocation++;
					if(lastlocation==20) {
						lastlocation=0;
					}
				}
				if(now==2) {
					if(x[first]!=x[next]) {
						if(x[first]<x[next]) {
							for(int j=x[first];j<=x[next];j++) {
								character[now][0]++;
								repaint();
								doNothing(sleep);
							}
						}
						else {
							for(int j=x[first];j>=x[next];j--) {
								character[now][0]--;
								repaint();
								doNothing(sleep);	
							}	
						}
					}
					if(y[first]!=y[next]) {
						if(y[first]<y[next]) {
							for(int j=y[first];j<=y[next];j++) {
								character[now][1]++;
								repaint();
								doNothing(sleep);	
							}	
						}
						else {
							for(int j=y[first];j>=y[next];j--) {
								character[now][1]--;
								repaint();
								doNothing(sleep);
							}	
						}
					}
					location.set(now,next);
					lastlocation++;
					if(lastlocation==20) {
						lastlocation=0;
					}
				}
				if(now==3) {
					if(x[first]!=x[next]) {
						if(x[first]<x[next]) {
							for(int j=x[first];j<=x[next];j++) {
								character[now][0]++;
								repaint();
								doNothing(sleep);
							}
						}
						else {
							for(int j=x[first];j>=x[next];j--) {
								character[now][0]--;
								repaint();
								doNothing(sleep);	
							}	
						}
					}
					if(y[first]!=y[next]) {
						if(y[first]<y[next]) {
							for(int j=y[first];j<=y[next];j++) {
								character[now][1]++;
								repaint();
								doNothing(sleep);	
							}	
						}
						else {
							for(int j=y[first];j>=y[next];j--) {
								character[now][1]--;
								repaint();
								doNothing(sleep);
							}	
						}
					}
					location.set(now,next);
					lastlocation++;
					if(lastlocation==20) {
						lastlocation=0;
					}
				}
		}
			doNothing(500);
			
		int moneyaddress=2;
		int flag=newlocation;
		
		if((last+A1063340_Checkpoint6.Dicenumber)>=20) {   
			A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money+2000;
			playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
			A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
		}
		
		if(flag!=0 ||flag!=5 ||flag!=10 ||flag!=15) {
			if(flag>=1 && flag<=4) {
				if(A1063340_Checkpoint6.Land[flag-1].owner==0 && A1063340_Checkpoint6.Character[now].money>=A1063340_Checkpoint6.Land[flag-1].LAND_PRICE) {
					int BuyBox=JOptionPane.showConfirmDialog(this,"              Do you want to buy?\n"+"                         $"+A1063340_Checkpoint6.Land[flag-1].LAND_PRICE+"?","Buy Land!!",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
					if(BuyBox==0) {
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-1].LAND_PRICE;
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
						A1063340_Checkpoint6.Land[flag-1].owner=now+1;
						A1063340_Checkpoint6.owner.set(flag-1,""+(now+1));
						repaint();
						
					}
				}
				else if(A1063340_Checkpoint6.Land[flag-1].owner!=0 && A1063340_Checkpoint6.Land[flag-1].owner!=A1063340_Checkpoint6.walkCharacter){
					JOptionPane.showMessageDialog(this,"this Land owner is Character"+A1063340_Checkpoint6.Land[flag-1].owner+",Character"+A1063340_Checkpoint6.walkCharacter+" need to pay $"+A1063340_Checkpoint6.Land[flag-1].TOLLS,"Pay TOLLS!!",JOptionPane.PLAIN_MESSAGE);
						A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-1].owner-1].money=A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-1].owner-1].money+A1063340_Checkpoint6.Land[flag-1].TOLLS;
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-1].TOLLS;
						A1063340_Checkpoint6.item.set(moneyaddress+((A1063340_Checkpoint6.Land[flag-1].owner-1)*5),""+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-1].owner-1].money);
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[A1063340_Checkpoint6.Land[flag-1].owner-1].setText("  "+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-1].owner-1].money+"                 ");
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
					
				}
			}
			else if(flag>=6 && flag<=9) {
				if(A1063340_Checkpoint6.Land[flag-2].owner==0 && A1063340_Checkpoint6.Character[now].money>=A1063340_Checkpoint6.Land[flag-2].LAND_PRICE) {
					int BuyBox=JOptionPane.showConfirmDialog(this,"              Do you want to buy?\n"+"                         $"+A1063340_Checkpoint6.Land[flag-2].LAND_PRICE+"?","Buy Land!!",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
					if(BuyBox==0) {
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-2].LAND_PRICE;
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
						A1063340_Checkpoint6.Land[flag-2].owner=now+1;
						A1063340_Checkpoint6.owner.set(flag-2,""+(now+1));
						repaint();
					}
				}
				else if(A1063340_Checkpoint6.Land[flag-2].owner!=0 && A1063340_Checkpoint6.Land[flag-2].owner!=A1063340_Checkpoint6.walkCharacter){
					JOptionPane.showMessageDialog(this,"this Land owner is Character"+A1063340_Checkpoint6.Land[flag-2].owner+",Character"+A1063340_Checkpoint6.walkCharacter+" need to pay $"+A1063340_Checkpoint6.Land[flag-2].TOLLS,"Pay TOLLS!!",JOptionPane.PLAIN_MESSAGE);
					
						A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-2].owner-1].money=A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-2].owner-1].money+A1063340_Checkpoint6.Land[flag-2].TOLLS;
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-2].TOLLS;
						A1063340_Checkpoint6.item.set(moneyaddress+((A1063340_Checkpoint6.Land[flag-2].owner-1)*5),""+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-2].owner-1].money);
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[A1063340_Checkpoint6.Land[flag-2].owner-1].setText("  "+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-2].owner-1].money+"                 ");
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
					
				}
			}
			else if(flag>=11 && flag<=14) {
				if(A1063340_Checkpoint6.Land[flag-3].owner==0 && A1063340_Checkpoint6.Character[now].money>=A1063340_Checkpoint6.Land[flag-3].LAND_PRICE) {
					int BuyBox=JOptionPane.showConfirmDialog(this,"              Do you want to buy?\n"+"                         $"+A1063340_Checkpoint6.Land[flag-3].LAND_PRICE+"?","Buy Land!!",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
					if(BuyBox==0) {
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-3].LAND_PRICE;
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
						A1063340_Checkpoint6.Land[flag-3].owner=now+1;
						A1063340_Checkpoint6.owner.set(flag-3,""+(now+1));
						repaint();
					}
				}
				else if(A1063340_Checkpoint6.Land[flag-3].owner!=0 && A1063340_Checkpoint6.Land[flag-3].owner!=A1063340_Checkpoint6.walkCharacter){
					JOptionPane.showMessageDialog(this,"this Land owner is Character"+A1063340_Checkpoint6.Land[flag-3].owner+",Character"+A1063340_Checkpoint6.walkCharacter+" need to pay $"+A1063340_Checkpoint6.Land[flag-1].TOLLS,"Pay TOLLS!!",JOptionPane.PLAIN_MESSAGE);
			
						A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-3].owner-1].money=A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-3].owner-1].money+A1063340_Checkpoint6.Land[flag-3].TOLLS;
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-3].TOLLS;
						A1063340_Checkpoint6.item.set(moneyaddress+((A1063340_Checkpoint6.Land[flag-3].owner-1)*5),""+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-3].owner-1].money);
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[A1063340_Checkpoint6.Land[flag-3].owner-1].setText("  "+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-3].owner-1].money+"                 ");
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
					
				}
			}
			else if(flag>=16 && flag<=19) {
				if(A1063340_Checkpoint6.Land[flag-4].owner==0 && A1063340_Checkpoint6.Character[now].money>=A1063340_Checkpoint6.Land[flag-4].LAND_PRICE) {
					int BuyBox=JOptionPane.showConfirmDialog(this,"              Do you want to buy?\n"+"                         $"+A1063340_Checkpoint6.Land[flag-4].LAND_PRICE+"?","Buy Land!!",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
					if(BuyBox==0) {
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-4].LAND_PRICE;
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
						A1063340_Checkpoint6.Land[flag-4].owner=now+1;
						A1063340_Checkpoint6.owner.set(flag-4,""+(now+1));
						repaint();
					}
				}
				else if(A1063340_Checkpoint6.Land[flag-4].owner!=0 && A1063340_Checkpoint6.Land[flag-4].owner!=A1063340_Checkpoint6.walkCharacter){
					JOptionPane.showMessageDialog(this,"this Land owner is Character"+A1063340_Checkpoint6.Land[flag-4].owner+",Character"+A1063340_Checkpoint6.walkCharacter+" need to pay $"+A1063340_Checkpoint6.Land[flag-1].TOLLS,"Pay TOLLS!!",JOptionPane.PLAIN_MESSAGE);
				
						A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-4].owner-1].money=A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-4].owner-1].money+A1063340_Checkpoint6.Land[flag-4].TOLLS;
						A1063340_Checkpoint6.Character[now].money=A1063340_Checkpoint6.Character[now].money-A1063340_Checkpoint6.Land[flag-4].TOLLS;
						A1063340_Checkpoint6.item.set(moneyaddress+((A1063340_Checkpoint6.Land[flag-4].owner-1)*5),""+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-4].owner-1].money);
						A1063340_Checkpoint6.item.set(moneyaddress+(now*5),""+A1063340_Checkpoint6.Character[now].money);
						playermoney[A1063340_Checkpoint6.Land[flag-4].owner-1].setText("  "+A1063340_Checkpoint6.Character[A1063340_Checkpoint6.Land[flag-4].owner-1].money+"                 ");
						playermoney[now].setText("  "+A1063340_Checkpoint6.Character[now].money+"                 ");
					
				}
			}
		}
		
		

		round.setText("Round  "+A1063340_Checkpoint6.Round);
		turnCharacter.setText("Turn  Character "+A1063340_Checkpoint6.diceCharacter);
		CanGo=true;
	}			
	public void startThread() {
		Thread theThread=new Thread(this);
		theThread.start();
	}
	public void doNothing(int millisseconds) {
		try {
			Thread.sleep(millisseconds);
		} catch (InterruptedException e) {
			System.out.println("Unexpected interrupt");
			System.exit(0);
		}
	}
}

