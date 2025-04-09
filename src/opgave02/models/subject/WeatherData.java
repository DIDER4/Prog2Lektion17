package opgave02.models.subject;

import opgave02.models.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {
    private List<Observer> observers;
    Random random = new Random();
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public void measurementsChanged() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        notifyObservers();
    }

    public float getTemperature() {
        return Math.round(random.nextFloat(-20, 40) * 100) / 100.0f;
    }

    public float getHumidity() {
        return Math.round(random.nextFloat(2, 98));
    }

    public float getPressure() {
        return random.nextInt(900, 1080);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getTemperature(), getHumidity(), getPressure());
        }
    }

//    public void setMeasurements(float temp, float humidity, float pressure){
//        this.temp = temp;
//        this.humidity = humidity;
//        this.pressure = pressure;
//        measurementsChanged();
//    }
}
