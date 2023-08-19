package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants.Direction;
import frc.robot.subsystems.Climb.Climb;
import frc.robot.subsystems.Climb.Commands.*;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Drivetrain.Commands.*;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Intake.Commands.*;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Shooter.Commands.*;
import frc.robot.subsystems.Tower.Tower;
import frc.robot.subsystems.Tower.Commands.*;

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
        double speed = 1;
        double inches = 1;
        double seconds = 1;
        double degrees = 1;
        
        addCommands(
            new DriveDistance(drivetrain, speed, inches),
            new RunClimb(climb, Direction.UP, seconds), // This might not work the way I think it works...
            new RunIntake(intake, Direction.DOWN, seconds),
            new RunShooter(shooter, Direction.UP, seconds),
            new RunTower(tower, Direction.UP, seconds),
            new ToggleIntake(intake),
            new TurnDistance(drivetrain, speed, degrees)
        );
    }
}
