//CRISTOPHER DANIEL ZAPATA CANTÚ (EDUCACIÓN STEAM - Modelos Formativos)
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {

   //CONTROL
  Joystick xbox = new Joystick(0);

  // MOTORES DERECHOS
  WPI_TalonSRX MR1 = new WPI_TalonSRX(1);
  WPI_TalonSRX MR2 = new WPI_TalonSRX(2);
  
  // MOTORES IZQUIERDOS
  WPI_TalonSRX ML1 = new WPI_TalonSRX(3);
  WPI_TalonSRX ML2 = new WPI_TalonSRX(4);

  //INTAKE (Motor / Valvula)
  WPI_TalonSRX MInt = new WPI_TalonSRX(5);
  Solenoid Valv = new Solenoid(PneumaticsModuleType.CTREPCM,6);
  
  //SHOOTER
  WPI_TalonSRX Msht1 = new WPI_TalonSRX(7);
  WPI_TalonSRX Msht2 = new WPI_TalonSRX(8);

  DifferentialDrive Shooter = new DifferentialDrive(Msht1,Msht2);

  // AGRUPACIÓN POR LADO
  MotorControllerGroup motoresR = new MotorControllerGroup(MR1, MR2);
  MotorControllerGroup motoresL = new MotorControllerGroup(ML1, ML2);

  // CHASSIS
  DifferentialDrive Robotcito = new DifferentialDrive(motoresR,motoresL);

  //FUNCIONES 
  public void Intake(boolean state, double speed){
    Valv.set(state);
    MInt.set(speed);
  }

  public void Shoot(int speed){
    Shooter.arcadeDrive(speed,0); //No se usa el eje Z
  }

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    //ROBOT CONTROLADO (Palanca izquierda)
    Robotcito.arcadeDrive(xbox.getRawAxis(1), xbox.getRawAxis(2));

    //CONTROL DE INTAKE
    if(xbox.getRawButton(3)){
      Intake(true,1); //SALE (Boton X)
    }else if(xbox.getRawButton(2)){
      Intake(false,-1); //ENTRA (Boton B)
    }else{
      Intake(false,0); //QUIETO 
    }

    //CONTROL DE SHOOTER 
    if(xbox.getRawButton(4)){
      Shoot(1); //DISPARA (Boton Y)
    }else if(xbox.getRawButton(2)){
      Shoot(0); //QUIETO
    }

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}

