package com.example.val.pumchat.Common;

import com.example.val.pumchat.Holder.QBUsersHolder;
import com.quickblox.users.model.QBUser;

import java.util.List;

/**
 * Created by Konrad on 2017-06-07.
 */

public class Common {
    public static String createChatDialogName(List<Integer> qbUsers){
        List<QBUser>qbUsers1 = QBUsersHolder.getInstance().getUsersByIds(qbUsers);
        StringBuilder name = new StringBuilder();
        for(QBUser user : qbUsers1)
            name.append(user.getFullName()).append(" ");
        if(name.length() > 30)
            name = name.replace(30, name.length()-1,"...");
        return name.toString();
    }
}
