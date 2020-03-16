package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.List;

public class WaypointsResponseDto {
    private List<WaypointDto> waypoints = new ArrayList<>();


    public List<WaypointDto> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<WaypointDto> waypoints) {
        this.waypoints = waypoints;
    }
}
