package nio;

import java.net.Socket;

/**
 * Created by SF on 2016/11/23.
 */
public class ConnectIOnHandler extends Thread {
    private Socket socket;
    public ConnectIOnHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()&&! socket.isClosed()){//死循环处理读写事件
//            String someThing = socket.read();    //读取数据
//            if(someThing!=null){
//                //处理数据
//                socket.write();      //写数据
//            }
            break;

        }
    }
}
