package frc.robot.subsystems.Drivetrain.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class ArcadeDrive extends Command{
    private final Drivetrain drivetrain;
    private final Supplier<Double> xSpeedSupplier;
    private final Supplier<Double> zRotationSupplier;

    /**
     * Creates a new ArcadeDrive command.  This command drives the robot using the values of the two speed suppliers.
     * 
     * @param drivetrain The drivetrain subsystem that this command will run on.
     * @param xSpeedSupplier The speed supplier for movement along the x axis.
     * @param zRotationSupplier The speed supplier for rotation along the z axis.
     */
    public ArcadeDrive(Drivetrain drivetrain, Supplier<Double> xSpeedSupplier, Supplier<Double> zRotationSupplier) {
        this.drivetrain = drivetrain;
        this.xSpeedSupplier = xSpeedSupplier;
        this.zRotationSupplier = zRotationSupplier;

        addRequirements(drivetrain);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drivetrain.arcadeDrive(xSpeedSupplier.get(), zRotationSupplier.get());
    }
}