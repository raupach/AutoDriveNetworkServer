package de.autoDrive.NetworkServer.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Cache(region = "waypointCache", usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "waypoint")
public class Waypoint extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_ID")
    private Route route;

    @Cache(region = "waypointOutgoingCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="waypoint_to_waypoint",
            joinColumns=@JoinColumn(name="outgoing_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="incoming_ID", referencedColumnName="ID"))
    private Set<Waypoint> outgoing = new HashSet<>();

    @Cache(region = "waypointIncomingCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(mappedBy = "outgoing", fetch = FetchType.LAZY)
    private Set<Waypoint> incoming= new HashSet<>();

    @Cache(region = "waypointGroupCache",usage = CacheConcurrencyStrategy.READ_WRITE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_ID")
    private Group group;

    @Column(name = "marker_name")
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
