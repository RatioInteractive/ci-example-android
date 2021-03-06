import buildTypes.MergeBuildType
import buildTypes.ReleaseBuildType
import buildTypes.VerifyTestBuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.project
import jetbrains.buildServer.configs.kotlin.v2018_1.version
import vcsRoots.GitHubRoot

version = "2018.1"

project {

    vcsRoot(GitHubRoot())
    buildType(VerifyTestBuildType())
    buildType(MergeBuildType())
    buildType(ReleaseBuildType())

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
