package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Enums;
import frc.robot.subsystems.Intake.Intake;

public class SetIntake extends CommandBase {
    private final Intake intake;
    private final Enums direction;

    public SetIntake(Intake intake, Enums direction) {
        this.intake = intake;
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction) {
            case OPEN:
                intake.setState(true);
            case CLOSED:
                intake.setState(false);
        }
    }
}