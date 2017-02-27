package study.swing;

import java.awt.image.BufferedImage;
import java.util.Random;
/**英雄机---是飞行物*/
public class Hero extends FlyingObject {
    private int life;               //生命
    private int doubleFire;         //火力值
    private BufferedImage[] images; //图片切换数
    private int index;              //协助切换图片
    public Hero(){                  //构造方法
        image=ShootGame.hero0;      //图片-静态块已加载
        width=image.getWidth();
        height=image.getHeight();
        x=150;         //x坐标固定
        y=400;         //y坐标固定
        life=3;        //命数为3
        doubleFire=0;  //火力值为0(单倍火力)
        images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};//两张图片切换键
        index=0;       //协助图片切换
    }
    public void step(){        //重写父类走步方法
        /**
         * index++;
         * int a=index/10;
         * int b=a%2;
         * image=images[b];
         */
        image=images[index++/10%images.length];//每100毫秒切换一次图片
    }
    public Bullet[] shoot(){   //发射子弹
        int xStep=this.width/4;
        int yStep=20;
        if(doubleFire>0){      //双倍火力
            Bullet[] bs=new Bullet[2];                     //双倍火力有俩个火力发射点
            bs[0]=new Bullet(this.x+xStep*1,this.y-yStep); //双倍火力的第一发子弹发出位置
            bs[1]=new Bullet(this.x+xStep*3,this.y-yStep); //双倍火力的第二发子弹发出位置
            doubleFire-=2;     //发射一次双倍火力，火力值-2(每个双倍火力可持续发20次)
            return bs;
        }else{                 //单倍火力
            Bullet[] bs=new Bullet[1];
            bs[0]=new Bullet(this.x+xStep*2,this.y-yStep); //单倍火力的子弹发出位置
            return bs;
        }
    }
    public void moveTo(int x,int y){  //英雄机随着鼠标移动
        this.x=x-this.width/2;
        this.y=y-this.height/2;
    }
    public  boolean outOfBounds(){    //英雄机永不越界
        return false;
    }
    public void addLife(){         //生命+1
        life++;
    }
    public int getLife(){          //获取生命数
        return life;
    }
    public void subtractLife(){    //英雄机命数-1
        life--;
    }
    public void addDoubleFir(){    //火力值增40
        doubleFire+=40;
    }
    public void clearDoubleFire(){ //清火力(火力归零)
        doubleFire=0;
    }
    public boolean hit(FlyingObject other){  //英雄机和敌人的碰撞 this英雄机  other敌人
        int x1=other.x-this.width/2;         //敌人的x-英雄机宽的一半
        int x2=other.x+other.width+this.width/2;   //敌人的x+敌人的宽+英雄机宽的一半
        int y1=other.y-this.height/2;        //敌人的y-英雄机高的一半
        int y2=other.y+other.height+this.height/2; //敌人的y+敌人的高+英雄机高的一半
        int x=this.x+this.width/2;   //中心点x坐标  英雄机的x+英雄机宽的一半
        int y=this.y+this.height/2;  //中心点y坐标 英雄机的y+英雄机高的一半
        return x>x1&&x<x2&&y>y1&&y<y2;
    }
}