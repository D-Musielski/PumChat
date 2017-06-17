package com.example.val.pumchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.library.bubbleview.BubbleTextView;
import com.quickblox.chat.QBChatService;
import com.quickblox.chat.model.QBChatMessage;

import java.util.ArrayList;

/**
 * Created by Val on 2017-06-17.
 */

public class ChatMessageAdapter extends BaseAdapter{

    private ArrayList<QBChatMessage> qbChatMessages;
    private Context context;

    public ChatMessageAdapter(ArrayList<QBChatMessage> qbChatMessages, Context context) {
        this.qbChatMessages = qbChatMessages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return qbChatMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return qbChatMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(qbChatMessages.get(position).getSenderId().equals(QBChatService.getInstance().getUser().getId())){
                view = inflater.inflate(R.layout.send_message, null);
                BubbleTextView bubbleTextView = (BubbleTextView)view.findViewById(R.id.message);
                bubbleTextView.setText(qbChatMessages.get(position).getBody());
            }
            else {
                view = inflater.inflate(R.layout.receive_message, null);
                BubbleTextView bubbleTextView = (BubbleTextView)view.findViewById(R.id.message);
                bubbleTextView.setText(qbChatMessages.get(position).getBody());
                TextView usernameTextView =  (TextView)view.findViewById(R.id.msg_username);
                usernameTextView.setText(QBUsersHolder.getInstance().getUserById(qbChatMessages.get(position).getSenderId()).getLogin());
            }
        }

        return view;
    }
}
