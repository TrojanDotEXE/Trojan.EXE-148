package org.firstinspires.ftc.teamcode.opmodes.configs;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringSlider;

//@Disabled
@TeleOp(group = "Configs", name = "Scoring Slider Config")
public class ScoringSliderConfig extends LinearOpMode {
    ScoringSlider slides = new ScoringSlider();

    @Override
    public void runOpMode() throws InterruptedException {
        slides.init(hardwareMap);

        waitForStart();
        while (opModeIsActive() && !isStopRequested()){
            slides.keyMap(gamepad2);
            slides.getPos(telemetry);
            telemetry.update();
        }

    }
}
