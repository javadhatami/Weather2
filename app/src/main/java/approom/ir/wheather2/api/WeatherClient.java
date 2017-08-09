package approom.ir.wheather2.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static android.R.attr.apiKey;

/**
 * Created by javad on 7/29/2017 AD.
 */

public interface WeatherClient {

    @GET("{api_key}/{position}")
    Call<WeatherJsonModel> getWeather(
            @Path("api_key") String apiKey,
            @Path("position") String position
    );
}
