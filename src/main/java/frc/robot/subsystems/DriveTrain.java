package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveTrain implements Subsystem {

    private static final PWMTalonFX
        leftMaster = new PWMTalonFX(0),
        leftSlave = new PWMTalonFX(1),
        rightMaster = new PWMTalonFX(2),
        rightSlave = new PWMTalonFX(3);

        private static final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(leftSlave, leftMaster);
        private static final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(rightSlave, rightMaster);
        public static DifferentialDrive m_drive = new DifferentialDrive(leftDriveTrain, rightDriveTrain);
    
        public static void stop(){
            m_drive.arcadeDrive(0.0, 0.0);
        }    

    private DriveTrain() {
        
    }

    private static DriveTrain instance = null;
    public static DriveTrain getInstance(){
        if (instance == null) instance = new DriveTrain();
        return instance;
    }
}

