/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.centerstage.CyDogsSparky;

/*
 * This file contains an example of a Linear "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode is executed.
 *
 * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
 * This code will work with either a Mecanum-Drive or an X-Drive train.
 * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
 * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
 *
 * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
 *
 * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
 * Each motion axis is controlled by one Joystick axis.
 *
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 *
 * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
 * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
 * the direction of all 4 motors (see code below).
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp
public class BetterDriveOnly extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FrontLeftWheel = null;
    private DcMotor BackLeftWheel = null;
    private DcMotor FrontRightWheel = null;
    private DcMotor BackRightWheel = null;

    private double setPower = 0.5;

    private double setPosition = 0.5;

    public Servo myServo;
    private CyDogsSparky mySparky;
    @Override
    public void runOpMode() {

    //    mySparky = new CyDogsSparky(this, CyDogsChassis.Alliance.RED, 300);
    //    AnalogInput analogInput = hardwareMap.get(AnalogInput.class, "ServoPosition");
        double position;
        initializeWheels();
        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
    //    telemetry.update();

        waitForStart();
    //    runtime.reset();

      //  myServo = hardwareMap.get (Servo.class, "Servo");


    //    myServo.setDirection(Servo.Direction.FORWARD);
        // run until the end of the match (driver presses STOP)
        if(opModeIsActive()) {
            while (opModeIsActive()) {
                manageChassisDrive(setPower);
                //    manageDriverButtons();
                //    manageManipulatorButtons();
                //    position = analogInput.getVoltage() / 3.3 * 360;
                //    telemetry.addData("The servo position ",position);
                      telemetry.update();

            }
        }
    }

    private void manageDriverButtons(){
        if(gamepad1.a)
        {
            setPower-=0.1;
            if (setPower<0.1){
                setPower=0.1;}
            telemetry.addLine("Driver A/cross is pushed");
            telemetry.addData("new power ",setPower);
            sleep(200);
        }
        if(gamepad1.b)
        {
            telemetry.addLine("Driver B/circle is pushed");
        }
        if(gamepad1.x)
        {
            setPower-=0.1;
            if (setPower<0.1){
                setPower=0.1;}
            telemetry.addLine("Driver X/square is pushed");
            telemetry.addData("new power ",setPower);
            sleep(200);
        }
        if(gamepad1.y)
        {
            setPower+=0.1;
            if (setPower>0.8){
            setPower=0.8;}
            telemetry.addLine("Driver Y/triangle is pushed");
            telemetry.addData("new power ",setPower);
            sleep(200);

        }
    }
    private void manageManipulatorButtons(){
        if(gamepad2.a)
        {
            setPosition+=0.1;
            if (setPosition>1){
                setPosition=0.1;}
            telemetry.addLine("Driver Y/triangle is pushed");
            telemetry.addData("new power ",setPosition);
            myServo.setPosition(setPosition);
            sleep(200);
        }
        if(gamepad2.b)
        {

        }
        if(gamepad2.x)
        {
            myServo.setPosition(0.5);

        }
        if(gamepad2.y)
        {
            setPosition-=0.1;
            if (setPosition<0.0){
                setPosition=0.9;}
            telemetry.addLine("Driver X/square is pushed");
            telemetry.addData("new power ",setPosition);
            myServo.setPosition(setPosition);
            sleep(200);

        }
    }
    private void manageChassisDrive(double maxSpeed){
        float gamepad1_RightStickYValue;
        float gamepad1_RightStickXValue;
        float gamepad1_LeftStickYValue;
        float gamepad1_LeftStickXValue;
        float gamepad1_TriggersValue;
        double Straight;
        double Strafe;
        double Rotate;
        double SlowStraight;
        double SlowStrafe;

        gamepad1_RightStickYValue = -gamepad1.right_stick_y;
        gamepad1_RightStickXValue = gamepad1.right_stick_x;
        gamepad1_LeftStickYValue = -gamepad1.left_stick_y;
        gamepad1_LeftStickXValue = gamepad1.left_stick_x;
        gamepad1_TriggersValue = gamepad1.right_trigger - gamepad1.left_trigger;

        if (gamepad1_RightStickYValue != 0 || gamepad1_RightStickXValue != 0 || gamepad1_LeftStickYValue != 0 || gamepad1_LeftStickXValue != 0 || gamepad1_TriggersValue != 0) {
            // Set robot's move forward(+) or backwards(-) power
            Straight = 0.5 * (0.75 * Math.pow(gamepad1_RightStickYValue, 3) + 0.25 * gamepad1_RightStickYValue);
            // Set robot's strafe right(+) or left(-) power
            Strafe = 0.5 * (0.75 * Math.pow(gamepad1_RightStickXValue, 3) + 0.25 * gamepad1_RightStickXValue);
            // Set robot's clockwise(+) or counter-clockwise(-) rotation power
            Rotate = 0.5 * (0.75 * Math.pow(gamepad1_TriggersValue, 3) + 0.25 * gamepad1_TriggersValue);
            // Set robot's fast move forward(+) or backwards(-) power
            SlowStraight = 0.5 * gamepad1_LeftStickYValue;
            // Set robot's fast strafe right(+) or left(-) power
            SlowStrafe = 0.5 * gamepad1_LeftStickXValue;
            FrontLeftWheel.setPower(Straight + SlowStraight + Strafe + SlowStrafe + Rotate);
            FrontRightWheel.setPower((((Straight + SlowStraight) - Strafe) - SlowStrafe) - Rotate);
            BackLeftWheel.setPower((((Straight + SlowStraight) - Strafe) - SlowStrafe) + Rotate);
            BackRightWheel.setPower((Straight + SlowStraight + Strafe + SlowStrafe) - Rotate);
        } else {
            // Stop all wheels' motors if their controls are not touched
            FrontLeftWheel.setPower(0);
            FrontRightWheel.setPower(0);
            BackLeftWheel.setPower(0);
            BackRightWheel.setPower(0);
        }
    }

    private void initializeWheels(){
        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        FrontLeftWheel  = hardwareMap.get(DcMotor.class, "FrontLeftWheel");
        BackLeftWheel  = hardwareMap.get(DcMotor.class, "BackLeftWheel");
        FrontRightWheel = hardwareMap.get(DcMotor.class, "FrontRightWheel");
        BackRightWheel = hardwareMap.get(DcMotor.class, "BackRightWheel");

        // ########################################################################################
        // !!!            IMPORTANT Drive Information. Test your motor directions.            !!!!!
        // ########################################################################################
        // Most robots need the motors on one side to be reversed to drive forward.
        // The motor reversals shown here are for a "direct drive" robot (the wheels turn the same direction as the motor shaft)
        // If your robot has additional gear reductions or uses a right-angled drive, it's important to ensure
        // that your motors are turning in the correct direction.  So, start out with the reversals here, BUT
        // when you first test your robot, push the left joystick forward and observe the direction the wheels turn.
        // Reverse the direction (flip FORWARD <-> REVERSE ) of any wheel that runs backward
        // Keep testing until ALL the wheels move the robot forward when you push the left joystick forward.
        FrontLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        BackLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        FrontRightWheel.setDirection(DcMotor.Direction.FORWARD);
        BackRightWheel.setDirection(DcMotor.Direction.FORWARD);

        FrontLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        FrontRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }
}
