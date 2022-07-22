# Lab - Construindo um app android

"Inheritance from an interface with '@JvmDefault' members is only allowed with -Xjvm-default option"
https://stackoverflow.com/questions/70992947/how-do-i-resolve-error-message-inheritance-from-an-interface-with-jvmdefault
https://blog.jetbrains.com/kotlin/2020/07/kotlin-1-4-m3-generating-default-methods-in-interfaces/

tasks.withType(KotlinCompile).configureEach {
    kotlinOptions {
        freeCompilerArgs += [
            "-Xjvm-default=all",
        ]
    }
}

