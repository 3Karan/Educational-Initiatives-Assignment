import java.util.ArrayList;
import java.util.List;

// Subject (Observable)
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer Interface
interface WeatherObserver {
    void update(int temperature);
}

// Concrete Observers
class MobileDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Mobile Display: Weather updated! Current temperature: " + temperature + "°C");
    }
}

class TVDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("TV Display: Weather updated! Current temperature: " + temperature + "°C");
    }
}

class ComputerDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Computer Display: Weather updated! Current temperature: " + temperature + "°C");
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        MobileDisplay mobileDisplay = new MobileDisplay();
        TVDisplay tvDisplay = new TVDisplay();
        ComputerDisplay computerDisplay = new ComputerDisplay();

        weatherStation.addObserver(mobileDisplay);
        weatherStation.addObserver(tvDisplay);
        weatherStation.addObserver(computerDisplay);

        // Update weather, notifying all displays
        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);
    }
}
