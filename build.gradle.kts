import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    id("com.google.protobuf") version "0.9.2"
    id("org.sonarqube") version "2.7"
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("plugin.allopen") version "1.6.21"
    jacoco
}

group = "br.com.dhan"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

extra["springCloudVersion"] = "2021.0.3"

jacoco {
    toolVersion = "0.8.8"
}

sonarqube {
    properties {
        property("sonar.projectKey", "validacao-cnab")
        property("sonar.source", "src")
        property("sonar.scm.disabled", "True")
        property("sonar.coverage.exclusions", excludePackage)
    }
}

sourceSets {
    create("teste")
}

// val archTestImplementation: Configuration by configurations.getting {
//    extendsFrom(configurations.implementation.get())
// }

dependencies {

    // Message Broker
    implementation("org.springframework.cloud:spring-cloud-starter-stream-rabbit:4.0.1")

    // WEB
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-httpclient")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.openapitools:jackson-databind-nullable:0.2.1")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.14")
    compileOnly("io.swagger:swagger-annotations:1.6.2")
    compileOnly("io.springfox:springfox-core:3.0.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // thirdparty commons
    implementation("de.huxhorn.sulky:de.huxhorn.sulky.ulid:8.3.0")
    implementation("org.beanio:beanio:2.1.0")
    implementation("org.modelmapper:modelmapper:3.1.0")

    // commons module
    implementation("br.com.dhan:schema-events:1.0")
    implementation("br.com.dhan:commons-lib:1.0")
    implementation("br.com.dhan:commons-beanio-schema:1.0")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlin:kotlin-noarg")

    // protobuy
    runtimeOnly("com.google.protobuf:protobuf-java-util:3.21.12")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.12")

    // Observability
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("io.micrometer:micrometer-registry-prometheus:1.9.3")
    implementation("io.github.openfeign:feign-micrometer:11.9.1")
    runtimeOnly("net.logstash.logback:logstash-logback-encoder:6.6")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // DB
    implementation("org.flywaydb:flyway-core:7.9.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    // Scheduler
    implementation("net.javacrumbs.shedlock:shedlock-spring:5.1.0")
    implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:5.1.0")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.20.2")
    testImplementation("io.mockk:mockk:1.12.5")
    testImplementation("org.springframework.cloud:spring-cloud-stream-test-support:3.2.4")

    // TestContainer
    testImplementation("org.testcontainers:postgresql:1.17.6")
    testImplementation("org.testcontainers:junit-jupiter:1.17.6")

//    archTestImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
//    archTestImplementation("com.tngtech.archunit:archunit-junit5-api:0.13.1")
//    archTestImplementation("com.tngtech.archunit:archunit-junit5-engine:0.13.1")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

configurations {
    all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
}

sourceSets {
    main {
        proto {
            srcDir("src/main/resources/proto")
        }
    }
}

protobuf {
    // Configure the protoc executable
    protoc {
        // Download from repositories
        artifact = "com.google.protobuf:protoc:3.0.0"
    }
    generateProtoTasks {
        // all() returns the collection of all protoc tasks

        // In addition to all(), you may get the task collection by various
        // criteria:

        // (Java only) returns tasks for a sourceSet
        ofSourceSet("main")
    }
}

// tasks.check {
//    dependsOn("ktlintCheck", "detekt", "archTest")
// }

// tasks.test {
//    dependson(...paths: "archTest")
// }

// detekt {
//    this: DetektExtension
//    source = files(... paths : "src/main") config = files(...paths: "detekt-config.yml")
//    reports this: DetektReports
//    html {
//        this: DetektReport enabled = true
//        Database Notifications Kotlin Bytecode Serview Gradie
//                destination = file(path: "build/reports/detekt.html")
//    }
// }

// tasks.register<Test>("archTest") {
//    testClassesDirs = sourceSets["archTest"].output.classesDirs
//    classpath = sourceSets["archTest"].runtimeClasspath
//
//    useJUnitPlatform()
// }

tasks.withType<Test> {
    val fileTest = file("variables.test.env")

    if (!fileTest.exists()) throw IllegalArgumentException("failed to load envs tests")
    println("carregando variaveis de test ")
    fileTest.readLines().forEach { line ->
        if (line.isBlank() || line.startsWith("#")) return@forEach
        line.split("=", limit = 2)
            .takeIf {
                it.size == 2 && it[0].isNotBlank()
            }
            ?.run {
                Pair(this[0].trim(), this[1].trim())
            }
            ?.run {
                environment[this.first] = this.second
            }
    }
    useJUnitPlatform()
//    finalizedBy(tasks.jacocoTestCoverageVerification, tasks.jacocoTestReport)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict -Xms1g -Xmx4g")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    minHeapSize = "1024m"
    maxHeapSize = "3048m"
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.destination = file("$buildDir/reports/jacoco/test")
    }
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude(excludePackage)
        }
    )
}

val excludePackage: Iterable<String> = emptyList()

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)
    violationRules {
        rule {
            limit {
                minimum = "0.96".toBigDecimal()
            }
        }

        rule {
            limit {
                counter = "BRANCH"
                value = "COVEREDRATIO"
                maximum = "0.9".toBigDecimal()
            }
        }

        classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching {
                exclude(excludePackage)
            }
        )
    }
}

springBoot {
    buildInfo()
}

// ktlint {
//    this: KtlintExtension
//    this.version.set("0.43.0")
// }

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
