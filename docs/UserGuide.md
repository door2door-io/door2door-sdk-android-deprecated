## Usage
### Setup
##### Add the SDK dependency to your project
In your project add the following dependency:

    compile 'io.door2door:mobility-analytics-sdk:[LATEST_VERSION]'
    
    
##### Proguard configuraiton (only if proguard is used)
In you prohouard configuration add the following line:

    -keep class io.door2door.analytics.** { *; }

##### Initializing the SDK 
Once the SDK dependency is added to the project, the next step is to initialize it. The initialization is done by creating an instance of the MobilityAnalytics class using its constructor:

    MobilityAnalytics(Context context, InitializationParameters initializationParameters)

For the context parameter just provide the application context. InitializationParameters is a POJO object containing the configuration values which will be used during the initialization of the SDK. 
You can create an instance of it by using its builder. An example could look like this:

    InitializationParameters initializationParameters = new InitializationParameters.InitializationParametersBuilder()
                            .setApplicationName("SimpleExample")
                            .setVersionName("1.0.0")
                            .setLoggerEnabled(true)
                            .setEnvironment(Environment.TEST)
                            .build();
                           
                            
                            
Here are all available initialization parameters and their default values: 
<table border="0">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Default value</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>loggerEnabled</td>
		<td>boolean</td>
		<td>true</td>
		<td>Flag for enabling/disabling the logs coming from the library. The logs can be useful for debugging during the development, it is recommended to disable the logging for production.</td>
	</tr>
	<tr>
		<td>applicationName</td>
		<td>String</td>
		<td>null</td>
		<td>The name of the application that is sent to the mobility analytics backend. This value will be later associated with the data sent by the application and be visible in the mobility analytics dashboard.</td>
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

It is recommended to create only one instance of the MobilityAnalytics object (have it as a singleton) and use it when recording events. If you are using a dependency injection framework, you should mark the MobilityAnalytics dependency as singleton. If you do not, you can have it as an application singleton in your application class. If you are confused by this, have a look application class of the provided [mobility-analytics-example-android](https://github.com/door2door-io/mobility-analytics-example-android) (it sets up MobilityAnalytics as application singleton). 

##### Using the SDK to recording events
To record events you need reference to the MobilityAnalytics object. It contains a recordEvent(event) method for every type of event you can record:

    mobilityAnalytics.recordEvent(event);
    
For creating the appropriate event object, you can use the provided builders. Examples are provided for each type of event in the next section.

### Events
The mobility analytics supports the following events:

#### SearchTripEvent

Event indicating that the user performed a search of a trip. Instance can be created using the SearchTripEvent.SearchTripEventBuilder builder. It has the following properties:

    

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
		<td>The mode of transport selected by the user for the current search. The event supports multiple parameters, each can be added using the addModeOfTransportation(ModeOfTransportation modeOfTransportation) method in the builder. Available modes of transportation: WALK, PUBLIC_TRANSPORT, CAR_SHARING, BIKE_SHARING, TAXI, PRIVATE_BIKE, RIDE_SHARING and OTHER.</td>
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
The javadoc is available at the docs/javadoc directory.

### Example 
For an example on how to use the SDK see the [door2door-example-android](https://github.com/door2door-io/door2door-example-android).
