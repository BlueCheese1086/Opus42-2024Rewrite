package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Intake.Commands.*;
import frc.robot.subsystems.Tower.Tower;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Climb.Climb;

public class Autonomous extends SequentialCommandGroup {
    /**
     * Creates a new Autonomous command.
     *
     * @param drivetrain The drivetrain subsystem used by this command.
     * @param intake The intake subsystem used by this command.
     * @param tower The tower subsystem used by this command.
     * @param shooter The shooter subsystem used by this command.
     * @param climb The climb subsystem used by this command.
     */
    public Autonomous(Drivetrain drivetrain, Intake intake, Tower tower, Shooter shooter, Climb climb) {
        addCommands(
            new DriveDistance(drivetrain, speed, inches),
            new ToggleIntake(intake),
            new RunIntake(intake, speed, seconds),
            new RunTower(tower, speed, seconds),
            new AimShooter(shooter, degrees),
            new RunShooter(shooter, speed, seconds),
            new RunClimb(climb, speed, inches)
        );
    }
}
