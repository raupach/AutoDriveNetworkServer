package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.List;

public class WaypointDto {
    private Double x;
    private Double y;
    private Double z;
    private List<Integer> out = new ArrayList<>();

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public List<Integer> getOut() {
        return out;
    }

    public void setOut(List<Integer> out) {
        this.out = out;
    }
}
