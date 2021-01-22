package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class Drive implements Command {
    private Set<Subsystem> requirements = new HashSet<>();
    private Drivetrain drivetrain;
    
    public enum State {
        arcadeDrive, curvatureDrive, tankDrive;
    }

    private State state;

    public Drive(State state) {
        requirements.add(drivetrain = Drivetrain.getInstance());
        this.state = state;
    }

    @Override
    public void execute(){
        double throttle = RobotContainer.getThrottle();
        double turn = RobotContainer.getTurn();

        switch(state) {
            case arcadeDrive:
                drivetrain.arcadeDrive(throttle, turn);
                break;
            case curvatureDrive:
                drivetrain.curvatureDrive(throttle, turn, false);
                break;
            case tankDrive:
                drivetrain.tankDrive(throttle, RobotContainer.getAltThrottle());
                break;
            default:
                drivetrain.curvatureDrive(0.0, 0.0, false);
                break;
        }
    }
    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
    @Override
    public Set<Subsystem> getRequirements () {
        return requirements;
    }
}