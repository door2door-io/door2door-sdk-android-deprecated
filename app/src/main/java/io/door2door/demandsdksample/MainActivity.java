package io.door2door.demandsdksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.door2door.demandsdksample.base.HelloWorld;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloWorld helloWorld = new HelloWorld();
        ((TextView) findViewById(R.id.label)).setText(helloWorld.getHelloWorld());

    }
}
