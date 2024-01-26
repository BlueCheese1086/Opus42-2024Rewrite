package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Climb.Climb;

public class RunClimb extends Command {
    private final Climb climb;
    private final double speed;

    public RunClimb(Climb climb, double speed) {
        this.climb = climb;
        this.speed = speed;
    }

    @Override
    public void execute() {
        climb.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        climb.setSpeed(0);
    }
}