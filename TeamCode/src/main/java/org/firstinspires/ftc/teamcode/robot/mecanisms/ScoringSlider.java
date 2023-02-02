package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ScoringSlider {
    private DcMotorEx sliderS, sliderD;
    public static int MAX_SLIDER = 500;
    private double power;
    private double min = -1, max = 1;

    public void init(HardwareMap hardwareMap){
        sliderS = hardwareMap.get(DcMotorEx.class, "scoringS");
        sliderD = hardwareMap.get(DcMotorEx.class, "scoringD");
        sliderS.setDirection(DcMotorSimple.Direction.REVERSE);
        sliderD.setDirection(DcMotorSimple.Direction.FORWARD);
        sliderS.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        sliderD.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        sliderS.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sliderD.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sliderS.setPower(0);
        sliderD.setPower(0);

        sliderS.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sliderD.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void keyMap (Gamepad gamepad){
        power = -gamepad.right_stick_y;
        if ((sliderS.getCurrentPosition() < MAX_SLIDER)&&(sliderD.getCurrentPosition() < MAX_SLIDER)){
           min = 0;
           max = 1;
        }
        if ((sliderS.getCurrentPosition() > 0)&&(sliderD.getCurrentPosition() > 0)){
            min = -1;
            max = 0;
        }
        sliderS.setPower(Range.clip(power, min, max));
        sliderD.setPower(Range.clip(power, min, max));
    }

    public void getPos(Telemetry telemetry){
        telemetry.addData("SliderS ", "%2d / %2d", sliderS.getCurrentPosition(), MAX_SLIDER);
        telemetry.addData("SliderD ", "%2d / %2d", sliderD.getCurrentPosition(), MAX_SLIDER);
    }
}
