package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Direction;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends CommandBase {
    private final Intake intake;
    private final Direction direction;

    public RunIntake(Intake intake, Direction direction){
        this.intake = intake;
        this.direction = direction;
    }

    @Override
    public void execute() {
        intake.start(direction);
    }

    @Override
    public void end(boolean interr) {
        intake.stop();
    }
}
