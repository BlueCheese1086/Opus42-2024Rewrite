package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class ClearIntake extends CommandBase {
    private final Intake intake;

    public ClearIntake(Intake intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.clearIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interr) {
        intake.stopIntake();
    }
}
