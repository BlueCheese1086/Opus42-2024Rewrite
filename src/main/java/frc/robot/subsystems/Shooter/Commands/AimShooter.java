package frc.robot.subsystems.Shooter.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class AimShooter extends CommandBase {
    private final Shooter shooter;
    private final double start;
    private final double seconds;
    private final double speed;

    public AimShooter(Shooter shooter, double speed, double seconds){
        this.shooter = shooter;
        this.speed = speed;
        this.seconds = seconds;

        start = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        shooter.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - start) >= seconds;
    }

    public void end(boolean interr) {
        shooter.setSpeed(0);
    }
}
