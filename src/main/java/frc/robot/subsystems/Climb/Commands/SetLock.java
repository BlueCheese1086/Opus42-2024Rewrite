package frc.robot.subsystems.Climb.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Enums;
import frc.robot.subsystems.Climb.Climb;

public class SetLock extends CommandBase {
    private final Climb climb;
    private final Enums direction;

    public SetLock(Climb climb, Enums direction) {
        this.climb = climb;
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction) {
            case ON:
                climb.unlock();
            case OFF:
                climb.lock();
        }
    }
}