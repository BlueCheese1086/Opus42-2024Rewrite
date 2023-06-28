package frc.robot;

// Imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link RobotMain}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers
  private final XboxController xbox = new XboxController(0);

  // Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Tower tower = new Tower();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();

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
    drivetrain.setDefaultCommand(tankDrive()); 

    new JoystickButton(xbox, Button.kX.value).onTrue(new ToggleIntake(intake));
    new JoystickButton(xbox, Button.kA.value).whileTrue(new RunIntake(intake));
    new JoystickButton(xbox, Button.kB.value).whileTrue(new ClearIntake(intake));

    new JoystickButton(xbox, Button.kLeftBumper.value).whileTrue(new RunTower(tower));
    new JoystickButton(xbox, Button.kRightBumper.value).whileTrue(new ClearTower(tower));
  }
  
  /**
   * Use this to pass the ArcadeDrive command to the main {@link RobotMain} class.
   * 
   * @return The command to run in teleop.
   */
  public Command arcadeDrive() {
    return new ArcadeDrive(drivetrain, () -> -xbox.getLeftY(), () -> xbox.getRightX(), Constants.DriveConstants.squareInputs);
  }

  /**
   * Use this to pass the TankDrive command to the main {@link RobotMain} class.
   * 
   * @return The command to run in teleop.
   */
  public Command tankDrive(){
    return new TankDrive(drivetrain, () -> -xbox.getLeftY(), () -> -xbox.getRightY(), Constants.DriveConstants.squareInputs);
  }

  /**
   * This passes the Autonomous command to the {@link RobotMain} class.
   */
  public Command autonomous() {
    return new Autonomous(drivetrain, intake, tower, shooter, climb);
  }
}   