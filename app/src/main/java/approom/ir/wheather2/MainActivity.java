package approom.ir.wheather2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import approom.ir.wheather2.api.WeatherJsonModel;
import approom.ir.wheather2.data.WeathersData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.drawable;
import static android.R.attr.text;
import static android.R.attr.timeZone;
import static android.R.id.text1;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class MainActivity extends AppCompatActivity {

    ImageView iconI;
    TextView temperatureT;
    TextView locationT;
    TextView timeT;
    TextView humidityT;
    TextView precipChanceT;
    TextView summaryT;
    ImageView refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherJsonModel weatherJsonModel = new WeatherJsonModel();

        temperatureT = (TextView) findViewById(R.id.temperatureLable);
        locationT = (TextView) findViewById(R.id.locationLable);
        timeT = (TextView) findViewById(R.id.timeLable);
        humidityT = (TextView) findViewById(R.id.humidityValue);
        precipChanceT = (TextView) findViewById(R.id.precipValue);
        summaryT = (TextView) findViewById(R.id.summary);
        iconI = (ImageView) findViewById(R.id.iconImageView);
        refreshButton = (ImageView) findViewById(R.id.refreshButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWeaterData();


            }
        });



        getWeaterData();

    }

    private void getWeaterData(){
        WeathersData data = new WeathersData();
        Call<WeatherJsonModel> call = data.getWeather();
        call.enqueue(new Callback<WeatherJsonModel>() {
            @Override
            public void onResponse(Call<WeatherJsonModel> call, Response<WeatherJsonModel> response) {
                WeatherJsonModel weatherJsonModel = response.body();

                String timeZone = weatherJsonModel.getTimezone();
                String icon = weatherJsonModel.getCurrently().getIcon();
                long time = weatherJsonModel.getCurrently().getTime();
                double temperature = weatherJsonModel.getCurrently().getTemperature();
                double humidity = weatherJsonModel.getCurrently().getHumidity();
                double precipChance = weatherJsonModel.getCurrently().getPrecipChance();
                String summary = weatherJsonModel.getCurrently().getSummary();
                String timeString = weatherJsonModel.getFormattedTime();


                Drawable drawable = getResources().getDrawable(weatherJsonModel.getCurrently().getIconId());
                iconI.setImageDrawable(drawable);

                locationT.setText(timeZone);
                temperatureT.setText((temperature) + " \u00B0");
                //temperatureT.setText(temperature + "");
                timeT.setText("At " + timeString + " it will be");
                humidityT.setText(humidity + "");
                precipChanceT.setText(precipChance + "%");
                summaryT.setText(summary);

                Log.d("timeZone", "---------> timeZone is :" + timeZone);
                Log.d("icon", "---------> icon is :" + icon);
                Log.d("time", "---------> time is :" + time);
                Log.d("temperature", "---------> temperature is :" + temperature);
                Log.d("humidity", "---------> humidity is :" + humidity);
                Log.d("precipChance", "---------> precipChance is :" + precipChance);
                Log.d("getFormattedTime", "---------> getFormattedTime is :" + timeString);


            }

            @Override
            public void onFailure(Call<WeatherJsonModel> call, Throwable t) {

            }
        });
    }
}
