package opgave02.models;

import opgave02.models.subject.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temp = 0f;
    private float humidity = 0f;
    private float pressure = 0f;
    private WeatherData weatherData;

    public CurrentConditionsDisplay (WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("\n --- Nuværende Vejr ---");
        System.out.println("Det nuværende vejr er:" + temp + "Celcius, " + humidity + " % Luft fugtighed og " + pressure + " tryk.");
    }
}
