package frc.robot.subsystems.Tower.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower.Tower;

public class RunTower extends CommandBase {
    private final Tower tower;

    public RunTower(Tower tower){
        this.tower = tower;
    }

    @Override
    public void execute() {
        tower.runTower();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public void end(boolean interr) {
        tower.stopTower();
    }
}
