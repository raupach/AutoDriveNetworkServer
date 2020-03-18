package de.autoDrive.NetworkServer.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cache(region = "groupCache", usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ad_group")
public class Group extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_ID")
    private Route route;

    @Cache(region = "groupWaypointsCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "group", fetch= FetchType.LAZY)
    private List<Waypoint> waypoints = new ArrayList<>();

    private String name;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }
}
