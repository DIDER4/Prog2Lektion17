package opgave02.models;

import opgave02.models.subject.WeatherData;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> tempHistory = new ArrayList<>();
    private List<Float> humidityHistory = new ArrayList<>();
    private List<Float> pressureHistory = new ArrayList<>();
    private WeatherData weatherData;

    public StatisticsDisplay (WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        tempHistory.add(temp); // Tilføj ny temperatur til historikken
        humidityHistory.add(humidity); // Tilføj ny luftfugtighed til historikken
        pressureHistory.add(pressure); // Tilføj nyt tryk til historikken
        display();
    }

    private float calculateAverage (List<Float> history){
        float sum = 0f;
        for (Float reading : history) {
            sum += reading;
        }
        return sum / history.size();
    }

    @Override
    public void display() {
        System.out.println("\n --- Gennemsnits Vejr ---");
        System.out.println("Gennemsnits temperaturen er: " + calculateAverage(tempHistory) + " C");
        System.out.println("Gennemsnits Luftfugtigheden er: " + calculateAverage(humidityHistory) + " %");
        System.out.println("Gennemsnits Luft trykket er: " + calculateAverage(pressureHistory) + " hPa");

    }
}