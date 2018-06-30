package com.dyz.gameserver.net.WebServer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private static WebServer _server = new WebServer();
	
	ServerSocket serverSocket = null;
	
	public static void init()
	{
		
        try {
        	_server.serverSocket = new ServerSocket(1201);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = _server.serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // 创建Request对象并解析
                Request request = new Request(input);
                request.parse();
                // 检查是否是关闭服务命令
//                if (request.getUri().equals(SHUTDOWN_COMMAND)) {
//                    break;
//                }

                // 创建 Response 对象
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                // 关闭 socket 对象
                socket.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
}
