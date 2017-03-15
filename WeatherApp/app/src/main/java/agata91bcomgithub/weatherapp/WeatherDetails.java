package agata91bcomgithub.weatherapp;

import android.annotation.SuppressLint;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


/**
 * Created by RENT on 2017-03-15.
 */

public class WeatherDetails {

    private String location;


    private String temperature;


    private String skytex;


    public String getLocation() {
        return location;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getSkytex() {
        return skytex;
    }
}




