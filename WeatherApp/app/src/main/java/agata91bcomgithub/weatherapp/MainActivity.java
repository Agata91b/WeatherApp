package agata91bcomgithub.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.temperature)
    TextView temperature;

    @BindView(R.id.sky_text)
    TextView skyText;

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.weather_icon)
    ImageView weatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://weathers.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

            WeatherService weatherService = retrofit.create(WeatherService.class);
            weatherService.getWeather("Warszawa")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( dataContainer -> {
                    WeatherDetails weatherDetails = dataContainer.getData();
                    city.setText(weatherDetails.getLocation());
                    temperature.setText(weatherDetails.getTemperature());
                    skyText.setText(weatherDetails.getSkytex());
                });

    }
}
