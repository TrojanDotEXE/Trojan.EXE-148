package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Intake;

@Config
@TeleOp(group = "Config", name = "Claw Config")
public class ClawTest extends LinearOpMode {
    private Intake intake;

    @Override
    public void runOpMode() throws InterruptedException {
        intake = new Intake(this);
        intake.init();
        waitForStart();
        while (opModeIsActive()){
            intake.keyBind(gamepad2);
        }
    }
}
