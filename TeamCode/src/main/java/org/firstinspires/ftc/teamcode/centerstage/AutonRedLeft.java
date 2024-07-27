package org.firstinspires.ftc.teamcode.centerstage;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.*;
@Autonomous
@Disabled
public class AutonRedLeft extends LinearOpMode {
    SpikeCam.location mySpikeLocation;

// This is a LONG side Auton
    @Override
    public void runOpMode() {
        ElapsedTime runtime = new ElapsedTime();

        telemetry.addLine("Starting Initialization");

        // Set defaults for initialization options
        CyDogsChassis.Direction parkingSpot = CyDogsChassis.Direction.LEFT;
        CyDogsChassis.Direction drivePath = CyDogsChassis.Direction.LEFT;

        // Create the instance of sparky, initialize the SpikeCam, devices, and positions
        CyDogsSparky mySparky = new CyDogsSparky(this, CyDogsChassis.Alliance.RED, 430);
        mySparky.initializeSpikeCam();
        mySparky.initializeDevices();

        mySparky.initializeAprilTags();

        // Ask the initialization questions
        parkingSpot = mySparky.askParkingSpot();
     //   drivePath = mySparky.askDrivePath();

        // Wait for the start button to be pressed on the driver station
        waitForStart();



        if(opModeIsActive()) {
            mySparky.initializePositions();
            sleep(300);
            int extraVerticalMovement=0;
            mySpikeLocation = mySparky.spikeCam.getSpikeLocation();

            // Get to standard position before placing purple pixel
            mySparky.MoveStraight(-300, .5, mySparky.StandardAutonWaitTime);

            if(mySpikeLocation==SpikeCam.location.LEFT)
            {
                mySparky.StrafeLeft(100,0.5, mySparky.StandardAutonWaitTime);
            }
            else if(mySpikeLocation==SpikeCam.location.MIDDLE) {
                mySparky.StrafeLeft(100,0.5, mySparky.StandardAutonWaitTime);
            }
            else {  //RIGHT
                mySparky.StrafeLeft(90,0.5, mySparky.StandardAutonWaitTime);
            }

            mySparky.MoveStraight(-445, .5, mySparky.StandardAutonWaitTime);


            // Place purple pixel and back away from it
            mySparky.AutonPlacePurplePixel(mySpikeLocation);
            int backAwayFromPurple = 20;
            if(mySpikeLocation== SpikeCam.location.MIDDLE){
                backAwayFromPurple=85;
            }
            else if(mySpikeLocation==SpikeCam.location.RIGHT)
            {
                backAwayFromPurple=20+CyDogsSparky.BackUpDistanceFromSpike+50;
            }
            mySparky.MoveStraight(backAwayFromPurple, .5, mySparky.StandardAutonWaitTime);


            switch (mySpikeLocation) {
                case LEFT:
                    extraVerticalMovement-=50;
                //    mySparky.MoveStraight(mySparky.BackUpDistanceFromSpike,.5,mySparky.StandardAutonWaitTime);
               //    mySparky.raiseArmToScore(400);
                //    sleep(300);
                    mySparky.StrafeLeft(CyDogsSparky.OneTileMM, .5, mySparky.StandardAutonWaitTime);
                //    mySparky.RotateRight(2,.5,mySparky.StandardAutonWaitTime);
               //     mySparky.raiseArmToScore(0);
                    break;
                case MIDDLE:

                    mySparky.RotateLeft(91,.5,mySparky.StandardAutonWaitTime);

                    mySparky.MoveStraight(-CyDogsChassis.OneTileMM+180,.5,mySparky.StandardAutonWaitTime);
                    mySparky.StrafeLeft(CyDogsSparky.OneTileMM+240,.5,500);
                    //mySparky.MoveStraight(CyDogsChassis.OneTileMM,.5,mySparky.StandardAutonWaitTime);
                    extraVerticalMovement+=410;

                    break;
                case RIGHT:
                case NOT_FOUND:
                    extraVerticalMovement+=70;
                    mySparky.RotateRight(190,.5,mySparky.StandardAutonWaitTime);
                    mySparky.StrafeLeft(CyDogsSparky.OneTileMM,.5,mySparky.StandardAutonWaitTime);

                    break;

            }
            // We move not all the way so we don't crash into a parker, then after strafe move the rest

            mySparky.MoveStraight(1900+extraVerticalMovement,.5,1000);
            if(mySpikeLocation== SpikeCam.location.MIDDLE) {
                mySparky.StrafeRight(75,.5,mySparky.StandardAutonWaitTime);
            }
            if(mySpikeLocation== SpikeCam.location.LEFT) {
                mySparky.StrafeRight(75,.5,mySparky.StandardAutonWaitTime);
            }
            mySparky.raiseArmToScore(CyDogsSparky.ArmRaiseBeforeElbowMovement);
            mySparky.AutonCenterOnScoreboardBasedOnPath(drivePath);

            mySparky.AdjustToAprilTag(mySpikeLocation,"RedLeft");
            mySparky.MoveStraight(10, .5, mySparky.StandardAutonWaitTime);
            mySparky.scoreFromDrivingPositionAndReturn();
            mySparky.MoveStraight(-50,.5,300);
            mySparky.AutonParkInCorrectSpot(mySpikeLocation, parkingSpot);
            mySparky.returnArmFromScoring();
            mySparky.LowerArmAtAutonEnd();
            //mySparky.MoveStraight(100,.5,300);
        }

    }
}


