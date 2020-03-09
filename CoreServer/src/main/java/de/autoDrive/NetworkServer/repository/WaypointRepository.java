package de.autoDrive.NetworkServer.repository;

import de.autoDrive.NetworkServer.entity.Waypoint;
import org.springframework.data.repository.CrudRepository;

public interface WaypointRepository extends CrudRepository<Waypoint, Long> {
}
