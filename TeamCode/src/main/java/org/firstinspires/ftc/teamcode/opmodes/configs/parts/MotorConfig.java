package org.firstinspires.ftc.teamcode.opmodes.configs.parts;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//@Disabled
@Config
@TeleOp(group = "Configs", name = "Motor Config")
public class MotorConfig extends LinearOpMode {
    public DcMotor motor;
    public static int MAX_POS = 120;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
        motor.setPower(0);

        Telemetry telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.addLine("Ready!");
        telemetry.update();
        telemetry.clearAll();
        waitForStart();
        while (opModeIsActive()){
            if(gamepad2.a) {
                motor.setTargetPosition(MAX_POS);
                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while (motor.isBusy() && motor.getCurrentPosition() < MAX_POS)
                    motor.setPower(1);
            }
            if(gamepad2.b) {
                motor.setTargetPosition(0);
                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while (motor.isBusy())
                    motor.setPower(0.5);
            }
            telemetry.addData("Going to target ", "cur / tar  %2d / %2d", motor.getCurrentPosition(), motor.getTargetPosition());
            telemetry.update();
        }
    }
}
