public class RemoteControlSimulation {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(3);

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightffCommand = new LightOffCommand(light);

        Fan fan = new Fan();
        FanOnCommand fanOnCommand = new FanOnCommand(fan);
        FanOffCommand fanOffCommand = new FanOffCommand(fan);

        WaterHeater waterHeater = new WaterHeater();

        remoteControl.setCommand(0, lightOnCommand, lightffCommand);
        remoteControl.setCommand(1, fanOnCommand, fanOffCommand);

        // Lambda expressions and method references can be leveraged to avoid creating special classes for simple commands
        remoteControl.setCommand(2, () -> { waterHeater.on(); }, waterHeater::off);

        System.out.println(remoteControl.toString());

        remoteControl.onButtonWasPressed(0);
        remoteControl.onButtonWasPressed(1);
        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(0);
        remoteControl.offButtonWasPressed(1);
        remoteControl.offButtonWasPressed(2);
    }
}
