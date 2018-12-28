package com.sunny.myframedemo.socket;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sunny.myframedemo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class SocketActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = SocketActivity.class.getSimpleName();

    private Button connect,disconnect;
    private TextView receive_message;
    private Button ceceive;
    private EditText edit;
    private Button send;

    /**
     * 主变量
     */

    //Socket变量
    private Socket socket;
    //线程池
    private ExecutorService mThreadPool;

    /**
     *接收服务器的消息变量
     */
    //输入流
    InputStream inputStream=null;
    //输入流读取器对象
    InputStreamReader inputStreamReader=null;
    BufferedReader bufferedReader;
    //接收服务器过来的消息
    private  String response;

    /**
     * 发送消息到服务器的变量
     */
    //输出流对象
    private OutputStream outputStream;



    //用于将从服务器中获取的消息显示出来
    @SuppressLint("HandlerLeak")
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                    receive_message.setText(response);
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        connect=findViewById(R.id.connect);
        disconnect=findViewById(R.id.disconnect);
        ceceive=findViewById(R.id.Receive);
        edit=findViewById(R.id.edit);
        send=findViewById(R.id.send);
        receive_message=findViewById(R.id.receive_message);
        mThreadPool= Executors.newCachedThreadPool();
        connect.setOnClickListener(this);
        disconnect.setOnClickListener(this);
        ceceive.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           //创建客户端和服务器的连接
           case R.id.connect:
               Logger.d("点击了socket连接");
               //利用线程池开启线程
               mThreadPool.execute(new Runnable() {
                   @Override
                   public void run() {
                       //创建Socket,指定服务器的IP以及端口
                       try {
                           Logger.d("连接客户端");

                               ServerSocket serverSocket=new ServerSocket(3000);
                               socket=serverSocket.accept();
                               Logger.d("Socket="+socket);


                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               });
               break;

           case R.id.disconnect:  //断开连接
               try {
                    //断开 客户端发送到服务器 的连接，即关闭输出流对象OutputStream
                   outputStream.close();
                   // 断开 服务器发送到客户端 的连接，即关闭输入流读取器对象BufferedReader
                   bufferedReader.close();
                   // 最终关闭整个Socket连接
                   socket.close();
                   Logger.d("关闭后socket连接状态"+socket.isConnected());
               } catch (IOException e) {
                   e.printStackTrace();
               }
               break;


           case R.id.Receive:  //接收服务器的消息
                mThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //创建输入流对象
                            inputStream=socket.getInputStream();
                            //创建输入流读取器对象，获取服务器返回的数据
                            inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                            bufferedReader=new BufferedReader(inputStreamReader);
                            //通过buffeReader读取服务器发送过来的数据
                            response=bufferedReader.readLine();
                            //通知主线程将接收到的消息显示在界面
                            Message message=Message.obtain();
                            message.what=0x001;
                            mHandler.sendMessage(message);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
               break;
           case R.id.send: //发送消息给服务器
               mThreadPool.execute(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           //从socket中获取输出流对象 ，发送数据
                            outputStream=socket.getOutputStream();
                            //写入需要发送的数据到输出流对象中
                            outputStream.write((edit.getText().toString()).getBytes("utf-8"));
                            //发送数据到服务器
                           outputStream.flush();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }

                   }
               });
               break;
       }
    }




    /**
     * 计算字符串的MD5值
     *
     * @param string 字符串
     * @return 返回结果
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(string.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                builder.append(temp);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 计算文件的md5值
     *
     * @param file 文件
     * @return 结果
     */
    public static String md5(File file) {
        if (file == null || !file.isFile() || !file.exists()) {
            return "";
        }
        FileInputStream in = null;
        String result = "";
        byte buffer[] = new byte[8192];
        int len;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            byte[] bytes = md5.digest();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * AES加密
     *
     * @param key
     * @param src
     * @return
     */
    private static String encrypt(String key, String src) throws Exception {
        byte[] rawKey = toMakeKey(key, 16, "0").getBytes();
        byte[] result = encrypt(rawKey, src.getBytes("utf-8"));
        return toHex(result);
    }

    /**
     * 真正的加密过程
     * 1.通过密钥得到一个密钥专用的对象SecretKeySpec
     * 2.Cipher 加密算法，加密模式和填充方式三部分或指定加密算 (可以只用写算法然后用默认的其他方式)Cipher.getInstance("AES");
     *
     * @param key
     * @param src
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] key, byte[] src) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        byte[] encrypted = cipher.doFinal(src);
        return encrypted;
    }


    /**
     * 秘钥key,默认补的数字，补全16位数，以保证安全补全至少16位长度，Android和iso对接通过
     *
     * @param str
     * @param strLength
     * @param val
     * @return
     */
    private static String toMakeKey(String str, int strLength, String val) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str).append(val);
                str = stringBuffer.toString();
                strLen = str.length();
            }
        }
        return str;
    }


    public static String toHex(byte[] buff) {
        if (buff == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(2 * buff.length);
        for (int i = 0; i < result.length(); i++) {
            appendHex(result, buff[i]);
        }
        return result.toString();
    }


    private final static String HEX = "0123456789ABCDEF";

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }

}
