package frc.robot.commands.Tower;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class ClearTower extends CommandBase {
    private final Tower tower;

    public ClearTower(Tower tower){
        this.tower = tower;
    }

    @Override
    public void execute() {
        tower.clearTower();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interr) {
        tower.stopTower();
    }
}
