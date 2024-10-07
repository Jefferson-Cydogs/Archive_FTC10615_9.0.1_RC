package org.firstinspires.ftc.teamcode.intothedeep;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "RedLeftOneSampleEmmet")
public class RedLeftOneSampleEmmet extends LinearOpMode {


    private DcMotor leftMotor;
    private DcMotor rightMotor;


    @Override
    public void runOpMode() {
        // Initialize motors
        leftMotor=hardwareMap.get(DcMotor.class,"left_motor");
        rightMotor=hardwareMap.get(DcMotor.class,"right_motor");

        //set mootor direction
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        //Invert if necesseary

        //Wait for the game to start
        waitForStart();

        while(opModeIsActive()){
            //Move forwards
            if(gamepad1.a){
                leftMotor.setPower(1.0);//Full power forward
                rightMotor.setPower(1.0);//Full power forward
            }
            //Move backwards
            else if(gamepad1.b){
                leftMotor.setPower(-1.0);//Full power backwards
                rightMotor.setPower(-1.0);//Full power backwards
            }
            //Stop motors
            else{
                leftMotor.setPower(0);//Stop
                rightMotor.setPower(0);//Stop
            }

            //Optional: Add telemetry to monitor robot status
            telemetry.addData("Status","Runing");
            telemetry.update();
        }
    }
}
