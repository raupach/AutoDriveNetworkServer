package de.autoDrive.NetworkServer.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Cacheable
@Cache(region = "userCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity{

    @Cache(region = "userRoutesCache", usage = CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(mappedBy = "user", fetch= FetchType.LAZY)
    private List<Route> routes = new ArrayList<>();

    @Column(name = "keycloak_user_id")
    private String keycloakUserId;
    private String username;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
