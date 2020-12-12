package ru.geekbrains.java.part2.lesson6.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

    public static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Waiting for new connection...");
            Socket clientSocket1 = serverSocket.accept();
            System.out.println("Client has been connected!");
            Socket clientSocket = clientSocket1;

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                sendServerMessages(out);
                //sendEchoMessages(in, out); // почему-то падает с ошибкой при использовании данного метода. Возможно ли
                // здесь использовать 2 потока: один для обработки эхо-сообщений, второй для обработки и отсылки сообщений
                // из серверной консоли? Нельзя использовать один DataOutputStream на всех, потому что он потоконебезопасный?
                String message = in.readUTF();
                System.out.println("Client message: " + message);
                if (message.equals("/end")) {
                    break;
                }
                out.writeUTF("Echo: " + message);
            }
        } catch (SocketException e) {
            System.err.println("Server port is already opened!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Connection has been closed!");
            e.printStackTrace();
        }
    }

    public static void sendEchoMessages(DataInputStream in, DataOutputStream out) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println("Client message: " + message);
                        if (message.equals("/end")) {
                            break;
                        }
                        out.writeUTF("Echo: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Connection was lost!");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void sendServerMessages(DataOutputStream out) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = getUserMsgFromConsole();
                        out.writeUTF("Server user message: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Connection was lost!");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private static String getUserMsgFromConsole() {
        String msg = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            msg = reader.readLine();
        } catch (IOException e) {
            System.err.println("Read error from the console!");
            e.printStackTrace();
        }
        return msg;
    }
}
