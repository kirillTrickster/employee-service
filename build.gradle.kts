plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation ("org.springframework.kafka:spring-kafka:2.8.1")
	implementation ("org.springframework.security:spring-security-core:5.6.1")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("jakarta.servlet:jakarta.servlet-api:5.0.0")
	implementation("org.apache.tomcat.embed:tomcat-embed-core") {
		exclude(group = "org.eclipse.jdt.core.compiler", module = "ecj")
	}
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper") {
		exclude(group = "org.eclipse.jdt.core.compiler", module = "ecj")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}