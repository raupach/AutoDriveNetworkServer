package de.autoDrive.NetworkServer.rest.dto_v1;

public class MarkerDto {
    private Integer waypointIndex;
    private String name;
    private String group;

    public Integer getWaypointIndex() {
        return waypointIndex;
    }

    public void setWaypointIndex(Integer waypointIndex) {
        this.waypointIndex = waypointIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
