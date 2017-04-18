# door2door-sdk-android
[![Build Status](https://travis-ci.org/door2door-io/door2door-sdk-android.svg?branch=develop)](https://travis-ci.org/door2door-io/door2door-sdk-android)
[![Coverage Status](https://coveralls.io/repos/github/door2door-io/door2door-sdk-android/badge.svg?branch=develop&t=bwixbS)](https://coveralls.io/github/door2door-io/door2door-sdk-android?branch=develop)
[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)

An Android SDK for using the Door2Door mobility analytics.

## Table of contents
* [Technical requirements](#technical-requirements)
* [Setup](#setup)
* [Guide](#guide)
* [Reference](#reference)
* [Developer Guide](#developer-guide)
* [License](#license)

## Technical Requirements
The minimal supported Android version of the SDK is 4.0 (API level 14).

## Setup
##### Adding the SDK dependency to  a project
Add the following dependency to the project:

    compile 'io.door2door:mobility-analytics-sdk:[LATEST_VERSION]'


##### ProGuard configuration (only if ProGuard is being used)


Add the following line in the ProGuard configuration:

    -keep class io.door2door.analytics.** { *; }

## Guide
Once the SDK dependency has been added to the project, it must be initialized. To initialize the SDK, create an instance of the MobilityAnalytics class using its constructor:

    MobilityAnalytics(Context context, InitializationParameters initializationParameters)

For the context parameter just provide the application context. InitializationParameters is a POJO object containing the configuration values which will be used during the initialization of the SDK.
 Instances of it can be created by using its Builder. An example is shown below:

    InitializationParameters initializationParameters = new InitializationParameters.InitializationParametersBuilder()
                            .setApplicationName("SimpleExample")
                            .setAuthorizationKey("de99a0adeefac13bbd23949b0ade7eea1cfcbc3a57e6d589bcbcc5be51da0a8f")
                            .setVersionName("1.0.0")
                            .setLoggerEnabled(true)
                            .setEnvironment(Environment.TEST)
                            .build();



Here are all available initialization parameters and their default values:
<table border="0">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>loggerEnabled</td>
		<td>boolean</td>
		<td>false</td>
		<td>Flag for enabling/disabling the logs coming from the library. The logs can be useful for debugging during the development. It is recommended to disable the logging for production.</td>
	</tr>
	<tr>
		<td>applicationName</td>
		<td>String</td>
		<td>null</td>
		<td>The name of the application that is sent to the mobility analytics backend. This value will be later associated with the data sent by the application and be visible in the mobility analytics dashboard.</td>
	</tr>
	<tr>
		<td>authorizationKey</td>
		<td>String</td>
		<td><b>An exception is thrown<b></td>
		<td>The authorization key for your application. Make sure it is kept in a safe place since it is a secret. This	value is required and if it is not provided, an exception will be thrown. For more info on where to get this value contact us.</td>
	</tr>
	<tr>
		<td>versionName</td>
		<td>String</td>
		<td>null</td>
		<td>The version name that is sent to the mobility analytics backend. This value will be later associated with the data sent by the application and be visible in the mobility analytics dashboard.</td>
	</tr>
	<tr>
		<td>environment</td>
		<td>Environment enum</td>
		<td>PRODUCTION</td>
		<td>The backend environment to which the requests are sent. There are two available options <b>PRODUCTION</b> and <b>TEST</b>. <b>TEST</b> should be used while developing and testing the application. <b>PRODUCTION</b> should be used when the application is in production.</td>
	</tr>
</table>

It is recommended to create only one instance of the MobilityAnalytics object (have it as a singleton) and use it when recording events. If a dependency injection framework is being used, MobilityAnalytics dependency should be marked as a singleton.Otherwise, it can be used as an application singleton in the application class. If  further assistance is required, refer to the application class of the provided [door2door-example-android](https://github.com/door2door-io/door2door-example-android) (it sets up MobilityAnalytics as application singleton).

##### Using the SDK to recording events
To record events, a reference to the MobilityAnalytics object is needed. It contains a recordEvent(event) method for every type of event  that can be recorded:

    mobilityAnalytics.recordEvent(event);

For creating the appropriate event object, the provided Builders can be used. Examples are provided for each type of event in the next section.

## Reference
The mobility analytics supports the following events:

#### SearchTripEvent

Event indicating that the user performed a search of a trip. Instance can be created using the SearchTripEvent.SearchTripEventBuilder Builder. It has the following properties:



<table border="0">
	<tr>
		<th>Property</th>
		<th>Type</th>
		<th>Required</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>departureTimestamp</td>
		<td>Date</td>
		<td>No</td>
		<td>The departure time.</td>
	</tr>
	<tr>
		<td>departureLatitude</td>
		<td>Double</td>
		<td>Yes</td>
		<td>The latitude of the departure location.</td>
	</tr>
	<tr>
		<td>departureLongitude</td>
		<td>Double</td>
		<td>Yes</td>
		<td>The longitude of the departure location.</td>
	</tr>
	<tr>
		<td>departureName</td>
		<td>String</td>
		<td>No</td>
		<td>The name of the departure place.</td>
	</tr>
	<tr>
		<td>departureCity</td>
		<td>String</td>
		<td>No</td>
		<td>The city in which the departure is located.</td>
	</tr>
	<tr>
		<td>departureStreet</td>
		<td>String</td>
		<td>No</td>
		<td>The street on which the departure is located.</td>
	</tr>
	<tr>
		<td>departurePostalCode</td>
		<td>String</td>
		<td>No</td>
		<td>The postal code in which the departure is located.</td>
	</tr>
	<tr>
		<td>departureCountry</td>
		<td>String</td>
		<td>No</td>
		<td>The country in which the departure is located.</td>
	</tr>
	<tr>
		<td>arrivalTimestamp</td>
		<td>Date</td>
		<td>No</td>
		<td>The expected time of the arrival.</td>
	<tr>
		<td>arrivalLatitude</td>
		<td>Double</td>
		<td>Yes</td>
		<td>The latitude of the arrival location.</td>
	</tr>
	<tr>
		<td>arrivalLongitude</td>
		<td>Double</td>
		<td>Yes</td>
		<td>The longitude of the arrival location.</td>
	</tr>
	<tr>
		<td>arrivalName</td>
		<td>String</td>
		<td>No</td>
		<td>The name of the arrival location.</td>
	</tr>
	<tr>
		<td>arrivalCity</td>
		<td>String</td>
		<td>No</td>
		<td>The city in which the arrival is located.</td>
	</tr>
	<tr>
		<td>arrivalStreet</td>
		<td>String</td>
		<td>No</td>
		<td>The street on which the arrival is located.</td>
	</tr>
	<tr>
		<td>arrivalPostalCode</td>
		<td>String</td>
		<td>No</td>
		<td>The postal code in which the arrival is located.</td>
	</tr>
	<tr>
		<td>arrivalCountry</td>
		<td>String</td>
		<td>No</td>
		<td>The country in which the arrival is located.</td>
	</tr>
	<tr>
		<td>modeOfTransportation</td>
		<td>ModeOfTransportation enum, see javadoc for more information</td>
		<td>No</td>
		<td>The mode of transport selected by the user for the current search. The event supports multiple parameters, each can be added using the addModeOfTransportation(ModeOfTransportation modeOfTransportation) method in the Builder. Available modes of transportation: WALK, PUBLIC_TRANSPORT, CAR_SHARING, BIKE_SHARING, TAXI, PRIVATE_BIKE, RIDE_SHARING and OTHER.</td>
	</tr>
	<tr>
</table>

Example:

    SearchTripEvent event = new SearchTripEvent.SearchTripEventBuilder()
                    .setDepartureTimestamp(myDepartureDate)
                    .setDepartureLatitude(52.529919)
                    .setDepartureLongitude(13.403067)
                    .setDepartureName("Door2Door HQ")
                    .setDepartureStreet("Torstrasse 109")
                    .setDepartureCity("Berlin")
                    .setDeparturePostalCode("10119")
                    .setDepartureCountry("Germany")
                    .setArrivalTimestamp(myArrivaleDate)
                    .setArrivalLatitude(52.522258)
                    .setArrivalLongitude(13.412678)
                    .setArrivalName("Alexanderplatz")
                    .setArrivalStreet("AlexanderplatzStreet")
                    .setArrivalCity("BerlinCity")
                    .setArrivalPostalCode("10178")
                    .setArrivalCountry("GermanyCountry")
                    .addModeOfTransportation(ModeOfTransportation.BIKE_SHARING)
                    .addModeOfTransportation(ModeOfTransportation.CAR_SHARING)
                    .build();

### JavaDoc
The JavaDoc is available at the docs/javadoc directory.

### Example
For an example on how to use the SDK,refer to [door2door-example-android](https://github.com/door2door-io/door2door-example-android).

## Developer Guide
The goal of this guide is to provide all the information a new developer would need when starting  development. If additional information is required, please ensure this README.md file is updated.
### Git workflow
Door2Door uses gitflow. More information on how gitflow works can be found [here](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).
### Building
To build the project in the command line run:

```
./gradlew clean build
```

Using this method also ensures that all the tests and static analysis checks pass.

### Releasing
Releases are automatically carried out by Travis and are triggered by a commit on the Master branch. The steps to follow when creating a release are:

 * Create a release branch.
 * On the develop branch bump the version ot the next one
 * Once everything is complete, merge the release branch back to Master and develop. This will trigger the Travis job that creates the release.
 * Make sure to have a git tag of the released version

Note: All builds created from Master on Travis will be release builds. (the -SNAPSHOT) section of the version is removed at build time.

## License
For license details see [License](LICENSE).
