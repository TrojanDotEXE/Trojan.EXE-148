package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp(group = "Tests", name = "Test Driving [AssistedMode]")
public class AssistedMode extends OpMode {
    Robot robot = new Robot(this);

    @Override
    public void init() {
        robot.init();
    }

    @Override
    public void loop() {
        robot.drivetrain.drive(gamepad1);

    }
}
