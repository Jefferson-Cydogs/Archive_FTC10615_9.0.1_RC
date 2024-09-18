package org.firstinspires.ftc.teamcode.intothedeep;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.checkerframework.checker.units.qual.Current;

/*
This allows you to select which servos to test during initialization.
Using PlayStation controller buttons, Includes error handling to make sure servos are configured properly.
After selection you can control servos position using gamepad.
*/

@TeleOp (name = "Multi-Servo Control TeleOp(PlayStation)",group = "Utility")
public class Daniel_Servo_Learning extends LinearOpMode {

//Declare the servos
private Servo servo1;
private Servo servo2;
private Servo servo3;
private Servo servo4;

//Varaible to keep track of the servo
private Servo selectedServo = null;
private String selectedServoName = "None";

//Define the inital servoPosition
private double servoPosition = 0.5;

//Timer for optional servo select time out
private ElapsedTime selectionTimer = ElapsedTime();

@Override
public void runOpMode(){

    //Initialize the servos with error handling
    if (!initalize("servo1"))return;
    if (!initalize("servo2"))return;
    if (!initalize("servo3"))return;
    if (!initalize("servo4"))return;

    //Option set intial position for all servos
    servo1.setPosition(servoPosition);
    servo2.setPosition(servoPosition);
    servo3.setPosition(servoPosition);
    servo4.setPosition(servoPosition);

     //Display selection Instructions during Intialzation
    telemetry.addLine("Select Servo to Test using PlayStation Controller Buttons.")
        .addData("Cross(X)","Servo 1")
        .addData("Circle(O)","Servo 2")
        .addData("Square(N)","Servo 3")
        .addData("Triangle(A)","Servo 4")
        .addData("Current Selection",selectedServoName);
    telemetry.update();

    //Wait for driver presses play
    waitForStart();

//Allows user to select a servo before TeleOp
while (opModeIsActive()&& selectedServo == null)30 {
//Check for servo selection buttons based on PlaySataion controller mapping
        if (gamepad1.a) {//Cross(X)button
            selectedServo = servo1;
            selectedServoName = "Servo 1";
            servoPosition = servo1.getPosition();
            telemetry.addData("Selected Servo", selectedServoName);
            telemetry.update();
            sleep(300);//delay to prevent multple selections
        } else if (gamepad1.b) {//Circle button
            selectedServo = servo2;
            selectedServoName = "Servo 2";
            servoPosition = servo2.getPosition();
            telemetry.addData("Selected Servo", selectedServoName);
            telemetry.update();
            sleep(300);
        } else if (gamepad1.x) {//Square button
            selectedServo = servo3;
            selectedServoName = "Servo 3";
            servoPosition = servo3.getPosition();
            telemetry.addData("Selected Servo", selectedServoName);
            telemetry.update();
            sleep(300);
        } else if (gamepad1.y) {//Triangle button
            selectedServo = servo4;
            selectedServoName = "Servo 4";
            servoPosition = servo4.getPosition();
            telemetry.addData("Selected Servo", selectedServoName);
            telemetry.update();
            sleep(300);
        }
//option:timeout for servo selection
        if (selectionTimer.seconds() > 30) {
            selectedServo = servo1;//Defalt selection
            selectedServoName = "Servo 1";
            servoPosition = servo1.getPosition();
            telemetry.addData("Selected Servo", selectedServoName);
            telemetry.update();
            sleep(300);
        }
    }

    //if no servo was selceted,defalt to servo 1
    if (selectedServo == null) {
        selectedServo = servo1;
        selectedServoName = "Servo 1";
        servoPosition = servo1.getPosition();
        telemetry.addData("Selected Servo", selectedServoName);
        telemetry.update();
        sleep(300);
    }
    //Display active control instructions
    telemetry.addLine("Control the selected servo using D-pad.")
            .addData("D-pad Up","+0.1")
            .addData("D-pad Down","-0.1")
            .addData("D-pad Right","+0.01")
            .addData("D-pad Left","-0.01")
            .addData("Current Poaition",String.format("%2f",servoPosition));
telemetry.update();

//TeleOp Phase: Control the selected srvo
    while (opModeIsActive()){
    boolean updated = false;//Flag to check if servo position was updated
    //Check if the D-pad Up button is pressed
    if (gamepad1.dpad_down) {
        //Decase servo position by 0.1
        servoPosition += 0.1;
        //Clamp the servo position to a max of 1.0
        if (servoPosition > 1.0) {
            servoPosition = 1.0;
            telemetry.addLine("Servo position at maximum(1.0)");
        }
        updated = true;
        //add a short delay
        sleep(200);
    }
















































}














