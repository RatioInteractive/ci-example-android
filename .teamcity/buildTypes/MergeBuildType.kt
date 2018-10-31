package buildTypes

import buildSteps.AssembleBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import vcsRoots.GitHubRoot

class MergeBuildType : BuildType({
    id("MergeBuild")
    name = "Merge Build"

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
            branchFilter = "+:*"
            branchFilter = "-:<default>"
        }
    }

    failureConditions {
        executionTimeoutMin = 600
    }
})
