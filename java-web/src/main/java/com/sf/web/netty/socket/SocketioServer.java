package com.sf.web.netty.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by SF on 2017/5/16.
 */
public class SocketioServer implements Runnable {
    //    Server Configuration
    private static Configuration config = null;
    //server已配置标识
    private static boolean confFlag = false;
    //server已启动标识
    private static boolean serverFlag = false;
    //server
    private static SocketIOServer server = null;
    //客户端暂存
    private static Map<String, SocketIOClient> clientCache = new HashMap<>();
    //用户客户端关系暂存
//    private static Map<UUID, String> userClientCache = new HashMap<>();

    @Override
    public void run() {
        while (true) {
            if (!serverFlag) {
                this.getConfig();
                server = new SocketIOServer(config);
                this.startServer();
            }
        }
    }

    //生成配置容器
    private void getConfig() {
        if (!confFlag) {
            config = new Configuration();
            try {
                String hostName = "127.0.0.1";
                String port = "9999";
                if (hostName != null && hostName.length() > 0
                        && port != null && port.length() > 0) {
                    config.setHostname(hostName);
                    config.setPort(Integer.parseInt(port));
                    confFlag = true;
                }
            } catch (Exception e) {
                System.out.println("获取配置信息出错！");
                e.printStackTrace();
            }
        }
    }

    private void startServer() {
        if (!serverFlag) {
            this.getConfig();
            server.start();
            serverFlag = true;

            server.addConnectListener(client -> {
                System.out.println("client is connect:" + client.getSessionId());
            });

            server.addDisconnectListener(client -> {
                System.out.println("client is disconnect:" + client.getSessionId());
            });

            server.addEventListener("testEvent", EventMessage.class, (client, eventMessage, ackRequest) -> {
                String userId = eventMessage.getUserId();
                if (userId != null && userId.length() > 0) {
                    //由于一个客户端是外部轮询的，所以一直在变化
                    //在客户端缓存中清除原有属于该userId的客户端
                    clientCache.remove(userId);
                    //增加新的客户端
                    clientCache.put(userId, client);

                    client.sendEvent("event message!", eventMessage);

                    System.out.println("成功注册！userId:" + userId);
                }
            });
        }
    }

    @SuppressWarnings("unused")
    private void stopServer() {
        if (serverFlag) {
            server.stop();
            serverFlag = false;
        }
    }

}
