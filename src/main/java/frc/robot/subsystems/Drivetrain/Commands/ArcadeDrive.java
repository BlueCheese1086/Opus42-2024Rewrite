package frc.robot.subsystems.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class ArcadeDrive extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final Supplier<Double> xAxisSpeed;
  private final Supplier<Double> zAxisRotate;
  private final boolean squareInputs;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xAxisSpeed, Supplier<Double> zAxisRotate, boolean squareInputs) {
    this.drivetrain = drivetrain;
    this.xAxisSpeed = xAxisSpeed;
    this.zAxisRotate = zAxisRotate;
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
    drivetrain.arcadeDrive(xAxisSpeed.get(), zAxisRotate.get(), squareInputs);
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