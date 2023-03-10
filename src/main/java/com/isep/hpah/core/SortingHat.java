package com.isep.hpah.core;

import lombok.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

import static com.isep.hpah.core.House.*;


public class SortingHat {

    //creating hashmap based on responses
    @Getter
    private static Map <Integer, House> quesRes;
    static {
        quesRes = new HashMap<>();
        //keys and values = (finalRes as String + House."house">
        quesRes.put(11, House.GRYFFINDOR);
        quesRes.put(12, House.HUFFLEPUFF);
        quesRes.put(21, House.RAVENCLAW);
        quesRes.put(22, House.SLYTHERIN);
    }


    public static House getResHouse(int ind){
        return quesRes.get(ind);
    }

    public static House assignRandomHouse() {
        House[] values = values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
