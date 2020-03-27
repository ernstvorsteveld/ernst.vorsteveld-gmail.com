package com.vorstdev.freemarker;

public final class User {

    private String first;
    private String middle;
    private String last;

    public User(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }
}
