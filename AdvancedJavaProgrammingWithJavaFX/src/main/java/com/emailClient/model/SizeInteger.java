package com.emailClient.model;

public class SizeInteger implements Comparable<SizeInteger>{

    private int size;

    public SizeInteger(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(SizeInteger o) {
        return Integer.compare(size, o.size);
    }

    @Override
    public String toString() {
        if (size <=0) {
            return "0";
        } else if (size < 1024) {
            return size + " B";
        } else if (size < 1048576) {
            return size / 4 + " KB";
        } else {
            return size / 1048576 + " MB";
        }
    }
}
