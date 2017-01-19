package com.juchnicki.service;

import com.juchnicki.DatabaseClass;
import com.juchnicki.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Rafal on 2016-12-04.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello World", "juchnicr"));
        messages.put(2L, new Message(2, "Hello Jersey", "juchnicr"));
    }
    public List<Message> getAllMessages(){
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public void removeMessage(long id){
        messages.remove(id);
    }

    public List<Message> getAllMessagessForYear(int year){
        List<Message> messageList = new ArrayList<Message>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year){
                messageList.add(message);
            }
        }

        return messageList;
    }

    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        return list.subList(start, size);
    }

}
