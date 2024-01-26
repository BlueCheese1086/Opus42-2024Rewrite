package frc.robot.subsystems.Tower.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.Tower.Tower;

public class AimShooter extends Command {
    private final Tower tower;
    private final double degrees;

    public AimShooter(Tower tower, double degrees) {
        this.tower = tower;
        this.degrees = degrees;
    }

    @Override
    public void execute() {
        tower.setHoodPosition(degrees);
    }
}