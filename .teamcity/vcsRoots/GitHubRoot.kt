package vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

class GitHubRoot : GitVcsRoot({
    name = "github.com/RatioInteractive/ci-example-android"
    url = "https://github.com/RatioInteractive/ci-example-android"
    pushUrl = "https://github.com/RatioInteractive/ci-example-android"
})
