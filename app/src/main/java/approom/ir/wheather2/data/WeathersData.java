package approom.ir.wheather2.data;

import approom.ir.wheather2.api.ApiServiceFactory;
import approom.ir.wheather2.api.WeatherClient;
import approom.ir.wheather2.api.WeatherJsonModel;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by javad on 7/29/2017 AD.
 */

public class WeathersData {

    public Call<WeatherJsonModel> getWeather(){
        //j
        ApiServiceFactory serviceFactory = new ApiServiceFactory();
        //h
        Retrofit retrofit = serviceFactory.createService();
        //k
        WeatherClient service = retrofit.create(WeatherClient.class);
//jjjjj
        return service.getWeather(
                "3df2346ab956edbf813a58dfe396958a",
                37.8267 + "," + -122.4233);
    }
}
