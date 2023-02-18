package frc.robot.commands.Drivetrain;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final Supplier<Double> leftMotor;
  private final Supplier<Double> rightMotor;
  private final boolean squareInputs;

  /**
   * Creates a new TankDrive command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TankDrive(Drivetrain drivetrain, Supplier<Double> leftMotor, Supplier<Double> rightMotor, boolean squareInputs) {
    this.drivetrain = drivetrain;
    this.leftMotor = leftMotor;
    this.rightMotor = rightMotor;
    this.squareInputs = squareInputs;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.tankDrive(leftMotor.get(), rightMotor.get(), squareInputs);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
