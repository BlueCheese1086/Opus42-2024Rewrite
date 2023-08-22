package frc.robot.subsystems.Shooter.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class AimShooter extends CommandBase {
    private final Shooter shooter;
    private final double degrees;

    public AimShooter(Shooter shooter, double degrees){
        this.shooter = shooter;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        shooter.setHoodPosition(degrees);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
