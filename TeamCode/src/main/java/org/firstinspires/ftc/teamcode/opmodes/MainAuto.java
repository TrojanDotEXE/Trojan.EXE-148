package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.camera.Camera;

@Autonomous(group = "Tests", name = "Test Camera [Detect & Move]")
public class MainAuto extends LinearOpMode {
    Robot robot = new Robot(this);
    Camera camera = new Camera(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        camera.init();
        camera.runCameraScan();
        int tagID = camera.getTagID();
        switch (tagID) {
            case 1: {
                robot.drivetrain.drive(.5, 0, 0);
           }
            break;
            case 2: {
                robot.drivetrain.drive(-.5, 0, 0);
            }
            break;
            case 3: {
                robot.drivetrain.drive(.5, 45, 0);
            }
            break;
        }
        waitForStart();

    }
}

