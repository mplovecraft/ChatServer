package com.company;
import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.io.*;

public class SaveToFile implements Serializable {

    public void SerializeToFile(ChatRoomList chatRoomList) {
        File Chats = new File("user.dir");
        if (!Chats.exists()) {
            new File("Chats/").mkdirs();
        }
        for (ChatRoom chatroom : chatRoomList.getChatRooms().values() ) {
            try {
                FileOutputStream fileOut = new FileOutputStream("Chats/" + chatroom.getName());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(chatroom);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }

    }
}

