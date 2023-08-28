package com.kleberaluizio.cepsearchengine.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class AddressJsonCreator {

    public static void create(Address address){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            FileWriter writer = new FileWriter(address.cep()+".json");
            writer.write(gson.toJson(address));
            writer.close();
        }catch (IOException e){

        }
    }
}
