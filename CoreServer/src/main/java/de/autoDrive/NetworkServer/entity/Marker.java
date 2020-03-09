package de.autoDrive.NetworkServer.entity;

import javax.persistence.*;

@Entity
@Table(name = "marker")
public class Marker extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_ID")
    private Route route;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="waypoint_id")
    private Waypoint waypoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_ID")
    private Group group;

    private String name;


    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Waypoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
