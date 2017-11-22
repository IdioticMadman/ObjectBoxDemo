package com.robert.objectboxdemo.bean;

/**
 * @author: robert
 * @date: 2017-11-22
 * @time: 16:32
 * @说明:
 */

public class LotteryBallItem {
    public String name;
    public String color;

    public LotteryBallItem() {
    }

    public LotteryBallItem(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "LotteryBallItem{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
