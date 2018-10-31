package buildTypes

import buildSteps.LintTestBuildStep
import buildSteps.UnitTestBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import vcsRoots.GitHubRoot

class VerifyTestBuildType : BuildType({
    id("VerifyTest")
    name = "Verify Tests"

    vcs {
        root(GitHubRoot())
        cleanCheckout = true
    }

    steps {
        step(LintTestBuildStep())
        step(UnitTestBuildStep())
    }
})
