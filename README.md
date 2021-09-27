# TDS-AS Backend Starter Project

This starter project is used for new TDS-AS backend apps based on TDS Foundation and Spring Boot.

_Note: This documentation is preliminary and will be updated with more detail_

## Features

- Dependency management using Maven
- Standard settings and extensions for Visual Studio Code
- AS Builder Remote Containers support for Visual Studio Code
- Java single step debugging
- Spring Boot tooling
- Swagger UI
- AS status page and Spring Actuator

## How To Use

To make use of this starter project, perform the following steps:

1.  Create a new git repo and attach it to a remote repository. Instructions for this are typically given when the repo is created in GitLab.

2.  Clone this repo
    If you do not already have this repo locally, run the following command in your workspace:

    ```sh
    git clone git@gitlab.med.stanford.edu:irt-as/tools/project-starters/backend-starter.git
    ```

3.  Export the repo

    ```sh
    git archive master | tar -x -C <path to your empty project>
    ```

4.  From the new project's directory, open and update the following items in the `pom.xml` file.

    - `PROJECT_NAME_GOES_HERE` - The formal, long form name of the project, including any commonly used ancronym, if applicable.
    - `BRIEF_PROJECT_DESCRIPTION_GOES_HERE` - A brief, high-level description of the project and the features provided by the implementation.
    - `PROJECT_NAMESPACE_GOES_HERE` - Organizationally, our group's package naming should maintain high level consistency. Packages names should start with `org.stanfordmedicine.tds.as` beyond this, each project should choose a unique project level identifier, an acronym used to refer to a project is a good candidate for this.
    - `PROJECT_ARTIFACT_ID_GOES_HERE` - An artifact id that can be used to identify a project artifact uniquely among the artifacts under the specified group id.

5.  Add any existing dependencies needed by the project. Before selecting a dependency + version, review the "blessed" list of dependencies available. This can be done by executing:

    ```sh
    mvn help:effective-pom
    ```

    The dependency management section of the resulting pom outlines the dependencies and their version available via TDS Foundation.

6.  From the new project's directory, rename the `.gitlab-ci.yml.rename` file to `.gitlab-ci.yml`.

7.  From the new project's directory, open and update the following items in the `env.sh` file.

    - `GITLAB_REPO` - This is the path to the project's GitLab repo. For example, the value for this project is `irt-as/tools/project-starters/backend-starter`.
    - `GITLAB_DOWNSTREAM_NAME` - This is the name of the downstream deploy repo. For example, the value for this project would be `deploy-backend-starter`.
    - `GITLAB_DOWNSTREAM_REPOSITORY` - This is the sub path to the downstream deploy repo. For example, the value for this prroject would be `irt-as/runtimes/project-starters/${GITLAB_DOWNSTREAM_NAME}`.
    - `SLACK_GITLAB_CHANNEL` - This is the developer Slack channel name for the project. For example, `as_project_name_dev`.
    - `SLACK_CICD_CHANNEL` - This is the cicd Slack channel name for the project. For example, `as_project_name_dev_cicd`.

8.  At this point, the project should be ready for development. To build and run, execute:

    ```sh
    mvn spring-boot:run
    ```

    Go to http://localhost:8080/ to explore the sample Hello api. Username is `user` and password is `password`.

    Go to http://localhost:8080/swagger-ui.html to view the Swagger console.

    Go to http://localhost:8080/status to view the status page.
