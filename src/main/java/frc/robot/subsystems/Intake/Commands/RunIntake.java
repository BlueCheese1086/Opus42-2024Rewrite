package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.Enums;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends CommandBase {
    private final Intake intake;
    private final Enums direction;
    private double start;
    private double seconds;

    public RunIntake(Intake intake, Enums direction) {
        this.intake = intake;
        this.direction = direction;
    }

    public RunIntake(Intake intake, Enums direction, double seconds) {
        this.intake = intake;
        this.direction = direction;
        this.seconds = seconds;

        start = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        switch (direction) {
            case IN:
                intake.set(1);
                break;
            case OUT:
                intake.set(-1);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return (start == 0.0) ? false : (System.currentTimeMillis() - start) >= seconds;
    }

    public void end(boolean interr) {
        intake.set(0);
    }
}