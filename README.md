# mobility-analytics-sdk-android
[![Build Status](https://travis-ci.com/door2door-io/mobility-analytics-sdk-android.svg?token=pjx3zDtzXuU6uwdz9wez&branch=develop)](https://travis-ci.com/door2door-io/mobility-analytics-sdk-android)
[![Coverage Status](https://coveralls.io/repos/github/door2door-io/mobility-analytics-sdk-android/badge.svg?branch=develop&t=R8mFz4)](https://coveralls.io/github/door2door-io/mobility-analytics-sdk-android?branch=develop)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)

An Android SDK for using the Door2Door mobility analytics.

## Usage
For an example on how to use the SDK see the [mobility-analytics-example-android](https://github.com/door2door-io/mobility-analytics-example-android).

## Developer Guide
The goal of this is to provide all the information a new developer would need to start with the development. If when using it if for some reason you need some additiona informations, please make sure that this README.md file is updated. 
### Git workflow
We are using the gitflow. More information on how gitflow works can be found [here](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow/index.html).
### Building
To build the project in the command line run:
```
./gradlew clean build
```
### Releasing
Releases are automatically done by travis and are triggered by a commit on the masster branch. The steps to foolow when creating a release are:
 * Create a release branch.
 * On the develop bump the version ot the next one
 * Once everything is OK merge the release branch back to master and develop and this will triger the travis job that creates the release.
 * Make sure to have a git tag of the relesed version
 
Note: All builds created from master on travis will be release builds (the -SNAPSHOT) secion of the version is removed at build time.
 
### Versioning
TBD

### Troubleshooting
TBD

## License
TBD
