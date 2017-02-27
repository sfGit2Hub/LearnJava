package study.swing;

import java.util.Random;
/**小蜜蜂---是飞行物，也是奖励*/
public class Bee extends FlyingObject implements Award {
    private int xSpeed=1;     //x坐标走步步数
    private int ySpeed=2;     //y坐标走步步数
    private int awardType;    //奖励类型
    public Bee(){             //构造方法
        image=ShootGame.bee;  //图片-静态块已加载
        width=image.getWidth();
        height=image.getHeight();
        Random ra=new Random();
        x=ra.nextInt(ShootGame.WIDTH-this.width); //屏幕宽到蜜蜂宽之间的随机数
        y=-this.height;       //负的蜜蜂高
        awardType=ra.nextInt(2);  //奖励类型  0火力,1生命
    }
    public int getType(){     //重写接口抽象方法
        awardType=(int)(Math.random()*2);
        return awardType;
    }
    public  void step(){      //重写父类走步方法
        y+=ySpeed;  //向左或者向右
        x+=xSpeed;  //向下
        if(x>=ShootGame.WIDTH-this.width){
            xSpeed=-1;
        }
        if(x<=0){
            xSpeed=1;
        }
    }
    public  boolean outOfBounds(){
        return this.y>=ShootGame.HEIGHT;  //若蜜蜂的y坐标大于窗口的高 则出界
    }
}