package design.pattern.decorator;

import java.io.*;

/**
 * Created by Administrator on 2019/6/25.
 * Java 内部流处理类都是装饰器模式实现
 * 通过类似如下的方式初始化，然后可以方法嵌套调用
 *
 * 实现FilterInputStream抽象类，所有InputStream的抽象类
 */
public class LowerCaseInputStream extends FilterInputStream {
    //此处用来初始化，装饰器必须要传入需要装饰的对象
    public LowerCaseInputStream(InputStream inputStream){
        super(inputStream);
    }

    @Override
    public int read() throws IOException {
        int inputChar =  super.read();
        return inputChar == -1 ? inputChar : Character.toLowerCase((char) inputChar);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int result = super.read(b);
        for (int i = 0; i < result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b,off,len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase(b[i]);
        }
        return  result;
    }
}
