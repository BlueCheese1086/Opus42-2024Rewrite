package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {
    private final Intake intake;

    public RunIntake(Intake intake){
        this.intake = intake;
    }

    @Override
    public void execute() {
        intake.runIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interr) {
        intake.stopIntake();
    }
}
