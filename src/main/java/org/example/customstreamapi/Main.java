package org.example.customstreamapi;

import org.example.customstreamapi.customfilter.CustomFilter;
import org.example.customstreamapi.model.Gender;
import org.example.customstreamapi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }
        List<String> res = new CustomFilter<String>().paginate(list,5,5,6);
        for (String result : res) {
            System.out.println(result);
        }
    }
}
