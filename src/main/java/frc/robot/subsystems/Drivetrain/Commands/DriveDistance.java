package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class DriveDistance  extends CommandBase {
    private final Drivetrain drivetrain;
    private final double speed;
    private final double inches;

    public DriveDistance(Drivetrain drivetrain, double speed, double inches){
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.inches = inches;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed, 0);
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getAverageDistanceInch() == inches;
    }

    @Override
    public void end(boolean interr) {
        drivetrain.arcadeDrive(0, 0);
    }
}