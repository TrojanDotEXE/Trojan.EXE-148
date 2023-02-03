package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringSlider;

public class Scoring {
    OpMode opMode;
    ScoringSlider slider = new ScoringSlider();
    Servo arm;
    final int MAX_SLIDER = 1000;
    public Scoring(@NonNull OpMode opMode){
        this.opMode = opMode;
    }
        public void init(){
            slider.init(opMode.hardwareMap);
//            arm = opMode.hardwareMap.get(Servo.class, "scoringArm");
//            arm.setPosition(0);
        }

        public void keyBind(Gamepad gamepad){
            slider.keyMap(gamepad);
        }

        public void arm (Gamepad gamepad){

            if (gamepad.right_bumper) arm.setPosition(1);
            arm.setPosition(0);

        }
}

