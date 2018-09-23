public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl(int numberOfCommands) {


        onCommands = new Command[numberOfCommands];
        offCommands = new Command[numberOfCommands];

        Command noCommand = new NoCommand();
        for(int i = 0; i < numberOfCommands; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        //We implemented null object pattern to avoid checking if we can call execute on command object
        onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        //We implemented null object pattern to avoid checking if we can call execute on command object
        offCommands[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------ Remote Control ---------\n");
        for (int i=0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "   " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();
    }
}
