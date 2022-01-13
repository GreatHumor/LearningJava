package com.gh.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sso team
 * @description
 * @date 2021/10/23 7:07 下午
 */
@Slf4j
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            log.info("The timeserver is start on port:{}", port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
