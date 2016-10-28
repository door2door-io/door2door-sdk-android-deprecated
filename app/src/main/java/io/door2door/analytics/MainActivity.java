package io.door2door.analytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.demandsdksample.R;

/**
 * Main activity class.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button recordAnEventButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordAnEventButton = (Button) findViewById(R.id.recordAnEventButton);
        recordAnEventButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // setup the initializations parameters for the mobility analytics
        InitializationParameters initializationParameters = new InitializationParameters();
        initializationParameters.setLoggerEnabled(true);

        // setup the mobility analytics instance
        MobilityAnalytics mobilityAnalytics = new MobilityAnalytics(initializationParameters);

        // prepare a sample event for tracking a trip creation
        CreateTripEvent event = new CreateTripEvent.CreateTripEventBuilder()
                .setOriginLatitude(52.529919)
                .setOriginLongitude(13.403067)
                .setOriginName("Door2Door HQ")
                .setOriginStreet("Torstrasse 109")
                .setOriginCity("Berlin")
                .setOriginPostalCode("10119")
                .setOriginCountry("Germany")
                .setDestinationLatitude(52.522258)
                .setDestinationLongitude(13.412678)
                .setDestinationName("Alexanderplatz")
                .setDestinationStreet("AlexanderplatzStreet")
                .setDestinationCity("BerlinCity")
                .setDestinationPostalCode("10178")
                .setDestinationCountry("GermanyCountry")
                .build();

        // send the event to the mobility analytics instance
        mobilityAnalytics.recordEvent(event);
    }
}
