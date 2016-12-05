package xcarpaccio;

import net.codestory.http.WebServer;

public class MyFluentHttpServer {

    public MyFluentHttpServer() {
        this(9001);
    }

    public MyFluentHttpServer(int port) {
        new WebServer().configure(new WebConfiguration()).start(port);
    }

    public static void main( String[] args ) {
        new MyFluentHttpServer();
    }
}
