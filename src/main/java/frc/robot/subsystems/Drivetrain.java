package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class Drivetrain extends DifferentialDrive implements Subsystem {
    private static Drivetrain instance = null;
    private static SpeedController frontRightMotor = new PWMTalonFX(0),
                                    backRightMotor = new PWMTalonFX(1),
                                    frontLeftMotor = new PWMTalonFX(2),
                                    backLeftMotor = new PWMTalonFX(3);
    private static SpeedControllerGroup rightDrivetrain = new SpeedControllerGroup(frontRightMotor, backRightMotor), 
                                        leftDrivetrain = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    private Drivetrain() {
        // Drivetrain Speedcontrollers
        super(leftDrivetrain, rightDrivetrain);
    }

    public void stop(){
        super.arcadeDrive(0.0, 0.0);
    }

    public static Drivetrain getInstance() {
        if(instance == null) instance = new Drivetrain();
        return instance;
    }
}