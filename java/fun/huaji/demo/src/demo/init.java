import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ball {
	double x;
	double y;
	ArrayList<Image> img;
	double l;
	double nowimg; 
	public ball(double x, double y, ArrayList<Image> img,double l,double nowimg) {
		this.x = x;
		this.y = y;
		this.img = img;
		this.l=l;
		this.nowimg=nowimg;
	}
}
class MyFrame extends JFrame{
	MyPanel panel;
	public static final int width=1320;
	public static final int height=720;
	public MyFrame(int x,int y,ArrayList<ball> b){
		try {
			this.setBounds(x, y, width, height);
			panel=new MyPanel(b);
			this.add(panel);
			this.setVisible(true);
		} catch (Exception e) {
			// TODO 
			e.printStackTrace();
		}
	}
}
class npcball extends ball implements Runnable{
	double v;
	double d;
	double av;
	double gv;
	double mg;
	double ef;
	double gva;
	static double fn=1000000;
	static double kn=1;
	static double G=300;
	int r_l;
	int d_u;
	static int room_width=MyFrame.width;
	static int room_height=MyFrame.height;
	static int k=10;
	double g;
	public npcball(int x,int y,ArrayList<Image> img, double l, double v,double d,int r_l,int d_u){
		super(x,y,img,l,Math.random());
		this.v=v;
		this.d=d;
		this.av=1-(l/fn);
		this.r_l=r_l;
		this.d_u=d_u;
		gva=1;
		g=(l/G)*(l/G);
		new Thread(this).start();
	}
	public void mmotioning()
	{
		gv=(v*k/Math.sin(Math.PI/180*90)*Math.sin(Math.PI/180*(d)));
		ef=ef<(g/2)?0:ef;
		mg=((g>gv&&y>room_height-l/2-35)?gv:g)*gva;
		gva=mg>=g?y>room_height-l/2-35?1:gva+0.05:1;
		y=y+(d_u*(gv+((d_u==1||ef!=0)?mg:-mg))-ef);
		x=x+(r_l*(v*k/Math.sin(Math.PI/180*90)*Math.sin(Math.PI/180*(90-d))));
		v*=av;
		r_l=x<l/2?1:x>room_width-l/2-15?-1:r_l;
		d_u=y<l/2?1:y>room_height-l/2-35?-1:d_u;
		ef=y>room_height-l/2-35?gv*kn:0;
		nowimg=nowimg>=img.size()-0.8?0:nowimg+(Math.random()/100);
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				this.mmotioning();
				Thread.sleep(k);
				if(v==0)
					return;
			}
		} catch (InterruptedException e) {
			// TODO
			e.printStackTrace();
		}
		// TODO 
		
	}
}
class MyPanel extends JPanel{
	ArrayList<ball> b;
	int x,y,xr,yr;
	MyPanel(ArrayList<ball> b)
	{
		this.b=b;
		System.out.println("panel");
	}
	public void paint(Graphics g){
		
		try {super.paint(g);
		for(int i=0;i<b.size();i++)
		{
			x=(int)(b.get(i).x-(b.get(i).l/2));
			y=(int)(b.get(i).y-(b.get(i).l/2));
			xr=(int)b.get(i).l;
			yr=(int)b.get(i).l;
			g.drawImage(b.get(i).img.get((int) b.get(i).nowimg), x,y,xr,yr, null);
		}
			this.repaint();
		} catch (Exception e) {
			// TODO 
			e.printStackTrace();
		}
	}
}
public class init {
    public static void main(String[] args) throws IOException {
        ArrayList<ball> balls=new ArrayList<ball>();
        ArrayList<Image> ballimg=new ArrayList<Image>();
        ballimg.add(ImageIO.read(new File("/Users/xuqiangfang/Source/java/fun/huaji/demo/src/img/huaji2.png")));
        ballimg.add(ImageIO.read(new File("/Users/xuqiangfang/Source/java/fun/huaji/demo/src/img/huaji2.png")));
        ballimg.add(ImageIO.read(new File("/Users/xuqiangfang/Source/java/fun/huaji/demo/src/img/huaji2.png")));
        MyFrame a=new MyFrame(0,0,balls);
        for(int i=0;i<100;i++)
        {
            int ballsize=(int) (Math.random()*(500-10)+10);
            balls.add(new npcball(
                    (int)(Math.random()*(MyFrame.width-ballsize/2-15-ballsize/2)+ballsize/2),
                    (int)(Math.random()*(MyFrame.height-ballsize/2-35-ballsize/2)+ballsize/2),
                    ballimg,
                    ballsize,
                    (int)(Math.random()*(5-1)+1),
                    Math.random()*(90),
                    (Math.random()*1000)%2==0?1:-1,
                    (Math.random()*1000)%2==0?1:-1
                    )
            );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO 
                e.printStackTrace();
            }
        }
	}
}
	/*MyThread a=new MyThread();
	a.start();*/
