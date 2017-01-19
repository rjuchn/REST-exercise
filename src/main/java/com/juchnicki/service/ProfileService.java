package com.juchnicki.service;

import com.juchnicki.DatabaseClass;
import com.juchnicki.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Rafal on 2016-12-04.
 */
public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Rafal", new Profile(1L, "Rafal Juchnicki", "Rafal", "Juchnicki"));
    }

    public List<Profile> getProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        return profiles.put(profile.getProfileName(), profile);
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        return profiles.put(profile.getProfileName(), profile);
    }
    public void removeProfile(String profileName){
        profiles.remove(profileName);
    }
}
