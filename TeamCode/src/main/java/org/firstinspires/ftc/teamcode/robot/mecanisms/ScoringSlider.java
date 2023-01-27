package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ScoringSlider {
    private DcMotorEx slider1, slider2;
    final int MAX_SLIDER = 1000;

    public void init(HardwareMap hardwareMap){
        slider1 = hardwareMap.get(DcMotorEx.class, "scoring1");
        slider2 = hardwareMap.get(DcMotorEx.class, "scoring2");
        slider1.setDirection(DcMotorSimple.Direction.FORWARD);
        slider2.setDirection(DcMotorSimple.Direction.REVERSE);
        slider1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slider2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        slider1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slider2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//            arm.setPosition(0);
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
}
