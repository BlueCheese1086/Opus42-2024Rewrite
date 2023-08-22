package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Drivetrain;

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
    xButton.onTrue(new InstantCommand(() -> intake.toggleIntake(), intake)); // Toggles the state of the intake.  Maybe.  Im trying this in a new way that may limit the amount of files I need.
    aButton.whileTrue(new InstantCommand(() -> intake.setSpeed(1), intake)); // Runs the intake.
    bButton.whileTrue(new InstantCommand(() -> intake.setSpeed(-1), intake)); // Runs the intake in reverse.

    leftBumper.onTrue(new InstantCommand(() -> climb.setLock(false), climb)); // Unlocks the climb mechanism when you want to use it.
    leftBumper.whileTrue(new InstantCommand(() -> climb.setSpeed(1), climb)); // Moves the climb mechanism up.
    leftBumper.onFalse(new InstantCommand(() -> climb.setLock(true), climb)); // Locks the climb mechanism to prevent it from moving.
    leftTrigger.onTrue(new InstantCommand(() -> climb.setLock(false), climb)); // Unlocks the climb mechanism when you want to use it.
    leftTrigger.whileTrue(new InstantCommand(() -> climb.setSpeed(-1), climb)); // Moves the climb mechanism down.
    leftTrigger.onFalse(new InstantCommand(() -> climb.setLock(true), climb)); // Locks the climb mechanism to prevent it from moving.
    leftStick.onTrue(new InstantCommand(() -> climb.toggleLock(), climb)); // Manually toggles the lock on the climb subsystem.

    rightBumper.whileTrue(new InstantCommand(() -> tower.setSpeed(1), tower)).whileTrue(new InstantCommand(() -> shooter.setSpeed(1), shooter)); // Runs the tower up and runs the shooter.
    rightTrigger.whileTrue(new InstantCommand(() -> tower.setSpeed(1), tower)); // Runs the tower down.
  }

  /** Use this to pass the Teleop command to the main {@link Robot} class. */
  public Command getTeleopCommand() {
    return new InstantCommand(() -> drivetrain.arcadeDrive(-xbox.getLeftY(), xbox.getRightX()), drivetrain);
  }
}