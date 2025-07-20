package ru.java.rtk;
public class TV {
    private String model;
    private int diagonal;
    private int cost;
    private int channel;
    private int volume;

    public TV(String model, int diagonal, int cost) {
        this.model = model;
        this.diagonal = diagonal;
        this.cost = cost;
        this.channel = 1;
        this.volume = 20;
    }
    public void changeChannel(int newChannel) { 
        this.channel = newChannel;
    }

    public void changeVolume(int newVolume) { 
        this.volume = newVolume;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getDiagonal() {
        return diagonal;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getChannel() {
        return channel;
    }
    
    public int getVolume() {
        return volume;
    }
}