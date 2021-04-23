package com.danyfang.socketproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.danyfang.socketproject.utils.MyUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerService extends Service {

    private boolean mIsServiceDestroyed = false;

    private String[] mDefinedMessages = new String[] {
        "Hello, Suyi.",
        "I love you!" ,
        "How you doing?",
        "The weather is really good today."
    };

    @Override
    public void onCreate() {
        new Thread(new TcpServer()).start();
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mIsServiceDestroyed = true;
        super.onDestroy();
    }

    private class TcpServer implements Runnable {
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8688);
            } catch (IOException e) {
                System.err.println("Failed connecting to server, port: 8688");
                e.printStackTrace();
                return;
            }

            while (!mIsServiceDestroyed) {
                try {
                    final Socket client = serverSocket.accept();
                    System.out.println("accept");

                    new Thread(() -> {
                        try {
                            responseClient(client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void responseClient(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);

        out.print("Welcome to chat room\n");

        while (!mIsServiceDestroyed) {
            String str = in.readLine();
            System.out.println("msg from client:" + str);

            if (str == null) {
                break;
            }

            int i = new Random().nextInt(mDefinedMessages.length);

            String msg = mDefinedMessages[i];

            out.println(msg);
            System.out.println("Send : " + msg);
        }

        System.out.println("client quits");

        MyUtils.close(out);
        MyUtils.close(in);
        client.close();
    }
}