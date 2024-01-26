package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Intake.Intake;

public class SetIntake extends Command {
    private final Intake intake;
    private final boolean state;
    
    public SetIntake(Intake intake, boolean state) {
        this.intake = intake;
        this.state = state;
    }

    @Override
    public void execute() {
        intake.setState(state);
    }
}