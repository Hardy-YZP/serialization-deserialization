package com.yzp.socket;

import com.yzp.dto.UserDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerProvider {
    public static void main(String[] args) throws
            IOException {
        ServerSocket serverSocket = null;
        BufferedReader in = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream =
                    new
                            ObjectInputStream(socket.getInputStream());
            UserDTO user = (UserDTO) objectInputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}