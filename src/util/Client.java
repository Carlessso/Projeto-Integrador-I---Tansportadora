package util;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public abstract class Client
        extends
        Thread {

    private static final String HOST = "224.0.0.2";//ConfigurationManager.getInstance().getProperty("server.host", "127.0.0.1");
    private static final Integer PORT = 12345; //Integer.parseInt(ConfigurationManager.getInstance().getProperty("server.port", "5555"));

    public Client() {
        setDaemon(true);
    }

    public void send(Serializable source) throws Exception {
        if (source != null) {
            byte[] b = Serializer.serialize(source);

            InetAddress addr = InetAddress.getByName(HOST);

            DatagramSocket ds = new DatagramSocket();

            DatagramPacket pkg = new DatagramPacket(b, b.length, addr, PORT);

            ds.send(pkg);
        }
    }

    public abstract void onRecive(Object data) throws Exception;

    @Override
    public void run() {
        MulticastSocket socket = null;

        try {
            // determina endereco e porta
            InetAddress grupo = InetAddress.getByName(HOST);

            // cria multicast socket e se une ao grupo
            socket = new MulticastSocket(PORT);

            socket.joinGroup(grupo);
        } catch (IOException e) {

        }

        try {
            while (true) {
                // prepara buffer (vazio)
                byte[] buf = new byte[256];

                // prepara pacote para resposta
                DatagramPacket pacote = new DatagramPacket(buf, buf.length);

                // recebe pacote
                socket.receive(pacote);

                onRecive(Serializer.deserialize(pacote.getData()));
            }
        } catch (Exception ex) {

        }

        // fecha socket
        socket.close();
    }
}
