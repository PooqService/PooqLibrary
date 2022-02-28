plugins {
  kotlin("jvm") version "1.6.10"
  java
  application
}

group = "dev.pooq"
version = "1.0#BETA"

val ktorVersion = "1.6.7"
val logbackVersion = "1.2.10"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))

  implementation("org.mongodb:mongo-java-driver:3.12.10")

  implementation("com.google.code.gson:gson:2.9.0")

  implementation("io.ktor:ktor-server-core:$ktorVersion")
  implementation("io.ktor:ktor-server-netty:$ktorVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")
  implementation("io.ktor:ktor-serialization:$ktorVersion")
  implementation("io.ktor:ktor-mustache:1.6.7")

  testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
}