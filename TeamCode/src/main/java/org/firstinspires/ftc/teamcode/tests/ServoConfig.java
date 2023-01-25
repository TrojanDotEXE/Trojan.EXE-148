package org.firstinspires.ftc.teamcode.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/*
TODO: Instaleaza Papier ca sa notezi valorile, sa testezi telemetry-ul,
 butoanele pentru miscarea servoului butonul de toggle si
 sa incerci sa implementezi codul si pt celelalte chestii
*/

@Config
@TeleOp(group = "Config", name = "Servo Config")
public class ServoConfig extends LinearOpMode {
    Servo servo;
    static double MAX_POS = 1, MIN_POS = 0;
    static double curPos;

    @Override
    public void runOpMode() throws InterruptedException {
        boolean servoToggle = false;
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        servo = hardwareMap.get(Servo.class, "servo");
        servo.setPosition(MIN_POS);

        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Ready!");
        telemetry.update();
        telemetry.clearAll();

        waitForStart();
        while (opModeIsActive()){
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);

            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            if (currentGamepad2.a && !previousGamepad2.a) {
                servo.setPosition(servo.getPosition() + 0.1);
            }

            if (currentGamepad2.b && !previousGamepad2.b) {
                servo.setPosition(servo.getPosition() - 0.1);
            }

//            if (currentGamepad1.a && !previousGamepad1.a) {
//                servoToggle = !servoToggle;
//            }
//            if (servoToggle) {
//                servo.setPosition(MAX_POS);
//            }
//            else {
//                servo.setPosition(MIN_POS);
//            }
            telemetry.addData("Servo Pos ", "cur / new  %.2f / %.2f", servo.getPosition(), curPos);
            telemetry.update();
        }
    }
}
