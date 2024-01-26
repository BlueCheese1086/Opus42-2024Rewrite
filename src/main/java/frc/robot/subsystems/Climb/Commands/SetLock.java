package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Climb.Climb;

public class SetLock extends Command {
    private final Climb climb;
    private final boolean state;

    public SetLock(Climb climb, boolean state) {
        this.climb = climb;
        this.state = state;
    }

    @Override
    public void execute() {
        climb.setLock(state);
    }
}