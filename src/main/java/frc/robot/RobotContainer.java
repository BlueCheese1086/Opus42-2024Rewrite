package frc.robot;

// Imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.Intake.*;
import frc.robot.commands.Tower.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link RobotMain}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers
  private final Joystick joystick = new Joystick(1);
  private final XboxController xbox = new XboxController(2);

  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Tower tower = new Tower();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button-based command mappings. Buttons can be created by
   * creating an instance of {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Default command is xboxArcadeDrive. This command will run unless another command is listed below.
    drivetrain.setDefaultCommand(xboxTankDrive()); 
    
    new JoystickButton(joystick, 2).onTrue(new ToggleIntake(intake)); // Opens and closes the intake.
    new JoystickButton(joystick, 1).whileTrue(new RunIntake(intake)); // Runs the intake.
    new JoystickButton(joystick, 3).whileTrue(new ClearIntake(intake)); // Runs the intake, but in reverse.

    new JoystickButton(joystick, 5).whileTrue(new RunTower(tower)); // Runs the tower.
    new JoystickButton(joystick, 6).whileTrue(new ClearTower(tower)); // Runs the tower, but in reverse.
    
    /*
    new JoystickButton(xbox, Button.kX.value).onTrue(new ToggleIntake(intake));
    new JoystickButton(xbox, Button.kA.value).whileTrue(new RunIntake(intake));
    new JoystickButton(xbox, Button.kB.value).whileTrue(new ClearIntake(intake));

    new JoystickButton(xbox, Button.kLeftBumper.value).whileTrue(new RunTower(tower));
    new JoystickButton(xbox, Button.kRightBumper.value).whileTrue(new ClearTower(tower));
    */
  }

  // NOTE: All commands with "Joystick" in the name may require extra modification due to differences in joystick mapping.

  /**
   * Use this to pass the ArcadeDrive command to the main {@link RobotMain} class.
   * Input type: Joystick
   * 
   * @return The command to run in teleop.
   */
  public Command joystickArcadeDrive() {
    return new ArcadeDrive(drivetrain, () -> joystick.getRawAxis(2), () -> -joystick.getRawAxis(1), Constants.Drivetrain.squareInputs);
  }
  
  /**
   * Use this to pass the ArcadeDrive command to the main {@link RobotMain} class.
   * Input type: Xbox Remote
   * 
   * @return The command to run in teleop.
   */
  public Command xboxArcadeDrive() {
    return new ArcadeDrive(drivetrain, () -> -xbox.getLeftY(), () -> xbox.getRightX(), Constants.Drivetrain.squareInputs);
  }

  /**
   * Use this to pass the TankDrive command to the main {@link RobotMain} class.
   * Input type: Joystick
   * @return The command to run in teleop.
   */
  public Command joystickTankDrive(){
    return new TankDrive(drivetrain, () -> joystick.getRawAxis(2), () -> joystick.getRawAxis(1), Constants.Drivetrain.squareInputs);
  }

  /**
   * Use this to pass the TankDrive command to the main {@link RobotMain} class.
   * Input type: Xbox Remote
   * 
   * @return The command to run in teleop.
   */
  public Command xboxTankDrive(){
    return new TankDrive(drivetrain, () -> -xbox.getLeftY(), () -> -xbox.getRightY(), Constants.Drivetrain.squareInputs);
  }
}   