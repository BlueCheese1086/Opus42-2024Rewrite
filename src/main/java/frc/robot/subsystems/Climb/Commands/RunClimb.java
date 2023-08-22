package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Enums;
import frc.robot.subsystems.Climb.Climb;

public class RunClimb extends CommandBase {
    private final Climb climb;
    private final Enums direction;
    private double seconds;
    private double finish;

    public RunClimb(Climb climb, Enums direction) {
        this.climb = climb;
        this.direction = direction;
    }

    public RunClimb(Climb climb, Enums direction, double seconds) {
        this.climb = climb;
        this.direction = direction;
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        this.finish = (this.seconds != 0) ? (System.currentTimeMillis() + (this.seconds * 1000)) : 0;
    }

    @Override
    public void execute() {
        switch (direction) {
            case UP:
                climb.set(1);
                break;
            case DOWN:
                climb.set(-1);
                break;
        }
    }

    @Override
    public void end(boolean interrupted) {
        climb.set(0);
    }

    @Override
    public boolean isFinished() {
        return this.finish != 0 && System.currentTimeMillis() >= finish;
    }
}
