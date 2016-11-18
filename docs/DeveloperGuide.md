## Developer Guide
The goal of this is to provide all the information a new developer would need to start with the development. When using it if for some reason you need some additional information, please make sure that this README.md file is updated.
### Git workflow
We are using the gitflow. More information on how gitflow works can be found [here](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).
### Building
To build the project in the command line run:

```
./gradlew clean build
```

Building this way also makes sure that all the tests and static analysis checks pass.

### Releasing
Releases are automatically done by travis and are triggered by a commit on the master branch. The steps to folow when creating a release are:

 * Create a release branch.
 * On the develop branch bump the version ot the next one
 * Once everything is OK merge the release branch back to master and develop and this will trigger the travis job that creates the release.
 * Make sure to have a git tag of the released version

Note: All builds created from master on travis will be release builds (the -SNAPSHOT) section of the version is removed at build time.
