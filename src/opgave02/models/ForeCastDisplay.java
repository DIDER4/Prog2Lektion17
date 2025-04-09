package opgave02.models;

import opgave02.models.subject.WeatherData;

public class ForeCastDisplay implements Observer, DisplayElement {
    private float currentTemp = 0f;
    private float lastTemp;

    private float currentHumidity = 0f;
    private float lastHumidity;

    private float currentPressure = 0f;
    private float lastPressure;

    private WeatherData weatherData;

    public ForeCastDisplay (WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.lastTemp = currentTemp;
        this.currentTemp = weatherData.getTemperature();

        this.lastHumidity = currentHumidity;
        this.currentHumidity = weatherData.getHumidity();

        this.lastPressure = currentPressure;
        this.currentPressure = weatherData.getPressure();

        display();
    }

    @Override
    public void display() {
        System.out.println("\n --- Kommende Vejr ---");
        System.out.println("Sidste temperatur: " + lastTemp + "°C, Nuværende temperatur: " + currentTemp + "°C");
        System.out.println("Sidste luftfugtighed: " + lastHumidity + "%, Nuværende luftfugtighed: " + currentHumidity + "%");
        System.out.println("Sidste tryk: " + lastPressure + " hPa, Nuværende tryk: " + currentPressure + " hPa");
    }
}
