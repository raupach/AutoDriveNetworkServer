package de.autoDrive.NetworkServer.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;


@NodeEntity
public class Waypoint  {

    @Id
    @GeneratedValue
    private Long id;

    private Route route;

    @Relationship(type = "OUTGOING", direction = Relationship.UNDIRECTED)
    private Set<Waypoint> outgoing = new HashSet<>();

    @Relationship(type = "INCOMING", direction = Relationship.UNDIRECTED)
    private Set<Waypoint> incoming= new HashSet<>();

    private Group group;

    private String markerName;

    private Double x;
    private Double y;
    private Double z;


    public Set<Waypoint> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Set<Waypoint> outgoing) {
        this.outgoing = outgoing;
    }

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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Set<Waypoint> getIncoming() {
        return incoming;
    }

    public void setIncoming(Set<Waypoint> incoming) {
        this.incoming = incoming;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getMarkerName() {
        return markerName;
    }

    public void setMarkerName(String markerName) {
        this.markerName = markerName;
    }
}
