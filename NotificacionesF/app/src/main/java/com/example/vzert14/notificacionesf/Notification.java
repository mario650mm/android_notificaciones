package com.example.vzert14.notificacionesf;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class Notification {
    public String uid;
    public String titulo;
    public String cuerpo;

    public Notification(){

    }

    public Notification(String titulo,String cuerpo){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("uid",uid);
        result.put("titulo",titulo);
        result.put("cuerpo",cuerpo);
        return result;
    }
}
