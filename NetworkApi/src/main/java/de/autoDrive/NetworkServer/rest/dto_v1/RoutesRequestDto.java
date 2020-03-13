package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.List;

public class RoutesRequestDto {

    private String name;
    private String map;
    private Integer revision;
    private String date;
    private String description;
    private String username;
    private List<WaypointDto> waypoints = new ArrayList<>();
    private List<MarkerDto> markers = new ArrayList<>();
    private List<GroupDto> groups = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public List<WaypointDto> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<WaypointDto> waypoints) {
        this.waypoints = waypoints;
    }

    public List<MarkerDto> getMarkers() {
        return markers;
    }

    public void setMarkers(List<MarkerDto> markers) {
        this.markers = markers;
    }

    public List<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
