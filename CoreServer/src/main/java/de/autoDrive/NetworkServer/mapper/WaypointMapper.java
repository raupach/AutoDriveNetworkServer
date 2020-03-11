package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.entity.Waypoint;
import de.autoDrive.NetworkServer.repository.WaypointRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.WaypointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaypointMapper {

    @Autowired
    private WaypointRepository waypointRepository;

    public List<Waypoint> toEntity(Route route, List<WaypointDto> waypointDtos) {
        List<Waypoint> waypoints = waypointDtos.stream().map(w -> toEntity(route, w)).collect(Collectors.toList());
        reorderWaypoints(waypointDtos, waypoints);

        return waypoints;
    }

    private Waypoint toEntity(Route route, WaypointDto dto) {
        Waypoint waypoint = new Waypoint();
        waypoint.setX(dto.getX());
        waypoint.setY(dto.getY());
        waypoint.setZ(dto.getZ());
        waypoint.setRoute(route);
        waypointRepository.save(waypoint);
        return waypoint;
    }

    private void reorderWaypoints(List<WaypointDto> waypointDtos, List<Waypoint> waypoints) {
        for (int i = 0; i < waypointDtos.size(); i++) {
            WaypointDto dto = waypointDtos.get(i);
            Waypoint currentWayPoint = waypoints.get(i);

            for (Integer index : dto.getOut()) {
                if (index > 0) {
                    Waypoint outgoing = waypoints.get(index-1); // AutoDrive starts indexing at 1; we start at 0
                    currentWayPoint.getOutgoing().add(outgoing);
                    outgoing.getIncoming().add(currentWayPoint);
                }
            }
        }
    }
}
