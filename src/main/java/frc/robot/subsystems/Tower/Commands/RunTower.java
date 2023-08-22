package frc.robot.subsystems.Tower.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Enums;
import frc.robot.subsystems.Tower.Tower;

public class RunTower extends CommandBase {
    private final Tower tower;
    private final Enums direction;

    public RunTower(Tower tower, Enums direction) {
        this.tower = tower;
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction) {
            case UP:
                tower.set(1);
            case DOWN:
                tower.set(-1);
        }
    }

    @Override
    public void end(boolean interrupted) {
        tower.set(0);
    }
}