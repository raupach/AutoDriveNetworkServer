package de.autoDrive.NetworkServer.rest.dto_v1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoutesRequestDto {

    private String name;
    private String map;
    private Integer revision;
    private Date date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
