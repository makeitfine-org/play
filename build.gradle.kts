plugins {
    id("java")
    application
    id("idea")
}

group = "io.github.koresmosto.play"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

tasks.withType<JavaCompile>().configureEach { //todo: can be removed as it's preview
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Test> {
    jvmArgs = mutableListOf("--enable-preview")
    maxParallelForks = Runtime.getRuntime().availableProcessors()

    testLogging {
        showStandardStreams = false
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        afterSuite(
            KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
                if (desc.parent == null) { // will match the outermost suite
                    println("Results: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} successes, ${result.failedTestCount} failures, ${result.skippedTestCount} skipped)")
                }
            })
        )
    }
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.projectlombok:lombok:1.18.34")

    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "io.github.koresmosto.play.Main"
}
