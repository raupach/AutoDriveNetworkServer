package de.autoDrive.NetworkServer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "route")
public class Route extends BaseEntity {

    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
//    @OrderColumn(name="INDEX_COL")
    private List<Waypoint> waypoints = new ArrayList<>();

    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Marker> markers = new ArrayList<>();

    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Group> groups = new ArrayList<>();

    private String name;
    private String map;
    private Integer revision;
    private Date date;

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

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

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
