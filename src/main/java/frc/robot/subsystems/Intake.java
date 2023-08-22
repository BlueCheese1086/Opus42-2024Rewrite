package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Intake extends SubsystemBase {
    // Motor Config
    private final CANSparkMax topIntakeMotor = new CANSparkMax(RobotMap.TOP_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax leftIntakeMotor = new CANSparkMax(RobotMap.LEFT_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax rightIntakeMotor = new CANSparkMax(RobotMap.RIGHT_INTAKE_ID, MotorType.kBrushless);
    
    // Solenoid Config
    private final Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.INTAKE_SOLENOID_ID);

    /** Creates a new Intake subsystem. */
    public Intake() {
        leftIntakeMotor.follow(topIntakeMotor);
        rightIntakeMotor.follow(topIntakeMotor, true);
    }

    /** Sets the speed of the intake motors. */
    public void setSpeed(double speed) {
        if (intakeSolenoid.get()){
            topIntakeMotor.set(speed);
        }
    }

    /** Gets the speed of the intake motors. */
    public double getSpeed() {
        return topIntakeMotor.get();
    }

    /** Sets the state of the intake solenoid. */
    public void setState(boolean state) {
        intakeSolenoid.set(state);
    }
    
    /** Gets the state of the intake solenoid. */
    public boolean getState() {
        return intakeSolenoid.get();
    }

    public void toggleIntake() {
        intakeSolenoid.toggle();
    }
}