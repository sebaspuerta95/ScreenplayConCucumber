import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    eclipse
    idea
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.2.1"
}

defaultTasks("clean", "test", "aggregate")

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    val serenityVersion = "4.2.1"
    val junitPlatformLauncherVersion = "1.11.0"
    val cucumberJunitPlatformEngineVersion = "7.16.1"
    val junitPlatformSuiteVersion = "1.11.0"
    val junitJupiterEngineVersion = "5.11.0"
    val junitVintageEngineVersion = "5.11.0"
    val logbackClassicVersion = "1.2.10"
    val assertjCoreVersion = "3.23.1"
    val slf4jVersion = "1.7.36"

    testImplementation("net.serenity-bdd:serenity-core:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-cucumber:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-ensure:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-junit5:$serenityVersion")
    testImplementation("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberJunitPlatformEngineVersion")
    testImplementation("org.junit.platform:junit-platform-suite:$junitPlatformSuiteVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterEngineVersion")
    testImplementation("org.junit.vintage:junit-vintage-engine:$junitVintageEngineVersion")
    implementation("ch.qos.logback:logback-classic:$logbackClassicVersion")
    testImplementation("org.assertj:assertj-core:$assertjCoreVersion")
    testImplementation("org.slf4j:slf4j-api:$slf4jVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)
    }
    finalizedBy("aggregate")
}

gradle.startParameter.isContinueOnFailure = true
