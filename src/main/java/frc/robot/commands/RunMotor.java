package frc.robot.commands;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Motors;

public class RunMotor implements Command {
    private Motors motors;
    
    public RunMotor(Motors motors) {
        requirements.add(this.motors = motors);
    }
    
    @Override
    public void execute() {
        // run at half speed
        motors.run(0.5);
    }

    @Override
    public void end(boolean interrupted) {
    }
    
    private Set<Subsystem> requirements = new HashSet<>();
    
    @Override
    public Set<Subsystem> getRequirements () {
        return requirements;
    }
}
