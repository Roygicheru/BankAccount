This is a Java project meant to demonstrate CI functionality using Jenkins.

Step 1:
--------
* Created an ngrok account by connecting it to my GitHub.

Step 2:
-------
Downloaded ngrok archive with command: 

    "curl -sSLO https://bin.equinox.io/c/bNyj1mQVY4c/ngrok-v3-stable-linux-amd64.tgz"

Extracted it directly into my executable path: 

    "sudo tar -xvzf ngrok-v3-stable-linux-amd64.tgz -C /usr/local/bin"

Verified installation: 

    "ngrok --version"

Ran the following command to add your authtoken to the default ngrok.yml configuration file.

    "ngrok config add-authtoken <REDACTED_AUTH_TOKEN>"

Ran :

    "ngrok http 8080"

Step 3:
-------
* Linked the GitHub repository to the local Jenkins server so that code pushes automatically trigger builds.

* Navigated to GitHub Repository Settings → Webhooks.

* Added the dynamic ngrok forwarding URL to the Payload URL field, appending the required Jenkins endpoint: https://<dynamic-id>.ngrok-free.app/github-webhook/

* Set Content type to application/json.

Step 4:
-----
* Created a Personal Access Token (PAT) in GitHub instead of using SSH. A PAT was chosen because it grants Jenkins secure, fine-grained access to both clone the repository and interact with the GitHub API (which is necessary for future webhook/status check automation).

* Added the PAT to Jenkins via Manage Jenkins → Credentials.

* Saved it as a "Username with password" credential with the ID github-token.

Step 5:
-------
* Created a Jenkins "Freestyle project" (BankAccount-CI) to test the webhook and build process.

* Failure 2 (Maven Typo): The build failed with Unknown lifecycle phase "clean-package". Maven requires a space between goals.

        Resolution: Updated the Jenkins build step from mvn clean-package to mvn clean package.

* Failure 3 (Missing Artifact Pattern): The build succeeded in compiling the code and passing tests, but Jenkins threw an error: No artifacts are configured for archiving.

        Resolution: Configured the post-build action to explicitly target the generated JAR file using the path target/*.jar.

Step 6:
-------
* To improve maintainability and gain visual staging, the project was migrated from a Jenkins UI-based Freestyle project to a Declarative Pipeline using a Jenkinsfile committed directly to the repository.

* Created BankAccount-Pipeline in Jenkins and set it to read the Jenkinsfile from the GitHub repository via SCM.

Step 7:
-------
* Failure 4 (Invalid Target Release): The pipeline successfully checked out the code but failed during the Maven compile phase with Fatal error compiling: error: invalid target release: 25. The pom.xml was configured for Java 25, but the Jenkins background user (jenkins) defaulted to an older system JDK, unaware of the user's custom Java 25 installation.

Resolution: 
1. Found the absolute path to the local Java 25 compiler using readlink -f $(which javac).
2. Registered this JDK in Jenkins under Manage Jenkins → Tools and named it Java25.
3. Injected the tool directly into the Jenkinsfile build environment:


    tools {
    jdk 'Java25'
    }

Step 8:
-------
Pushed the updated Jenkinsfile to GitHub. The workflow executed perfectly:

1. GitHub Webhook triggered Jenkins via the ngrok tunnel.

2. Jenkins injected the Java 25 environment.

3. Maven cleaned the workspace, compiled the Java code, and ran the 5 JUnit tests successfully.

4. Maven packaged the project into Bank-Account-RoyGicheru-1.0-SNAPSHOT.jar.

5. Jenkins archived the JAR file for direct download.