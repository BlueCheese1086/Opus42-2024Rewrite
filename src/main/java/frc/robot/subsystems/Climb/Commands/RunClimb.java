package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Direction;
import frc.robot.subsystems.Climb.Climb;

public class RunClimb extends CommandBase {
    private final Climb climb;
    private final Direction direction;

    public RunClimb(Climb climb, Direction direction){
        this.climb = climb;
        this.direction = direction;

        addRequirements(climb);
    }

    @Override
    public void execute() {
        climb.start(direction);
    }

    @Override
    public void end(boolean interr) {
        climb.stop();
    }
}
