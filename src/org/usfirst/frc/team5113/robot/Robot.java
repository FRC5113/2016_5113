
package org.usfirst.frc.team5113.robot;

import controllers.Arm;
import controllers.DriveController;
import controllers.JoystickController;
import drive.MotorManager;
import controllers.Shooter;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
//Auto-added, not sure if we actually need them... but whatever
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

//This is the main part of the code. It is where the robot looks first
public class Robot extends IterativeRobot 
{
	//This was auto-generated. Not sure if we need it
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    
    
	private MotorManager motorManagers;// this gives us access to the Drive class
	private JoystickController controller;
	private Shooter shoot;
	private Arm arm;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {       
        controller = new JoystickController();
        controller.init();
        motorManagers = new MotorManager();
        motorManagers.init();
        shoot = new Shooter();
        shoot.init();
        arm = new Arm();
        arm.init();
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() 
    {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
    	//This is a test commit to make sure everything works
    	//This is another test commit to make sure the mainTop is now cooperating
        controller.update(motorManagers);
        shoot.update(motorManagers, controller);
        arm.update(motorManagers, controller);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    
    }
    
}
