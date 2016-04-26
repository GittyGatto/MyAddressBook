package rene;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket;
        while( (socket= serverSocket.accept()) != null ) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null && !line.equals("")) {
                System.out.println(line);
            }

            Writer wr = new OutputStreamWriter(socket.getOutputStream());
            wr.write("HTTP/1.0 200 OK");
            wr.write("Content-Type: text/html\n");
            wr.write("\n");
            wr.write("<h1>Huhu</h1>" + new Date());
            wr.flush();
            socket.close();
        }
    }
}
