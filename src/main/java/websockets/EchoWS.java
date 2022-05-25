package websockets;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;

@ServerEndpoint("/ws")
public class EchoWS {

    static ArrayList<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session){
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String msg, Session session) throws IOException {
        for(Session s : sessions){
            s.getBasicRemote().sendText(msg);
        }
    }
    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }

}
