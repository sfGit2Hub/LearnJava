package study.swing;

import java.awt.image.BufferedImage;
/**飞行物父类*/
public abstract class FlyingObject {
    protected BufferedImage image;
    protected int width;   //宽
    protected int height;  //高
    protected int x;       //x坐标
    protected int y;       //y坐标
    public abstract void step();            //走步 10毫秒一次
    public abstract boolean outOfBounds();  //检查飞行物是否出界
    public boolean shootBy(Bullet bullet){  //检查当前敌人是否被子弹击中
        int x1=this.x;   //x1:敌人的X
        int x2=this.x+this.width;           //y1:敌人的x+敌人的宽
        int y1=this.y;   //敌人的宽
        int y2=this.y+this.height;          //敌人的y+敌人的高
        int x=bullet.x;    //子弹的x
        int y=bullet.y;    //子弹的y
        return x>x1&&x<x2&&y>y1&&y<y2;      //x在x1和x2之间并且y在y1和y2之间，就是子弹击中敌人
    }
}