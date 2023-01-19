package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Scoring {
    OpMode opMode;
    DcMotorEx slider1, slider2;
    Servo arm;
    final int MAX_SLIDER = 0;
    public Scoring(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

        public void init(){

            slider1 = opMode.hardwareMap.get(DcMotorEx.class, "scoring1");
            slider2 = opMode.hardwareMap.get(DcMotorEx.class, "scoring2");
            arm = opMode.hardwareMap.get(Servo.class, "scoringArm");

            slider1.setDirection(DcMotorSimple.Direction.FORWARD);
            slider2.setDirection(DcMotorSimple.Direction.REVERSE);
            slider1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            slider2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            arm.setPosition(0);
            slider1.setPower(0);
            slider2.setPower(0);
        }

        public void extend (Gamepad gamepad){
            double power = -gamepad.right_stick_y;
            if (slider1.getCurrentPosition() < MAX_SLIDER){

                slider1.setPower(power);
                slider2.setPower(power);

            }
        }

        public void arm (Gamepad gamepad){

            if (gamepad.right_bumper) arm.setPosition(1);
            arm.setPosition(0);

        }
}
