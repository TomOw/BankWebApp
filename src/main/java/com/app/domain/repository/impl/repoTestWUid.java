package com.app.domain.repository.impl;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Tomasz on 04.04.2016.
 */
public class repoTestWUid {

    public static void main(String[] args) throws IOException{
        JsonClientRepository jsonClientRepository = new JsonClientRepository();
        ObjectMapper mapper = new ObjectMapper();
        jsonClientRepository.readFromFile();
        int i =0;
    }
}
