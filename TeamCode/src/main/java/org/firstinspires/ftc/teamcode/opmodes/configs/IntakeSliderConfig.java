package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeSlider;

//@Disabled
@TeleOp(group = "Configs", name = "Motor Config")
public class IntakeSliderConfig extends LinearOpMode {
    IntakeSlider intakeSlider;

    @Override
    public void runOpMode() throws InterruptedException {
        intakeSlider.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()){
            intakeSlider.keyBind(gamepad2);

        }
    }
}
