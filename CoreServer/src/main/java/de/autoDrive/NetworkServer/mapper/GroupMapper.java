package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.Group;
import de.autoDrive.NetworkServer.entity.Route;
import de.autoDrive.NetworkServer.repository.GroupRepository;
import de.autoDrive.NetworkServer.rest.dto_v1.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupMapper {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> toEntity(Route route, List<GroupDto> groups) {
        return groups.stream().map(g -> toEntity(route, g)).collect(Collectors.toList());
    }

    public Group toEntity(Route route, GroupDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        group.setRoute(route);
        groupRepository.save(group);
        return group;
    }
}
