package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Group;
import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.entity.Waypoint;
import de.autoDrive.NetworkServer.repository.WaypointRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.MarkerDto;
import de.autoDrive.NetworkServer.rest.dto_v1.WaypointDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaypointMapper {

    @Autowired
    private WaypointRepository waypointRepository;

    public List<Waypoint> toEntity(Route route, List<WaypointDto> waypointDtos, List<MarkerDto> markers) {
        List<Waypoint> waypoints = waypointDtos.stream().map(w -> toEntity(route, w)).collect(Collectors.toList());
        reorderWaypoints(waypointDtos, waypoints);

        markers.forEach(m -> setMarker(waypoints, m, route.getGroups()));

        return waypoints;
    }

    private void setMarker(List<Waypoint> waypoints, MarkerDto dto, List<Group> groups) {
        Waypoint waypoint = waypoints.get(dto.getWaypointIndex());
        waypoint.setMarkerName(dto.getName());
        waypoint.setGroup(findGroup(groups, dto.getGroup()));
    }

    private Group findGroup(List<Group> groups, String name) {
        return groups.stream().filter(g -> StringUtils.equalsIgnoreCase(g.getName(), name)).findFirst().orElse(null);
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

    public List<WaypointDto> toWaypointDto(List<Waypoint> waypoints) {
        return waypoints.stream().map(w -> toWaypointDto(waypoints, w)).collect(Collectors.toList());
    }

    private WaypointDto toWaypointDto(List<Waypoint> waypoints, Waypoint waypoint) {
        WaypointDto dto = new WaypointDto();
        dto.setY(waypoint.getY());
        dto.setX(waypoint.getX());
        dto.setZ(waypoint.getZ());
        dto.setOut(waypoint.getOutgoing().stream().map(w -> waypoints.indexOf(w)+1).collect(Collectors.toList()));
        return dto;
    }

    public List<MarkerDto> toMarkerDto(List<Waypoint> waypoints) {
        return waypoints.stream().filter(p->StringUtils.isNotBlank(p.getMarkerName())).map(w -> toMarkerDto(waypoints, w)).collect(Collectors.toList());
    }

    private MarkerDto toMarkerDto(List<Waypoint> waypoints, Waypoint waypoint) {
        MarkerDto dto = new MarkerDto();
        dto.setName(waypoint.getMarkerName());
        dto.setGroup(waypoint.getGroup().getName());
        dto.setWaypointIndex(waypoints.indexOf(waypoint));
        return dto;
    }
}
