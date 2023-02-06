package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringArm;
import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringSlider;

public class Scoring {
    OpMode opMode;
    ScoringSlider slider = new ScoringSlider();
    ScoringArm arm = new ScoringArm();
    final int MAX_SLIDER = 1000;
    public Scoring(@NonNull OpMode opMode){
        this.opMode = opMode;
    }
        public void init(){
            slider.init(opMode.hardwareMap);
            arm.init(opMode.hardwareMap);
        }

        public void keyBind(Gamepad gamepad, Gamepad prevGamepad){
            slider.keyMap(gamepad);
            arm.keyBind(gamepad, prevGamepad);
        }

        public void getPos(){
            slider.getPos(opMode.telemetry);
        }
}

