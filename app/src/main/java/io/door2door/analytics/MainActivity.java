package io.door2door.analytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.api.model.Event;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.network.model.Person;
import io.door2door.analytics.network.model.Place;
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
        InitializationParameters initializationParameters = new InitializationParameters();
        initializationParameters.setLoggerEnabled(true);
        MobilityAnalytics mobilityAnalytics = new MobilityAnalytics(initializationParameters);
        Event event = new Event();
        Person actor = new Person();
        actor.setDeviceId("xyz");
        actor.setUuid("abc");
        actor.setName("John");
        actor.setPlatform("Android");
        actor.setApplication("DVG");
        actor.setVersion("v1.0.1");
        event.setActor(actor);
        Place object = new Place();
        object.setLatitude(45.345);
        object.setLongitude(89.3455);
        object.setName("anotherStr");
        event.setObject(object);
        mobilityAnalytics.recordEvent(event);
    }
}
