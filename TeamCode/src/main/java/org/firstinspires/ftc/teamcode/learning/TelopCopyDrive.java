
package org.firstinspires.ftc.teamcode.learning;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TeleOp_ChassisOnly (Blocks to Java)")
public class TelopCopyDrive extends LinearOpMode {

    private DcMotor FrontLeftWheel;
    private DcMotor BackLeftWheel;
    private DcMotor FrontRightWheel;
    private DcMotor BackRightWheel;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
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

        FrontLeftWheel = hardwareMap.get(DcMotor.class, "FrontLeftWheel");
        BackLeftWheel = hardwareMap.get(DcMotor.class, "BackLeftWheel");
        FrontRightWheel = hardwareMap.get(DcMotor.class, "FrontRightWheel");
        BackRightWheel = hardwareMap.get(DcMotor.class, "BackRightWheel");

        // INITIALIZATION BLOCKS:
        // > Reverse motors'/servos' direction as needed
        FrontLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        BackLeftWheel.setDirection(DcMotor.Direction.REVERSE);
        // > Set motors' ZeroPower behavior if not BRAKE
        FrontLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        FrontRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // > Initialize variables as needed
        // > Ensure LaJirafa starts at the lowest level
        // > Set default position for Servos
        // > Initialize other devices
        //    Ensure LaJirafa starts slightly above the bottom position
        //    LED starts as Red (no cone captured)
        waitForStart();
        if (opModeIsActive()) {
            // RUN BLOCKS:
            while (opModeIsActive()) {
                // LOOP BLOCKS:
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
                    SlowStraight = 0.8 * gamepad1_LeftStickYValue;
                    // Set robot's fast strafe right(+) or left(-) power
                    SlowStrafe = 0.8 * gamepad1_LeftStickXValue;
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
        }
    }
}