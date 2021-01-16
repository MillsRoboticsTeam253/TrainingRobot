/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunMotor;
import frc.robot.subsystems.Motors;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
   
  // Subsystems
  private static Motors motors;
  
  // Controllers
  private static final XboxController controller = new XboxController(Constants.IO.Controller.kPort);
  private static final JoystickButton controller_X = new JoystickButton(controller, 3);
   
  private static RobotContainer instance;
  public static RobotContainer getInstance() {
    if (instance == null) instance = new RobotContainer();
    return instance;
  }
  
  //translate y-coordinate of xbox left joystick to a motor speed value
  public static double getMotorSpeed() {
    return controller.getY(GenericHID.Hand.kLeft);
  }

  private RobotContainer() {
    // Initialize our subsystems
    initSubsystems();
    
    // Bind operator input to Commands
    bindIO();
  }
  
  /**
   * Binds operator input to Commands
   */
  private void bindIO() {
    motors.setDefaultCommand(new RunMotor(motors));
  }
  
  private void initSubsystems() {
    motors = Motors.getInstance();
  }
}
