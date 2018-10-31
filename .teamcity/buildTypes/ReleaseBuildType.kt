package buildTypes

import buildSteps.AssembleBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import vcsRoots.GitHubRoot

class ReleaseBuildType : BuildType({
    id("ReleaseBuild")
    name = "Release Build"

    vcs {
        root(GitHubRoot())
        cleanCheckout = true
    }

    steps {
        step(AssembleBuildStep())
    }

    dependencies {
        snapshot(VerifyTestBuildType()) {}
    }

    triggers {
        vcs {
            branchFilter = "+:<default>"
        }
    }

    failureConditions {
        executionTimeoutMin = 600
    }
})
