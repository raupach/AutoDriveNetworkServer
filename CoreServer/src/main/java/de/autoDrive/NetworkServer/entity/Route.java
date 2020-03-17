package de.autoDrive.NetworkServer.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "route")
public class Route extends BaseEntity {

    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Waypoint> waypoints = new ArrayList<>();

    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Group> groups = new ArrayList<>();

    private String name;
    private String map;
    private Integer revision;
    private ZonedDateTime date;
    private String description;
    private String username;
    private ZonedDateTime uploaded;
    private ZonedDateTime updated;

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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
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

    public ZonedDateTime getUploaded() {
        return uploaded;
    }

    public void setUploaded(ZonedDateTime uploaded) {
        this.uploaded = uploaded;
    }

    public ZonedDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(ZonedDateTime updated) {
        this.updated = updated;
    }
}
