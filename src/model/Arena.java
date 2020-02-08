package model;

import javax.swing.*;
import java.util.ArrayList;

public class Arena {
    private Player player;
    private Plane plane;
    private final ArrayList<PlaneDrop> planeDrops;

    public Arena(Player player, Plane plane){
        this.player = player;
        this.plane = plane;
        this.planeDrops = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public ArrayList<PlaneDrop> getPlaneDrops() {
        return planeDrops;
    }
}
