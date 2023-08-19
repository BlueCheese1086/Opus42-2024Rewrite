package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.Direction;
import frc.robot.Constants.RobotMap;

public class Intake extends SubsystemBase{
    // Motor + Solenoid config
    private final CANSparkMax topIntakeMotor = new CANSparkMax(RobotMap.TOP_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax leftIntakeMotor = new CANSparkMax(RobotMap.LEFT_INTAKE_ID, MotorType.kBrushless);
    private final CANSparkMax rightIntakeMotor = new CANSparkMax(RobotMap.RIGHT_INTAKE_ID, MotorType.kBrushless);
    private final Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.INTAKE_SOLENOID_ID);

    public Intake() {
        leftIntakeMotor.follow(topIntakeMotor);
        rightIntakeMotor.follow(topIntakeMotor, true);
    }

    public void toggleIntake() {
        intakeSolenoid.toggle();
    }

    public void start(Direction direction) {
        if (intakeSolenoid.get()){
            switch (direction) {
                case UP:
                    topIntakeMotor.set(1);
                    leftIntakeMotor.set(1);
                    rightIntakeMotor.set(1);
                    break;
                case DOWN:
                    topIntakeMotor.set(-1);
                    leftIntakeMotor.set(-1);
                    rightIntakeMotor.set(-1);
                    break;
            }
        }
    }

    public void stop() {
        topIntakeMotor.set(0);
        leftIntakeMotor.set(0);
        rightIntakeMotor.set(0);
    }
}