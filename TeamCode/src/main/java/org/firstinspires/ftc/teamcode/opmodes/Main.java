package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp(group = "1", name = "Main")
public class Main extends OpMode {
    Robot robot = new Robot(this);

    @Override
    public void init() {
        robot.init();
    }

    @Override
    public void loop() {
        robot.drivetrain.drive(gamepad1);
//        robot.intake.keyBind(gamepad2);
    }
}
