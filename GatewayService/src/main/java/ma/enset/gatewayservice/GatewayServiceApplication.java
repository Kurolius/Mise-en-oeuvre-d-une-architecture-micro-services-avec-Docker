package ma.enset.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	/*
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route("r1",(r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE")
				.route("r2",(r)->r.path("/products/**").uri("lb://INVENTORY-SERVICE")
				.build();

				builder.routes()
                .route((r)->r.path("/api/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route((r)->r.path("/produits/**").uri("lb://INVENTORY-SERVICE")).build();
                .route((r)->r.path("/api/customers/**").uri("http://localhost:8092/"))
                .route((r)->r.path("/produits/**").uri("http://localhost:8082/")).build();
	}
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route("r1",(r)->r.path("/customers/**").uri("http://localhost:8081/")
				.route("r2",(r)->r.path("/products/**").uri("http://localhost:8082/")
				.build();
	}*/

	//a chaque fois tu vois la requete tu vas trouver le nom du Ms dans l'URL
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamiquesRoutes(
			ReactiveDiscoveryClient rdc,
			DiscoveryLocatorProperties properties){
		return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}
}
