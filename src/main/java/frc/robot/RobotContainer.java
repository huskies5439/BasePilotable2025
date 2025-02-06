// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.subsystems.BasePilotable;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.events.EventTrigger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final BasePilotable basePilotable = new BasePilotable();
  
  
  CommandXboxController manette = new CommandXboxController(0);
  
  public RobotContainer() {
    new EventTrigger("monte").whileTrue(Commands.print("monte"));
   // new EventTrigger("sortir").whileTrue(Commands.print("sortir"));
   NamedCommands.registerCommand("sortir", Commands.print("Sortir"));
    
    configureButtonBindings();

    // Commandes par défaut
    basePilotable.setDefaultCommand(
        Commands.run(
            () -> basePilotable.conduire(
                manette.getLeftY(), manette.getLeftX(), manette.getRightX(),
                true,  true),
            basePilotable));
}


  private void configureButtonBindings() {
    

  }


  public Command getAutonomousCommand() {
    return new PathPlannerAuto("Test");
  }

}
