package org.firstinspires.ftc.teamcode.centerstage;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.core.CyDogsChassis;

@Autonomous
@Disabled
public class Learning_Auton_3 extends LinearOpMode {
// This is a SHORT side Auton

    CyDogsChassis myBot = new CyDogsChassis(this);

    // This is a SHORT side Auton
    @Override
    public void runOpMode() {

        ElapsedTime runtime = new ElapsedTime();

        // Wait for the start button to be pressed on the driver station
        waitForStart();



        if (opModeIsActive()) {
          myBot.MoveStraight(2000,0.5,300);
          myBot.RotateRight(920,.5,300);
          myBot.RotateLeft(920,.5,300);


        }
    }


}


