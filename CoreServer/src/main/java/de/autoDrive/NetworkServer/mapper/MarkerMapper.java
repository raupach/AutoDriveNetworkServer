package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Group;
import de.autoDrive.NetworkServer.entity.Marker;
import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.repository.MarkerRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.MarkerDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkerMapper {

    @Autowired
    private MarkerRepository markerRepository;


    public List<Marker> toEntity(Route route, List<MarkerDto> markers) {
        return markers.stream().map(m -> toEntity(route, m)).collect(Collectors.toList());
    }

    public Marker toEntity(Route route, MarkerDto dto) {
        Marker marker = new Marker();
        marker.setName(dto.getName());
        marker.setGroup(findGroup(route.getGroups(), dto.getGroup()));
        marker.setWaypoint(route.getWaypoints().get(dto.getWaypointIndex()));
        marker.setRoute(route);
        markerRepository.save(marker);
        return marker;
    }

    private Group findGroup(List<Group> groups, String name) {
        return groups.stream().filter(g -> StringUtils.equalsIgnoreCase(g.getName(), name)).findFirst().orElse(null);
    }
}
