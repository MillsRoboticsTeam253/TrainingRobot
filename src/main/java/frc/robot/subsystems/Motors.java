package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;

import frc.robot.Constants;

public class Motors implements Subsystem {
  public static final WPI_TalonSRX talon = new WPI_TalonSRX(Constants.Drive.kTalon);
  
  private static Motors instance;
  public static Motors getInstance() {
    if (instance == null) instance = new Motors();
    return instance;
  }

  /**
   * All our subsystems are singletons to avoid headaches later on.
   */
  private Motors() {}
  
  // runs the motors to a speed [0, 1]
  public void run(int speed) {
    talon.set(speed);
  }
  
  // stops the motors
  public void stop() {
    this.run(0);
  }
}
