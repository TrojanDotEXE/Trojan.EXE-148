package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.Robot;

@Config
@Autonomous (name = "AutoAlbastru", preselectTeleOp = "Main")
public class AutoAlbastru extends LinearOpMode {
    Robot robot = new Robot(this);
    ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
    public static double angle = 0;
    public static double turn = 0;
    public static double power = .9;
    public static double time = .7;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();

        waitForStart();
        timer.reset();
        while((int)timer.time() < time)
            robot.drivetrain.drive(power, angle, turn);
    }
}
