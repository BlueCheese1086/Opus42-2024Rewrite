package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class ToggleIntake extends CommandBase {
    private final Intake intake;

    public ToggleIntake(Intake intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.toggleIntake();
    }
}
