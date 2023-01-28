package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Intake;
import org.firstinspires.ftc.teamcode.robot.Scoring;

@TeleOp(group = "Tests", name = "Test Lift[extend]")
public class Testlift extends OpMode {
    Intake intake = new Intake(this);
    Scoring scoring = new Scoring(this);

    @Override
    public void init() {
        intake.init();
        scoring.init();
    }

    @Override
    public void loop() {

        scoring.extend(gamepad2);
    }
}
