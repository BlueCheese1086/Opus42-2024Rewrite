package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Intake extends SubsystemBase{
    // Motor + Solenoid config
    private final CANSparkMax topIntakeMotor = new CANSparkMax(RobotMap.TopIntakeID, MotorType.kBrushless);
    private final CANSparkMax leftIntakeMotor = new CANSparkMax(RobotMap.LeftIntakeID, MotorType.kBrushless);
    private final CANSparkMax rightIntakeMotor = new CANSparkMax(RobotMap.RightIntakeID, MotorType.kBrushless);
    private final Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.IntakeSolenoidID);

    public Intake() {
        leftIntakeMotor.follow(topIntakeMotor);
        rightIntakeMotor.follow(topIntakeMotor, true);
    }

    public void setState(boolean state) {
        intakeSolenoid.set(state);
    }

    public void setSpeed(double speed) {
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