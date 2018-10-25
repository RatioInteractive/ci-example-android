import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.1"

project {

    buildType(Build)

    features {
        feature {
            id = "PROJECT_EXT_5"
            type = "CloudImage"
            param("imageId", "jetbrains/teamcity-agent")
            param("memory", "4")
            param("numberCores", "2")
            param("groupId", "teamcity")
            param("agent_pool_id", "-2")
            param("storageAccount", "teamcity7a69e190cf")
            param("vmUsername", "")
            param("reuseVm", "false")
            param("source-id", "teamcity-agent")
            param("deployTarget", "SpecificGroup")
            param("vmPublicIp", "false")
            param("profileId", "arm-2")
            param("imageUrl", "")
            param("osType", "Linux")
            param("maxInstances", "2")
            param("region", "westus")
            param("imageType", "Container")
        }
        feature {
            id = "arm-2"
            type = "CloudProfile"
            param("profileServerUrl", "")
            param("total-work-time", "")
            param("credentialsType", "msi")
            param("description", "")
            param("cloud-code", "arm")
            param("enabled", "true")
            param("environment", "AZURE")
            param("agentPushPreset", "1540497845915")
            param("profileId", "arm-2")
            param("name", "Azure Cloud")
            param("subscriptionId", "8b53b792-8973-4a30-a63e-4d0e9ff9e3f5")
            param("terminate-idle-time", "30")
            param("secure:passwords_data", "credentialsJSON:e792586a-6c9a-4bbd-8e31-3f014dfd2535")
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
})
