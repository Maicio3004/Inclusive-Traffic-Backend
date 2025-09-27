package com.uis.project;

import com.uis.project.utils.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class InclusiveTrafficApplication {

	public static void main(String[] args) {

        EnvLoader envLoader = new EnvLoader();

        Set<String> keys = Set.of("DB_HOST", "DB_PORT", "DB_USERNAME", "DB_PASSWORD", "DB_DEFAULT",
                "BACKEND_PORT", "MQTT_BROKER_URL", "MQTT_CLIENT_ID", "MQTT_USERNAME", "MQTT_PASSWORD",
                "INBOUND_TOPIC");
        envLoader.loadSelected(keys);

		SpringApplication.run(InclusiveTrafficApplication.class, args);
	}

}
