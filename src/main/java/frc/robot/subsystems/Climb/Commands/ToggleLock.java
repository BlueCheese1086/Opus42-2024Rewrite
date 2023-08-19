package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Climb.Climb;

public class ToggleLock extends CommandBase {
    private final Climb climb;

    public ToggleLock(Climb climb) {
        this.climb = climb;
    }

    @Override
    public void execute() {
        climb.toggleLock();
    }
}