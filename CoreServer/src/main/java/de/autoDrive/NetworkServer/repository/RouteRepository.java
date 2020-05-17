package de.autoDrive.NetworkServer.repository;

import de.autoDrive.NetworkServer.entity.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RouteRepository extends CrudRepository<Route, String> {

    Optional<Route> findById(String s);
}
