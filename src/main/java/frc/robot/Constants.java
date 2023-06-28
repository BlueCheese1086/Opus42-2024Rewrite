// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int COMPRESSOR_ID = 0;
    public static final int HOOD_SERVO_ID = 0; // Adjusts launcher angle

    // Assume that all motors are CANSparkMax unless stated otherwise.

    public static class Drivetrain { // Drivetrain Motor IDs
        public static final int FRONT_LEFT_ID = 1;
        public static final int FRONT_RIGHT_ID = 2;
        public static final int BACK_LEFT_ID = 3;
        public static final int BACK_RIGHT_ID = 4;
    }

    public static class Climb { // Climb Motor IDs
        public static final int CLIMB_LEFT_ID = 11;
        public static final int CLIMB_RIGHT_ID = 12;

        public static final int CLIMB_SOLENOID_ID = 2;
    }

    public static class Intake { // Intake Motor IDs
        public static final int LEFT_INTAKE_ID = 21;
        public static final int RIGHT_INTAKE_ID = 22;
        
        public static final int TOP_INTAKE_ID = 31;

        public static final int INTAKE_SOLENOID_ID = 3;
    }

    public static class Tower { // Tower Motor IDs
        public static final int TOWER_ONE_ID = 41; // back top
        public static final int TOWER_TWO_ID = 42; // back bottom
        public static final int TOWER_THREE_ID = 43; // front bottom
        public static final int TOWER_FOUR_ID = 44; // front top
    }

    public static class Shooter { // Shooter Motor IDs
        public static final int LAUNCHER_X_ID = 51; // TalonFX
        public static final int LAUNCHER_Y_ID = 52; // TalonFX

        public static final int HOOD_ID = 0; // Servo
    }
    
    public static class Controllers { // Controller IDs
        public static final int PRIMARY_CONTROLLER_ID = 0; // Main controller
        public static final int SECONDARY_CONTROLLER_ID = 1; // Secondary controller
    }
    
    public static class ShooterConstants { // Constants for the shooter
        public static final double LAUNCHER_DEFAULT_VELOCITY = 9.0; // meters/second

        public static final double LAUNCHER_MIN_ANGLE = 80.2141;
        public static final double LAUNCHER_MAX_ANGLE = 90;

        public static final double CAMERA_HEIGHT = 0.762; // meters
        public static final double CAMERA_ANGLE = 45; // degrees
        public static final double LAUNCHER_WHEEL_DIAMETER = 0.1016; // meters??
        public static final double LAUNCHER_WHEEL_CIRCUMFERENCE = 2 * Math.PI * (LAUNCHER_WHEEL_DIAMETER / 2);
        public static final double LAUNCHER_ENCODER_UNITS_PER_ROTATION = 2048.0;
        public static final double LAUNCHER_MAX_VELOCITY = 6380.0 * 2048.0 / 600.0;

        public static final double UPPER_HUB_HEIGHT = 2.64; // meters
        public static final double GRAVITY = 9.8; // meters/second
        public static final double CARGO_DIAMETER = 0.24;

        // PID values for TalonFX built-in PIDController
        public static final double LAUNCHER_KP = 0.2;
        public static final double LAUNCHER_KI = 0.0;
        public static final double LAUNCHER_KD = 2.8;
        public static final double LAUNCHER_KF = 1100 / LAUNCHER_MAX_VELOCITY;

        public static final double DRIVETRAIN_POSITION_SCALE = (8.98) / (CARGO_DIAMETER * Math.PI); // m -> rotation
        public static final double WHEEL_TO_WHEEL_RADIUS = Math.sqrt(Math.pow(74.72, 2) + Math.pow(52.75, 2)); // cm

        public static final double TURN_ERROR = 0.005 * DRIVETRAIN_POSITION_SCALE; // Rotations
        public static final double DRIVE_ERROR = 0.003 * DRIVETRAIN_POSITION_SCALE; // Rotaions
    }

    public static class DriveConstants { // Constants for the drivetrain
        public static final boolean squareInputs = true;

        public static final double Ks = 0.37003;
        public static final double Kv = 1.1603;
        public static final double Ka = 0.40226;

        public static final double MAX_FORWARD_VELOCITY = 6.0; // meters/second
        public static final double MAX_TURNING_VELOCITY = 20; // radians/second

        // Ramsete stuff
        public static final double b = 1.25;
        public static final double zeta = 1;

        // PID Things
        public static final double MP_DRIVE_FF = 1.0 / 5676.0;
        public static final double MP_DRIVE_KP = 1.0 / 1000.0;
        public static final double MP_DRIVE_KI = 0;
        public static final double MP_DRIVE_KD = 0;

        public static final double TRACK_WIDTH = 0.762; // Meters
        public static final double WHEEL_CIRCUMPHRENCE = Units.inchesToMeters(6 * Math.PI); // Meters
        public static final double GEARBOX_RATIO = 8.89;

        public static final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(TRACK_WIDTH);
        public static final DifferentialDriveWheelSpeeds wheelSpeeds = new DifferentialDriveWheelSpeeds(0.0, 0.0);
    }
}
