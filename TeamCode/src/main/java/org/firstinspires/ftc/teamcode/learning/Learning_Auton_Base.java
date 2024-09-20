package org.firstinspires.ftc.teamcode.learning;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.core.CyDogsChassis;


// The 'extends LinearOpMode' is needed so this code can run the build in op mode code from FIRST.
//    @Autonomous puts this code in the autonomous category on driver station
@Autonomous
@Disabled
public class Learning_Auton_Base extends LinearOpMode {

    /* declare variables
    mjggjkgkjgkjggjk
    */
    @Override
    public void runOpMode() {

        // this lets us see how long the op mode has run

        CyDogsChassis myBot = new CyDogsChassis(this);
        // Put code that should run during initialization HERE in this area

        // Wait for the start button to be pressed on the driver station
        waitForStart();

        if (opModeIsActive()) {
            // Put code that should run during the active mode HERE in this area
            myBot.StrafeLeft(482,.5,500);
            myBot.RotateLeft(90,.7,100);

        }
    }

    private int AddStuff(int a, int b)
    {
        return a+b;

    }
}


