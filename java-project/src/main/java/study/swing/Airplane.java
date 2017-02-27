package study.swing;

import java.util.Random;
/**敌机---是飞行物，也是敌人*/
public class Airplane extends FlyingObject implements Enemy {
    private int speed=2;           //下落步数
    public Airplane(){             //构造方法
        image=ShootGame.airplane;  //图片-静态块已加载
        width=image.getWidth();    //写活 可扩展性高
        height=image.getHeight();
        Random ra=new Random();
        x=ra.nextInt(ShootGame.WIDTH-this.width);  //屏幕宽到敌机宽之间的随机数
        y=-this.height;            //负的敌机高
    }
    public  int getScore(){        //重写接口抽象方法
        return 5;
    }
    public  void step(){           //重写父类走步方法
        y+=speed;                  //敌机仅仅是向下走  y改变 x不变
    }
    public  boolean outOfBounds(){ //重写父类越界方法
        return this.y>=ShootGame.HEIGHT;  //若敌机的y坐标大于窗口的高 则出界
    }
}