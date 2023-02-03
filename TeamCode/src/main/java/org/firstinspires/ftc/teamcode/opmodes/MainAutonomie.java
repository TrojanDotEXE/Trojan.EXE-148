package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.RobotAuto;
import org.firstinspires.ftc.teamcode.robot.camera.Camera;

@Config
@Autonomous (name = "AutoRosu", preselectTeleOp = "Main")
public class MainAutonomie extends LinearOpMode {
    RobotAuto robot = new RobotAuto(this);
    ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
    public static double angle = 180;
    public static double turn = 0;
    public static double power = .9;
    public static double time = .7;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        robot.camera.runCameraScan();
        int tagID = robot.camera.getTagID();

        waitForStart();
        switch (tagID) {
            case 1: {
                timer.reset();
                while ((int)timer.time() < time)
                    robot.drivetrain.drive(.5, 0, 0);
            }
            break;
            case 2: {
                timer.reset();
                while ((int)timer.time() < time)
                robot.drivetrain.drive(.5, 90, 0);
            }
            break;
            case 3: {
                timer.reset();
                while ((int)timer.time() < time)
                robot.drivetrain.drive(.5, 180, 0);
            }
            break;
        }
    }
}
