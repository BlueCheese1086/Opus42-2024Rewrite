package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends CommandBase {
    private final Intake intake;

    public ToggleIntake(Intake intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.toggleIntake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    public void end(boolean interr) {}
}
