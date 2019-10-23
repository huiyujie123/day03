package cn.johnyu.day03;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Integer> tels=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTels() {
        return tels;
    }

    public void setTels(List<Integer> tels) {
        this.tels = tels;
    }
}
