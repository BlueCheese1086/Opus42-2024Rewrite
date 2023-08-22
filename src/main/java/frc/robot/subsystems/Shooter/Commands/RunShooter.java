package frc.robot.subsystems.Shooter.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class RunShooter extends CommandBase {
    private final Shooter shooter;
    private double seconds;
    private double finish;

    public RunShooter(Shooter shooter){
        this.shooter = shooter;
    }

    public RunShooter(Shooter shooter, double seconds) {
        this.shooter = shooter;
        this.seconds = seconds;
    }

    @Override
    public void initialize() {
        this.finish = (this.seconds != 0) ? (System.currentTimeMillis() + (this.seconds * 1000)) : 0;
    }

    @Override
    public void execute() {
        shooter.set(1);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.set(0);
    }

    @Override
    public boolean isFinished() {
        return this.finish != 0 && System.currentTimeMillis() >= finish;
    }
}
