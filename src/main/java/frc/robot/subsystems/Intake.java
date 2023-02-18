package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.commands.Reset;

public class Intake extends SubsystemBase{
    // Motor + Solenoid config
    private final CANSparkMax topIntakeMotor = new CANSparkMax(Constants.Intake.TOP_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax leftIntakeMotor = new CANSparkMax(Constants.Intake.LEFT_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax rightIntakeMotor = new CANSparkMax(Constants.Intake.RIGHT_INTAKE_ID, MotorType.kBrushless);
    private final Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.INTAKE_SOLENOID_ID);

    // List for quick reset
    private final CANSparkMax[] motors = {topIntakeMotor, leftIntakeMotor, rightIntakeMotor};

    public Intake(){
        Reset.reset(motors);
        leftIntakeMotor.follow(topIntakeMotor);
        rightIntakeMotor.follow(topIntakeMotor, true);
    }

    public void toggleIntake(){
        intakeSolenoid.toggle();
    }

    public void runIntake(){
        if (intakeSolenoid.get()){
            topIntakeMotor.set(0.75);
        }
    }
    
    public void clearIntake(){
        if (intakeSolenoid.get()){
            topIntakeMotor.set(-0.75);
        }
    }

    public void stopIntake(){
        if (intakeSolenoid.get()){
            topIntakeMotor.set(0);
        }
    }
}