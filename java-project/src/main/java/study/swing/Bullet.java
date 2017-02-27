package study.swing;

/**子弹---是飞行物*/
public class Bullet extends FlyingObject {
    private int speed=3;          //走的步数
    public Bullet(int x,int y){   //构造方法
        image=ShootGame.bullet;   //图片-静态块已加载
        width=image.getWidth();
        height=image.getHeight();
        this.x=x;   //与英雄机有关
        this.y=y;
    }
    public  void step(){            //重写父类走步方法
        y-=speed;  //y- 向上走 x
    }
    public  boolean outOfBounds(){  //判断子弹是否越界
        return this.y<=-this.height;
    }
}