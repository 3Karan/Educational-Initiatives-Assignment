// Command Interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command to Turn on TV
class TurnOnTVCommand implements Command {
    private TV tv;

    public TurnOnTVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

// Concrete Command to Turn off Light
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Receiver: TV
class TV {
    public void turnOn() {
        System.out.println("The TV is ON");
    }

    public void turnOff() {
        System.out.println("The TV is OFF");
    }
}

// Receiver: Light
class Light {
    public void turnOn() {
        System.out.println("The Light is ON");
    }

    public void turnOff() {
        System.out.println("The Light is OFF");
    }
}

// Invoker: Remote Control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        }
    }

    public void pressUndo() {
        if (command != null) {
            command.undo();
        }
    }
}

// Main class to test
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Light light = new Light();

        Command turnOnTV = new TurnOnTVCommand(tv);
        Command turnOffLight = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        // Turn on the TV
        remote.setCommand(turnOnTV);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(turnOffLight);
        remote.pressButton();

        // Undo the last action (turn on the light again)
        remote.pressUndo();
    }
}
