plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "com.amazonaws", name = "amazon-sqs-java-messaging-lib", version = "1.2.0")
    implementation(group = "com.amazonaws", name = "aws-java-sdk-sqs", version = "1.12.493")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}