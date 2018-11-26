package util;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server extends Thread {

    private Serializable source;

    private static final String HOST = "224.0.0.2";//ConfigurationManager.getInstance().getProperty("server.host", "127.0.0.1");
    private static final Integer PORT = 12345; //Integer.parseInt(ConfigurationManager.getInstance().getProperty("server.port", "5555"));

    public Server() {
        setDaemon(true);
    }

    public void send(Serializable source) {
        this.source = source;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);

                if (source != null) {
                    byte[] b = Serializer.serialize(source);

                    InetAddress addr = InetAddress.getByName(HOST);

                    DatagramSocket ds = new DatagramSocket();

                    DatagramPacket pkg = new DatagramPacket(b, b.length, addr, PORT);

                    ds.send(pkg);

                    source = null;
                }
            } catch (InterruptedException | IOException e) {
                System.out.println(e);
            }
        }
    }

}
