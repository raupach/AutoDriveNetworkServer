package de.autoDrive.NetworkServer.repository.neo4j;


import de.autoDrive.NetworkServer.entity.neo4j.MapTileData;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MapTileDataRepository extends CrudRepository<MapTileData, String> {

    Optional<MapTileData> findFirstByZoomLevelAndXAndYAndName(Integer zoomLevel, Integer x, Integer y, String name);
}
