package org.firstinspires.ftc.teamcode.robot.mecanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class ScoringSlider {
    private DcMotorEx sliderS, sliderD;
    public static int MAX_SLIDER = 500;

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
        double power = -gamepad.right_stick_y;
        if ((sliderS.getCurrentPosition() < MAX_SLIDER)&&(sliderD.getCurrentPosition() < MAX_SLIDER)){
            sliderS.setPower(power);
            sliderD.setPower(power);
        }
        else{
            sliderS.setPower(0 );
            sliderD.setPower(0 );
        }
    }

    public void getPos(Telemetry telemetry){
        telemetry.addData("SliderS ", "%2d / %2d", sliderS.getCurrentPosition(), MAX_SLIDER);
        telemetry.addData("SliderD ", "%2d / %2d", sliderD.getCurrentPosition(), MAX_SLIDER);
    }
}
