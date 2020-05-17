package de.autoDrive.NetworkServer.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "HAS_WAYPOINTS", direction = Relationship.UNDIRECTED)
    private List<Waypoint> waypoints = new ArrayList<>();

    @Relationship(type = "HAS_GROUPS", direction = Relationship.UNDIRECTED)
    private List<Group> groups = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_ID")
    private User user;

    private String name;
    private String map;
    private Integer revision;
//    private ZonedDateTime date;
    private String description;
//    private ZonedDateTime uploaded;
//    private ZonedDateTime updated;

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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
