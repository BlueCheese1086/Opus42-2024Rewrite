package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Drivetrain.Commands.*;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Intake.Commands.*;
import frc.robot.subsystems.Tower.Tower;
import frc.robot.subsystems.Tower.Commands.*;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Shooter.Commands.*;
import frc.robot.Constants.Direction;
import frc.robot.subsystems.Climb.Climb;
import frc.robot.subsystems.Climb.Commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers
  private final XboxController xboxController = new XboxController(2);

  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Tower tower = new Tower();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();

  /** The container for the robot. Contains subsystems, IO devices, commands, and button mappings. */
  public RobotContainer() {
    new JoystickButton(xboxController, 2).onTrue(new ToggleIntake(intake));
    new JoystickButton(xboxController, 1).whileTrue(new RunIntake(intake, Direction.Up));
    new JoystickButton(xboxController, 3).whileTrue(new RunIntake(intake, Direction.Down));

    new JoystickButton(xboxController, Button.kRightBumper.value).whileTrue(new RunTower(tower, Direction.Up));
    new Trigger(() -> xboxController.getLeftTriggerAxis() > 0).whileTrue(new RunTower(tower, Direction.Down));

    new JoystickButton(xboxController, Button.kLeftBumper.value).whileTrue(new RunClimb(climb, Direction.Up));
    new Trigger(() -> xboxController.getRightTriggerAxis() > 0).whileTrue(new RunClimb(climb, Direction.Down));
  }
  
  /** This passes the Teleop command to the main {@link Robot} class. */
  public Command getTeleopCommand() {
    return new ArcadeDrive(drivetrain, () -> -xboxController.getLeftY(), () -> xboxController.getRightX());
  }

  /** This passes the Autonomous command to the {@link Robot} class. */
  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain, intake, tower, shooter, climb);
  }
}   