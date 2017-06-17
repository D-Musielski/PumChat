package com.example.val.pumchat;

import com.quickblox.chat.model.QBChatMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Val on 2017-06-17.
 */

public class QBChatMessagesHolder {

    private static QBChatMessagesHolder instance;
    private HashMap<String,ArrayList<QBChatMessage>> qbChatMessageMap;

    private QBChatMessagesHolder() {
        this.qbChatMessageMap = new HashMap<>();
    }

    public static synchronized QBChatMessagesHolder getInstance() {
        QBChatMessagesHolder qbChatMessagesHolder;
        synchronized (QBChatMessagesHolder.class) {
            if (instance == null) {
                instance = new QBChatMessagesHolder();
            }
            qbChatMessagesHolder = instance;
        }
        return qbChatMessagesHolder;
    }

    public void putMessages(String dialogId, ArrayList<QBChatMessage> qbChatMessages){
        this.qbChatMessageMap.put(dialogId, qbChatMessages);
    }

    public void putMessage(String dialogId, QBChatMessage qbChatMessage){
        List<QBChatMessage> messageList = (List) this.qbChatMessageMap.get(dialogId);
        messageList.add(qbChatMessage);
        ArrayList<QBChatMessage> allMessageList = new ArrayList<>(messageList.size());
        allMessageList.addAll(messageList);
        putMessages(dialogId, allMessageList);
    }

    public ArrayList<QBChatMessage> getMessages (String dialogId) {
        return (ArrayList<QBChatMessage>) this.qbChatMessageMap.get(dialogId);
    }
}
