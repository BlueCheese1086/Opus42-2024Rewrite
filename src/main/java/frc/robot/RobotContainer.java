package frc.robot;

// Imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants.Enums;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Drivetrain.Commands.*;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Intake.Commands.*;
import frc.robot.subsystems.Tower.Tower;
import frc.robot.subsystems.Tower.Commands.*;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Shooter.Commands.*;
import frc.robot.subsystems.Climb.Climb;
import frc.robot.subsystems.Climb.Commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Creates Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Tower tower = new Tower();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();

  // Creates Controllers
  private final XboxController xbox = new XboxController(0);

  // Creates Buttons
  private JoystickButton aButton, bButton, xButton, leftBumper, rightBumper, leftStick;
  private AxisButton leftTrigger, rightTrigger;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Initializes buttons
    aButton = new JoystickButton(xbox, Button.kA.value);
    bButton = new JoystickButton(xbox, Button.kB.value);
    xButton = new JoystickButton(xbox, Button.kX.value);
    leftBumper = new JoystickButton(xbox, Button.kLeftBumper.value);
    rightBumper = new JoystickButton(xbox, Button.kRightBumper.value);
    leftStick = new JoystickButton(xbox, Button.kLeftStick.value);
    leftTrigger = new AxisButton(xbox, Axis.kLeftTrigger.value, 0.5);
    rightTrigger = new AxisButton(xbox, Axis.kRightTrigger.value, 0.5);

    // Configures the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button-based command mappings. Buttons can be created by
   * creating an instance of {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xButton.onTrue(new SetIntake(intake, (intake.getState()) ? Enums.IN : Enums.OUT)); // Toggles the state of the intake.
    aButton.whileTrue(new RunIntake(intake, Enums.IN)); // Runs the intake.
    bButton.whileTrue(new RunIntake(intake, Enums.OUT)); // Runs the intake in reverse.

    leftBumper.onTrue(new SetLock(climb, Enums.OFF)); // Unlocks the climb mechanism when you want to use it.
    leftBumper.whileTrue(new RunClimb(climb, Enums.UP)); // Moves the climb mechanism up.
    leftBumper.onFalse(new SetLock(climb, Enums.ON)); // Locks the climb mechanism to prevent it from moving.
    leftTrigger.onTrue(new SetLock(climb, Enums.OFF)); // Unlocks the climb mechanism when you want to use it.
    leftTrigger.whileTrue(new RunClimb(climb, Enums.DOWN)); // Moves the climb mechanism down.
    leftTrigger.onFalse(new SetLock(climb, Enums.ON)); // Locks the climb mechanism to prevent it from moving.
    leftStick.onTrue(new SetLock(climb, climb.getLock() ? Enums.ON : Enums.OFF)); // Manually toggles the lock on the climb subsystem.

    rightBumper.whileTrue(new RunTower(tower, Enums.UP)).whileTrue(new RunShooter(shooter)); // Runs the tower up and runs the shooter.
    rightTrigger.whileTrue(new RunTower(tower, Enums.DOWN)); // Runs the tower down.
  }

  /** Use this to pass the Teleop command to the main {@link Robot} class. */
  public Command getTeleopCommand() {
    return new ArcadeDrive(drivetrain, () -> -xbox.getLeftY(), () -> xbox.getRightX(), Constants.DriveConstants.squareInputs);
  }

  /** This passes the Autonomous command to the {@link Robot} class. */
  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain, intake, tower, shooter, climb);
  }
}   