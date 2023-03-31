package patches.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a vcsRoot with id = 'HttpsGithubComJetBrainsIdeavimRefsHeadsMaster'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, GitVcsRoot({
    id("HttpsGithubComJetBrainsIdeavimRefsHeadsMaster")
    name = "https://github.com/JetBrains/ideavim/#refs/heads/master"
    url = "https://github.com/JetBrains/ideavim/"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
}))

