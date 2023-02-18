package frc.robot.commands;

import com.revrobotics.CANSparkMax;

public class Reset {
    public static void reset(CANSparkMax[] motors){
        for (CANSparkMax motor : motors){
            motor.restoreFactoryDefaults();
        }
    }
}
