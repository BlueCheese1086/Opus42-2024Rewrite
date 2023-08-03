package frc.robot.subsystems.Drivetrain.Commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class DriveDistance  extends CommandBase {
    private final Drivetrain drivetrain;
    private final double speed;
    private final double inches;
    private final double start;

    public DriveDistance(Drivetrain drivetrain, double speed, double inches){
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.inches = inches;

        drivetrain.
    }

    @Override
    public void execute() {
        drivetrain;
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - start) >= seconds;
    }

    public void end(boolean interr) {
        drivetrain;
    }
}

