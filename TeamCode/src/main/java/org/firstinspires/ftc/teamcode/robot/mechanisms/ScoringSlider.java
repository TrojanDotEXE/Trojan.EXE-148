package org.firstinspires.ftc.teamcode.robot.mechanisms;

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
    public static int LOW_J = 0, MID_J = 400, HIGH_J = 1520;
    public int MAX = HIGH_J;

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

    public void keyBind(Gamepad gamepad){
        double power = -gamepad.left_trigger;
        double power1 = gamepad.right_trigger;
        double max = 1;
        double min = -1;
        if(gamepad.b) MAX = LOW_J;
        if(gamepad.x) MAX = MID_J;
        if(gamepad.y) MAX = HIGH_J;
        if ((sliderD.getCurrentPosition() >= MAX)){
            min = -1;
            max = 0;
        }
        if ((sliderD.getCurrentPosition() <= 0)){
            min = 0;
            max = 1;
        }
        sliderS.setPower(Range.clip(power + power1, min, max));
        sliderD.setPower(Range.clip(power + power1, min, max));
    }

    public int getPos() {return sliderD.getCurrentPosition();}
}
