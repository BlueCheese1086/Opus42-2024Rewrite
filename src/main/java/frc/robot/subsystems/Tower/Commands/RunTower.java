package frc.robot.subsystems.Tower.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Direction;
import frc.robot.subsystems.Tower.Tower;

public class RunTower extends CommandBase {
    private final Tower tower;
    private final Direction direction;

    public RunTower(Tower tower, Direction direction){
        this.tower = tower;
        this.direction = direction;

        addRequirements(tower);
    }

    @Override
    public void execute() {
        tower.start(direction);
    }

    @Override
    public void end(boolean interr) {
        tower.stop();
    }
}
