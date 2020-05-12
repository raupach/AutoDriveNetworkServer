package de.autoDrive.NetworkServer.repository;

import de.autoDrive.NetworkServer.entity.MapInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MapInfoRepository extends CrudRepository<MapInfo, String> {

    Optional<MapInfo> findFirstByName(String name);
}
