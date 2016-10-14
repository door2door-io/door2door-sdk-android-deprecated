package io.door2door.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.door2door.demandsdksample.R;
import io.door2door.demandsdksample.base.HelloWorld;

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
        // TODO 2016-10-17 zlatko: implement sending event
    }
}
