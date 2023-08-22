package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.MotorIds;

public class Intake extends SubsystemBase{
    // Motor + Solenoid config
    private final CANSparkMax topIntakeMotor = new CANSparkMax(MotorIds.TOP_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax leftIntakeMotor = new CANSparkMax(MotorIds.LEFT_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax rightIntakeMotor = new CANSparkMax(MotorIds.RIGHT_INTAKE_ID, MotorType.kBrushless);
    private final Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, MotorIds.INTAKE_SOLENOID_ID);

    public Intake() {
        leftIntakeMotor.follow(topIntakeMotor);
        rightIntakeMotor.follow(topIntakeMotor, true);
    }

    public void setState(boolean state) {
        intakeSolenoid.set(state);
    }

    public void set(double speed) {
        if (intakeSolenoid.get()){
            topIntakeMotor.set(speed);
        }
    }

    public double get() {
        return topIntakeMotor.get();
    }
    
    public boolean getState() {
        return intakeSolenoid.get();
    }
}