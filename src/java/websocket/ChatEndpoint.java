/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Petko
 */
@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static List<Session> connections = new ArrayList();

    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            for (Session session1 : connections) {
                session1.getBasicRemote().sendText(session.getUserPrincipal().getName() + ": " + message);
            }
        } catch (IOException e) {

        }
    }

    @OnClose
    public void onClose(Session ses) {
        connections.remove(ses);
    }

    @OnOpen
    public void onOpen(Session ses) {
        connections.add(ses);

    }

}
