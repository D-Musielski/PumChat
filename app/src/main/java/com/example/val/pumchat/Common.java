package com.example.val.pumchat;

import com.quickblox.users.model.QBUser;

import java.util.List;

/**
 * Created by Val on 2017-06-17.
 */

public class Common {

    public static final String DIALOG_EXTRA = "Dialog";

    public static String createChatDialogName(List<Integer> qbUsers){
        List<QBUser>qbUsers1 = QBUsersHolder.getInstance().getUsersByIds(qbUsers);
        StringBuilder name = new StringBuilder();
        for(QBUser user : qbUsers1)
            name.append(user.getLogin()).append(" ");
        if(name.length() > 30)
            name = name.replace(30, name.length()-1,"...");
        return name.toString();
    }
}
