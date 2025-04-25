/*
Spacecraft Command System (Inspired by NASA)
Scenario:
Design a system that handles commands sent to spacecraft. Commands differ depending on the target (rover, satellite, lander)
and evolve with mission types. Some commands are timed, others are immediate.
All commands must be logged, validated, and simulated before execution.

Question:
What are your abstractions for "command", "target", and "execution"?
How do you ensure new spacecraft types can be added without modifying the system?
How do you isolate logging and validation?
What interfaces would you create?
*/

interface Command {
    public void simulate();

    public void execute();
}

class TakePhoto implements Command {
    public void simulate() {
        // simulate
    }

    public void execute() {
        // simulate
    }
}

interface SpaceCraft {
    public void receive(Command command);
}

class Rover implements SpaceCraft {
    public void receive(Command command) {
        command.simulate();
        command.execute();
    }
}


class SpaceCraftManager {
    private Logger logger;
    private Validator validator;

    public SpaceCraftManager(Logger logger, Validator validator) {
        this.logger = logger;
        this.validator = validator;
    }

    public void sendCommand(SpaceCraft target, Command command) {
        if(validator.validate(command)) {
            logger.log(command);
            target.receive(command);
        }
    }

}


class Validator(){
    public boolean validate(Command command){

    }
}

class Logger(){
    public void log(Command command){
        // log logic
    }
}
