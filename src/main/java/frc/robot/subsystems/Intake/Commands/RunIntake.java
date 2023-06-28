package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends CommandBase {
    private final Intake intake;
    private final double start;
    private final double seconds;
    private final double speed;

    public RunIntake(Intake intake, double speed, double seconds){
        this.intake = intake;
        this.speed = speed;
        this.seconds = seconds;

        start = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        intake.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - start) >= seconds;
    }

    public void end(boolean interr) {
        intake.setSpeed(0);
    }
}
