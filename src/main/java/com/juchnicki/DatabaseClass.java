package com.juchnicki;

import com.juchnicki.model.Message;
import com.juchnicki.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rafal on 2016-12-04.
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages(){
        return messages;
    }

    public static Map<String, Profile> getProfiles(){
        return profiles;
    }
}
