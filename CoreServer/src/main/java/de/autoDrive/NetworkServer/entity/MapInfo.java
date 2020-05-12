package de.autoDrive.NetworkServer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "map_info")
public class MapInfo extends BaseEntity {


    @OneToMany(mappedBy = "mapInfo", fetch= FetchType.LAZY)
    private List<MapTileData> mapTileData = new ArrayList<>();

    private String name;

    @Column(name = "resolution_x")
    private Integer resolutionX;

    @Column(name = "resolution_y")
    private Integer resolutionY;

    public List<MapTileData> getMapTileData() {
        return mapTileData;
    }

    public void setMapTileData(List<MapTileData> mapTileData) {
        this.mapTileData = mapTileData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResolutionX() {
        return resolutionX;
    }

    public void setResolutionX(Integer resolutionX) {
        this.resolutionX = resolutionX;
    }

    public Integer getResolutionY() {
        return resolutionY;
    }

    public void setResolutionY(Integer resolutionY) {
        this.resolutionY = resolutionY;
    }
}
