package org.firstinspires.ftc.teamcode.intothedeep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.centerstage.CyDogsChassis;

// The 'extends LinearOpMode' is needed so this code can run the build in op mode code from FIRST.
//    @Autonomous puts this code in the autonomous category on driver station
@Autonomous
public class test_movement_code extends LinearOpMode {

    // This creates a new instance of our robot code that we can use.  We need to pass 'this' into it because 'this'
    //   represents our LinearOpMode, and that lets our robot code access the current op mode
    org.firstinspires.ftc.teamcode.centerstage.CyDogsChassis myBot = new CyDogsChassis(this);

    @Override
    public void runOpMode() {

        // this lets us see how long the op mode has run
        ElapsedTime runtime = new ElapsedTime();

        // Put code that should run during initialization HERE in this area

        // Wait for the start button to be pressed on the driver station
        waitForStart();

        if (opModeIsActive()) {
            // Put code that should run during the active mode HERE in this area

myBot.MoveStraight(1000,0.5,300);
  myBot.StrafeLeft(1000, 0.4, 400);
  myBot.StrafeRight(2000,0.4, 500);
  myBot.StrafeLeft(1000, 0.4, 400);
  myBot.MoveStraight(-1000, 0.5, 300);
  myBot.MoveStraight(2000, 0.5, 400);
  myBot.RotateLeft(180, 0.5, 400);
  myBot.RotateRight(90, 0.5, 400);
  myBot.StrafeLeft(2000, 0.5, 400);
  myBot.MoveStraight(3000, 0.5, 400);
  myBot.StrafeRight(3000, 0.5,400);
  myBot.MoveStraight(-3000, 0.5, 400);
  myBot.StrafeLeft(6000, 0.5, 400);
  myBot.MoveStraight(3000, 0.5, 400);
  myBot.StrafeRight(3000, 0.5, 400);
  myBot.MoveStraight(-3000, 0.5, 400);
        }
    }
}


