package design.pattern.behavioral.command;

// Command interface
interface Command {
    void execute();
}

// Receiver
class Vehicle {
    void start() {
        System.out.println("Vehicle has started");
    }

    void stop() {
        System.out.println("Vehicle has stopped");
    }
}

// Concrete Command for starting the vehicle
class StartCommand implements Command {
    private final Vehicle vehicle;

    StartCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.start();
    }
}

// Concrete Command for stopping the vehicle
class StopCommand implements Command {
    private final Vehicle vehicle;

    StopCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.stop();
    }
}

// Invoker
class Driver {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}

// Client code
public class VehicleImpl {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Command startCommand = new StartCommand(vehicle);
        Command stopCommand = new StopCommand(vehicle);

        Driver driver = new Driver();

        driver.setCommand(startCommand);
        driver.executeCommand(); // Output: Vehicle has started

        driver.setCommand(stopCommand);
        driver.executeCommand(); // Output: Vehicle has stopped
    }
}