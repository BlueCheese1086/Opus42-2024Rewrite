package frc.robot;

// Imports
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The virtual machine is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation.
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private Command teleopCommand;

  /**
   * This function is run when the robot is first started up and should be used for any initialization code.
   */
  @Override
  public void robotInit() {
    // Creates our RobotContainer.  This will create all our button bindings, and put our chosen drive programs on the dashboard.
    RobotContainer robotContainer = new RobotContainer();

    this.autonomousCommand = robotContainer.getAutonomousCommand();
    this.teleopCommand = robotContainer.getTeleopCommand();
  }

  /**
   * This function is called every 20 ms regardless of mode. Use this for items like diagnostics that you want to run constantly.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Autonomous mode. */
  @Override
  public void autonomousInit() {
    autonomousCommand.schedule();
  }

  /** This function is called once each time the robot exits Autonomous mode. */
  @Override
  public void autonomousExit() {
    autonomousCommand.cancel();
  }

  /** This function is called once each time the robot enters Teleop mode. */
  @Override
  public void teleopInit() {
    teleopCommand.schedule();
  }

  /** This function is called once each time the robot exits Teleop mode. */
  @Override
  public void teleopExit() {
    teleopCommand.cancel();
  }
}