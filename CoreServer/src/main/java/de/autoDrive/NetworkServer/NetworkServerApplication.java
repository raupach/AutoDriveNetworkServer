package de.autoDrive.NetworkServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class NetworkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetworkServerApplication.class, args);
	}

}
