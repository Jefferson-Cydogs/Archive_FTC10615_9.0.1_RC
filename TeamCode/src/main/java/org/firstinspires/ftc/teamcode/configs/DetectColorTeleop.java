package org.firstinspires.ftc.teamcode.configs;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

/**
 * ColorDetectionOpMode
 *
 * This OpMode uses a webcam to detect the prominent color (yellow, blue, or red) in front of the camera.
 * Detection results are displayed via telemetry and visually annotated on the camera feed.
 * Only one color will be flagged as detected based on the area occupied by each color in the frame.
 */
@TeleOp(name = "Color Detection OpMode", group = "Vision")
public class ColorDetectionOpMode extends LinearOpMode {

    //Webcam variables
    OpenCvCamera webcam; //Represents the webcam
    ColorDetectionPipeline pipeline; // Our custom pipelinefor color detection

    /**
     * runOpMode
     *
     * This is the main method tht run when the OpMode is selected and started.
     * It initializes the webcam and pipeline, then continuously checks for the most prominent color.
     */
    @Override
    public void runOpMode() {
        // Initialize the pipeline
        pipeline = new ColorDetectionPipeline();

        //Get the camera monitor view ID from the hardwareMap
        //This ID is used to desplay the camera feed on the driver station phone
        int cameraMonitorViewId, "id", hardwareMap.appContext.getPackageName());

//Initialize the webcam using EasyOpenCV
        //"Webcam1" should match the name you assigned in the Robot Controlor app
        webcam = OpenCvCameraFactory.getInstance().getIdentifier(
                "cameraMonitorViewId", "id", hardwereMap.appContext.getPackageName());

        //Initialize the webcam
        )
    }
}
