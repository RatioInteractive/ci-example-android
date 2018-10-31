package buildSteps

import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.GradleBuildStep

class LintTestBuildStep : GradleBuildStep({
    dockerImage = "randr0id/android-docker"
    gradleWrapperPath = "./gradlew"
    tasks = "lintRelease"
})
