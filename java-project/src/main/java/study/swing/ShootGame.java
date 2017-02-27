package study.swing;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;    //框架
import javax.swing.JPanel;    //画板
import java.awt.Graphics;     //paint()中的参数
import java.util.Random;
import java.util.Timer;       //定时器
import java.util.TimerTask;   //定时
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;        //颜色
import java.awt.Font;         //字体
/**主程序类*/
public class ShootGame extends JPanel{
	public static final int WIDTH=400;   //窗口的宽
	public static final int HEIGHT=690;  //窗口的高

	public static BufferedImage background;  //背景图片
	public static BufferedImage start;       //开始图片
	public static BufferedImage pause;       //暂停图片
	public static BufferedImage gameover;    //游戏结束图片
	public static BufferedImage airplane;    //敌机图片
	public static BufferedImage bee;         //蜜蜂图片
	public static BufferedImage bullet;      //子弹图片
	public static BufferedImage hero0;       //英雄机0图片
	public static BufferedImage hero1;       //英雄机1图片
	private Hero hero=new Hero();      // 英雄机
	private Bullet[] bullets={};       // 子弹数组
	private FlyingObject[] flyings={}; // 敌机数组

	public static final int START=0;      //启动状态
	public static final int RUNING=1;     //运行状态
	public static final int PAUSE=2;      //暂停状态
	public static final int GAME_OVER=3;  //结束状态
	private int state=START;              //当前状态(启动状态)

	static{     // 静态代码块，初始化图片资源
		try{    //捕获异常语句
			background=ImageIO.read(ShootGame.class.getResource("background.png"));
			start=ImageIO.read(ShootGame.class.getResource("start.png"));
			pause=ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane=ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee=ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet=ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0=ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public FlyingObject nextOne(){  //创建敌人(敌机+小蜜蜂)对象
		Random ra=new Random();
		int type=ra.nextInt(20);    //生成0~19的随机数
		if(type==0){
			return new Bee();       //若随机数为0生成蜜蜂
		}else{
			return new Airplane();  //否则生成敌机
		}
	}

	int flyEnteredIndex=0;          //飞行物入场计数
	public void enterAction(){      //10毫秒走一次  控制入场时间
		flyEnteredIndex++;          //每10毫秒增1
		if(flyEnteredIndex%40==0){  //400(10*40)毫秒走一次
			FlyingObject obj=nextOne();
			flyings=Arrays.copyOf(flyings,flyings.length+1);
			flyings[flyings.length-1]=obj;
		}
	}
	public void stepAction(){       //走步方法
		hero.step();                //英雄机走一步
		for(int i=0;i<flyings.length;i++){    //遍历所有敌人
			flyings[i].step();      //每个敌人走一步
		}
		for(int i=0;i<bullets.length;i++){    //遍历所有子弹
			bullets[i].step();      //每个子弹走一步
		}
	}
	int shootIndex=0;               //射击计数
	public void shootAction(){      //子弹入场 因为在run方法里边 所以也是10毫秒走一次
		shootIndex++;               //每10毫秒自增1
		if(shootIndex%20==0){       //每300毫秒走一次
			Bullet[] bs=hero.shoot();
			bullets=Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets,bullets.length-bs.length, bs.length); //数组的追加
		}
	}
	public void outOfBoundsAction(){    //删除越界飞行物
		int index=0;                    //1.不越界敌人数组下标 2.不越界敌人个数
		FlyingObject[] flyingLives=new FlyingObject[flyings.length]; //不越界敌人数组
		for(int i=0;i<flyings.length;i++){        //遍历所有敌人
			FlyingObject f=flyings[i];  //获取每一个敌人
			if(!f.outOfBounds()){       //不越界
				flyingLives[index]=f;   //将不越界敌人添加到不越界敌人数组
				index++;                //1.下标+1 2.不越界敌人个数增1
			}
		}
		flyings=Arrays.copyOf(flyingLives,index); //将不越界敌人数组里的元素复制到飞行物数组中
	}
	public void bangAction(){           //所有子弹与所有敌人的碰撞
		for(int i=0;i<bullets.length;i++){        //遍历每一个子弹
			Bullet b=bullets[i];        //获取每一个子弹
			bang(b);                    //一个子弹与所有敌人碰撞
		}
	}
	int score=0;                        //玩家得分
	public void bang(Bullet b){         //一个子弹与所有敌人碰撞
		int index=-1;                   //被撞敌人的下标
		for(int i=0;i<flyings.length;i++){        //遍历每一个敌人
			FlyingObject f=flyings[i];  //获取每一个敌人
			if(f.shootBy(b)){           //撞上了
				index=i;                //记录被撞敌人的下标(index值发生改变，不会再是-1)
				break;
			}
		}
		if(index!=-1){                  //被撞上的飞行物
			FlyingObject one = flyings[index];    //获取被撞的敌人
			if(one instanceof Enemy){   //判断被撞敌人的类型 是敌人的话 得分
				Enemy e=(Enemy)one;     //将被撞敌人强转为敌人类型
				score+=e.getScore();    //累加分数
			}
			if(one instanceof Award){   //判断被撞敌人的类型 是蜜蜂的话 得奖励
				Award e=(Award)one;     //将被撞敌人强转为奖励类型
				int type=e.getType();
				switch(type){           //判断获得奖励类型
					case Award.DOUBLE_FIRE: //奖励双倍火力
						hero.addDoubleFir();         //调用英雄机增火力方法
						break;
					case Award.LIFE:        //奖励一条命
						hero.addLife();    //调用英雄机增命力方法
						break;
				}
			}
			FlyingObject t=flyings[index];         //被撞元素
			flyings[index]=flyings[flyings.length-1];
			flyings[flyings.length-1]=t;  //交换被撞敌人与数组中的最后一个元素 即将被撞敌人挪到数组中最后一个位置
			flyings=Arrays.copyOf(flyings,flyings.length-1);  //缩容默认去掉最后一个  去掉最后一个元素也就是被撞的元素
		}
	}
	public void checkGameOverAction(){  //检测游戏是否结束
		if(isGameOver()){               //游戏结束时
			state=GAME_OVER;
		}
	}
	public boolean isGameOver(){        //判断游戏是否结束，返回true表示游戏结束
		for(int i=0;i<flyings.length;i++){  //遍历每一个敌人
			FlyingObject f=flyings[i];  //获取每一个敌人
			if(hero.hit(f)){            //如果撞上了
				hero.subtractLife();    //英雄机减命
				hero.clearDoubleFire(); //英雄机清火力
				FlyingObject t=flyings[i];
				flyings[i]=flyings[flyings.length-1];
				flyings[flyings.length-1]=t;  //交换被撞敌人和数组的最后一个元素
				flyings=Arrays.copyOf(flyings, flyings.length-1);  //缩容
			}
		}
		return hero.getLife()<=0;       //命数<=0 游戏结束
	}
	public void action(){               //启动程序的执行
		MouseAdapter l=new MouseAdapter(){
			public void mouseMoved(MouseEvent e){   //鼠标移动事件
				if(state==RUNING){      //当前状态为运行状态时执行
					int x=e.getX();         //获取鼠标x坐标
					int y=e.getY();         //获取鼠标y坐标
					hero.moveTo(x, y);      //英雄机随着鼠标移动
				}
			}
			public void mouseClicked(MouseEvent e){  //鼠标点击事件
				switch(state){          //不同状态时点击后有不同反应
					case START:             //启动状态时
						state=RUNING;       //当前状态变为运行状态
						break;
					case GAME_OVER:         //游戏结束状态时
						score=0;            //清理现场
						hero=new Hero();
						flyings=new FlyingObject[0];
						bullets=new Bullet[0];
						state=START;        //当前状态为启动状态
						break;
				}
			}
			public void mouseExited(MouseEvent e){   //鼠标移出事件
				if(state==RUNING){      //当前状态为运行状态时
					state=PAUSE;        //当前状态改为暂停状态
				}
			}
			public void mouseEntered(MouseEvent e){  //鼠标移入事件
				if(state==PAUSE){      //当前状态为暂停状态时
					state=RUNING;      //当前状态改为运行状态
				}
			}
		};
		this.addMouseListener(l);       //处理鼠标的操作事件
		this.addMouseMotionListener(l); //处理鼠标的滑动事件
		Timer timer=new Timer();        //定时器对象  定时执行的一些事件
		int intervel=10;                //时间间隔(毫秒)
		timer.schedule(new TimerTask(){ //匿名内部类 重写run方法
			public void run(){          //10毫秒走一次 run方法里边的都是10毫秒走一次
				if(state==RUNING){      //当前状态为运行状态时执行
					enterAction();          //敌人入场
					stepAction();           //飞行物走步
					shootAction();          //子弹入场
					outOfBoundsAction();    //删除越界飞行物
					bangAction();           //子弹与敌人的碰撞
					checkGameOverAction();  //检测游戏是否结束
				}
				repaint();              //重画，调用paint方法
			}
		},intervel,intervel);           //做定时计划任务
	}

	public void paint(Graphics g){      //重写父类paint()方法 g:画笔
		g.drawImage(background,0,0,null);           //画背景图
		paintHero(g);                   //画英雄机
		paintFlyingObjects(g);          //画敌机(敌机+小蜜蜂)
		paintBullets(g);                //画子弹
		paintScoreAndLife(g);           //画分和生命
		paintState(g);                  //画状态
	}
	public void paintHero(Graphics g){  //画英雄机对象
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	public void paintFlyingObjects(Graphics g){     //画敌机(敌机+小蜜蜂)对象
		for(int i=0;i<flyings.length;i++){          //遍历flyings数组
			FlyingObject f=flyings[i];  //把每个敌人存到f中 为了代码的简洁
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	public void paintBullets(Graphics g){            //画子弹对象
		for(int i=0;i<bullets.length;i++){           //遍历bullets数组
			Bullet b=bullets[i];        //把每个敌人存到f中  为了代码的简洁
			g.drawImage(b.image,b.x,b.y,null);
		}
	}
	public void paintScoreAndLife(Graphics g){       //画分和生命
		g.setFont(new Font(Font.SERIF,Font.BOLD,20));//改变画笔字体
		g.setColor(new Color(0xFF0000));             //改变画笔颜色 (0xFF0000纯红 0x00FF00纯绿 0x0000FF纯蓝)
		g.drawString("SCORE:"+score,10,25);
		g.drawString("LIFE:"+hero.getLife(), 10, 45);
	}
	public void paintState(Graphics g){ //画状态
		switch(state){
			case START:                     //启动状态画启动图
				g.drawImage(start,0,0,null);
				break;
			case PAUSE:                     //暂停状态画暂停图
				g.drawImage(pause,0,0,null);
				break;
			case GAME_OVER:                 //结束状态画结束图
				g.drawImage(gameover,0,0,null);
				break;

		}
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame("Fly"); //创建一个JFrame对象
		ShootGame game=new ShootGame(); //创建一个JPanel对象
		frame.add(game);                //将面板添加到框架上
		frame.setSize(WIDTH,HEIGHT);    //设置窗口大小
		frame.setAlwaysOnTop(true);     //设置总是在最上边
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置默认关闭操作，窗口关闭，程序也关闭
		frame.setLocationRelativeTo(null);  //设置窗体初始位置(居中显示)
		frame.setVisible(true);         //1.设置窗口可见  2.尽快调用paint()

		game.action();                  //启动程序的执行

	}
}