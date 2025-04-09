package opgave02;

import opgave02.models.*;
import opgave02.models.subject.WeatherData;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForeCastDisplay foreCastDisplay = new ForeCastDisplay(weatherData);

        while (true) {
            weatherData.measurementsChanged();
            Thread.sleep(1000);
        }
    }
}
