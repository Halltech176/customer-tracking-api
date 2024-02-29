package com.halltech;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public class TestContainersTest extends  AbstractTestcontainerUnitTest {


    @Test
    void canStartPostgresDb() {
        assertThat(postgresSQLContainer.isRunning()).isTrue();
        assertThat(postgresSQLContainer.isCreated()).isTrue();
//        assertThat(postgresSQLContainer.isHealthy()).isTrue();
    }

}
