plugins {
    id("java")
    id("com.diffplug.spotless")
}

// Configure Java compilation
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

// Configure JUnit5 as test framework
tasks.test {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

// Configure a community plugin - example Spotless
spotless {
    format("buildFiles") {
        target("build.gradle.kts")
        trimTrailingWhitespace()
        endWithNewline()
    }
}
