plugins {
    id("org.kodein.library.mpp")
}

kodein {
    kotlin {

        val allNonJvm = sourceSets.create("allNonJvm") {
            dependsOn(common.main)
        }

        add(kodeinTargets.jvm.jvm) {
            target.setCompileClasspath()
        }

        add(kodeinTargets.native.all) {
            main.dependsOn(allNonJvm)
        }

        add(kodeinTargets.js.js) {
            main.dependsOn(allNonJvm)
        }

        sourceSets.all {
            languageSettings.useExperimentalAnnotation("kotlin.Experimental")
            languageSettings.enableLanguageFeature("NewInference")
        }
    }
}

kodeinUpload {
    name = "Kodein-Type"
    description = "Kodein Type System"
}
