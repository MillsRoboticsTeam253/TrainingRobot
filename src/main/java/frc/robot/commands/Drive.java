package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class Drive implements Command{
    public enum State {
        CurvatureDrive, ArcadeDrive, TankDrive
    }
    private State state;
    
    public Drive(State state, Drive drive) {
        requirements.add((Subsystem) (drive));
        this.state = state;
    }

    public Drive(DriveTrain driveTrain) {
	}

	@Override
    public void execute() {
        double throttle = RobotContainer.getThrottle();
        double turn = RobotContainer.getTurnValue();

        switch(state) {
            case ArcadeDrive:
                DriveTrain.m_drive.arcadeDrive(throttle, turn);
                break;
            case CurvatureDrive:
                DriveTrain.m_drive.curvatureDrive(throttle, turn, false);
                break;
            case TankDrive:
                DriveTrain.m_drive.tankDrive(throttle, RobotContainer.getThrottle());
                break;
            default:
                DriveTrain.m_drive.curvatureDrive(0.0, 0.0, false);
                break;
        }
    }

    @Override
    public void end(boolean interrupted) {
        DriveTrain.stop();
    }

    private Set<Subsystem> requirements = new HashSet<>();

    @Override
    public Set<Subsystem> getRequirements () {
        return requirements;
    }
    
} 
