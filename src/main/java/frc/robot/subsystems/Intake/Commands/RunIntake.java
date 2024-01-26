package frc.robot.subsystems.Intake.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends Command {
    private final Intake intake;
    private final double speed;

    public RunIntake(Intake intake, double speed) {
        this.intake = intake;
        this.speed = speed;
    }

    @Override
    public void execute() {
        intake.setSpeed(speed);
    }
}