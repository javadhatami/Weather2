package approom.ir.wheather2.api;

import android.util.Log;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import approom.ir.wheather2.R;

import static approom.ir.wheather2.R.drawable.cloudy;
import static approom.ir.wheather2.R.drawable.partly_cloudy_day;
import static approom.ir.wheather2.R.drawable.sleet;
import static approom.ir.wheather2.R.drawable.wind;

/**
 * Created by javad on 7/29/2017 AD.
 */

public class WeatherJsonModel {

    public String getFormattedTime() {

        SimpleDateFormat formater = new SimpleDateFormat("h:mm a");
        formater.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date dateTime = new Date(getCurrently().getTime()*1000);
        String timeString = formater.format(dateTime);
        return timeString;
    }



    private String timezone;
    private WeatherCurrently currently;

    public WeatherCurrently getCurrently() {
        return currently;
    }

    public void setCurrently(WeatherCurrently currently) {
        this.currently = currently;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public static class WeatherCurrently{

        WeatherJsonModel weatherJsonModel;

        private String icon;
        private long time;
        private double temperature;
        private double humidity;
        private double precipChance;
        private String summary;

        public long getTime() {
            return time;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getIconId(){

            //clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night.

            int iconId = R.drawable.clear_day;

            if (icon.equals("clear-day")){

                iconId = R.drawable.clear_day;
            }

            else if (icon.equals("clear-night")){
                iconId = R.drawable.clear_night;

            }
            else if (icon.equals("rain")){
                iconId = R.drawable.rain;

            }
            else if (icon.equals("snow")){
                iconId = R.drawable.snow;

            }
            else if (icon.equals("sleet")){
                iconId = R.drawable.sleet;

            }
            else if (icon.equals("wind")){
                iconId = R.drawable.wind;

            }
            else if (icon.equals("fog")){
                iconId = R.drawable.fog;

            }
            else if (icon.equals("cloudy")){
                iconId = cloudy;

            }
            else if (icon.equals("partly-cloudy-day")){
                iconId = R.drawable.partly_cloudy_day;

            }
            else if (icon.equals("partly-cloudy-night")){
                iconId = R.drawable.partly_cloudy_night;

            }

            return iconId;

        }


        public void setTime(long time) {
            this.time = time;
        }



        public int getTemperature() {
            return (int) Math.round(temperature);
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public int getPrecipChance() {
            double precipPercentage = precipChance * 100;
            return (int) Math.round(precipPercentage);
        }

        public void setPrecipChance(double precipChance) {
            this.precipChance = precipChance;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
