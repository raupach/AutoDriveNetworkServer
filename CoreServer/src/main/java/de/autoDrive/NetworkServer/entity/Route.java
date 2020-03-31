package de.autoDrive.NetworkServer.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "route")
@Cacheable
@Cache(region = "routeCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Route extends BaseEntity {

    @Cache(region = "routeWaypointsCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Waypoint> waypoints = new ArrayList<>();

    @Cache(region = "routeGroupsCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "route", fetch= FetchType.LAZY)
    private List<Group> groups = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private User user;

    private String name;
    private String map;
    private Integer revision;
    private ZonedDateTime date;
    private String description;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
