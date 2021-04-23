package com.danyfang.socketproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.danyfang.socketproject.utils.MyUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TCPClientActivity extends AppCompatActivity {

    private static final int MESSAGE_RECEIVE_NEW_MSG = 1;
    private static final int MESSAGE_SOCKET_CONNECTED = 2;

    private Button mSendButton;
    private TextView mMessageTextView;
    private EditText mMessageEditText;


    private PrintWriter mPrintWriter;
    private Socket mClientSocket;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MESSAGE_RECEIVE_NEW_MSG: {
                    mMessageTextView.setText(mMessageTextView.getText() + (String) msg.obj);
                    break;
                }
                case MESSAGE_SOCKET_CONNECTED: {
                    mSendButton.setEnabled(true);
                    break;
                }

                default:
                    break;
            }
        }
    };

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcpclient);

        mMessageTextView = findViewById(R.id.msg_container);
        mMessageEditText = findViewById(R.id.msg);
        mSendButton = findViewById(R.id.send);
        mSendButton.setOnClickListener(v -> {
            new Thread(() -> {
                final String msg = mMessageEditText.getText().toString();

                if (!TextUtils.isEmpty(msg) && mPrintWriter != null) {
                    mPrintWriter.println(msg);
                    mMessageEditText.post(() -> mMessageEditText.setText(""));
                    String time = formatDateTime(System.currentTimeMillis());
                    final String showedMsg = "self " + time + ":" + msg + "\n";

                    mMessageTextView.post(() -> mMessageTextView.setText(mMessageTextView.getText() + showedMsg));
                }
            }).start();
        });

        Intent intent = new Intent(this, TCPServerService.class);
        startService(intent);

        new Thread(this::connectTCPServer).start();
    }

    @Override
    protected void onDestroy() {
        if (mClientSocket != null) {
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    private String formatDateTime(long time) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(time));
    }


    private void connectTCPServer() {
        Socket socket = null;
        while (socket == null) {
            try {
                socket = new Socket("localhost", 8688);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                mHandler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
                System.out.println("Succeed connecting server");
            } catch (IOException e) {
                SystemClock.sleep(1000);
                System.out.println("Failed connecting tcp server, retrying...");
            }
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!TCPClientActivity.this.isFinishing()) {
                String msg = br.readLine();
                System.out.println("receive : " + msg);

                if (msg != null) {
                    String time = formatDateTime(System.currentTimeMillis());
                    final String showedMsg = "server " + time + ":" + msg + "\n";
                    mHandler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showedMsg).sendToTarget();
                }
            }

            System.out.println("quitting...");
            MyUtils.close(mPrintWriter);
            MyUtils.close(br);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}