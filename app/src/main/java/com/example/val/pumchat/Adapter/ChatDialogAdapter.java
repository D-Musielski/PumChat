package com.example.val.pumchat.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.val.pumchat.R;
import com.quickblox.chat.model.QBChatDialog;

import java.util.ArrayList;

/**
 * Created by Konrad on 2017-06-06.
 */

public class ChatDialogAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<QBChatDialog> qbChatDialogs;

    public ChatDialogAdapter(Context context, ArrayList<QBChatDialog> qbChatDialogs){
        this.context = context;
        this.qbChatDialogs = qbChatDialogs;
    }

    @Override
    public int getCount() {
        return qbChatDialogs.size();
    }

    @Override
    public Object getItem(int i) {
        return qbChatDialogs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vieww = view;
        if (vieww == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vieww = inflater.inflate(R.layout.list_chat_dialog, null);

            TextView textTitle;
            TextView textMessage;

            ImageView imageView;

            textTitle = (TextView)vieww.findViewById(R.id.dialogTitle);
            textMessage = (TextView)vieww.findViewById(R.id.dialogMessage);
            imageView = (ImageView)vieww.findViewById(R.id.dialogImage);

            textMessage.setText(qbChatDialogs.get(i).getLastMessage());
            textTitle.setText((qbChatDialogs.get(i).getName()));

            TextDrawable.IBuilder builder = TextDrawable.builder().beginConfig()
                    .withBorder(4)
                    .endConfig()
                    .round();

            TextDrawable drawable = builder.build(textTitle.getText().toString().substring(0,1).toUpperCase(), Color.rgb(63, 81, 181));

            imageView.setImageDrawable(drawable);

        }
        return vieww;
    }
}
