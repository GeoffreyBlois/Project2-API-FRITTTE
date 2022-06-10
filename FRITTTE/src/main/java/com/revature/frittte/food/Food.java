package com.revature.frittte.food;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "food")
public class Food {
    @Id
    private int id;
    @Column(name = "item_name", length = 50, nullable = false)
    private String item_name;
    @Column(name = "cost_t")
    private int cost;
    private int weight;

    private boolean volume;

    private boolean frozen;

    public int getId() {
        return id;

    }

    public Food(int id, String item_name, int cost, int weight, boolean volume, boolean frozen) {
        this.id = id;
        this.item_name = item_name;
        this.cost = cost;
        this.weight = weight;
        this.volume = volume;
        this.frozen = frozen;
    }

    public Food() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isVolume() {
        return volume;
    }

    public void setVolume(boolean volume) {
        this.volume = volume;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", liquid=" + volume +
                ", frozen=" + frozen +
                '}';
    }
}



