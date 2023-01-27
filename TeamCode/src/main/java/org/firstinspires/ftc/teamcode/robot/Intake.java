package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.robot.mecanisms.Claw;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeArm;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeSlider;

public class Intake {
    OpMode opMode;
    Servo slider1, slider2;
    IntakeSlider slider;
    IntakeArm arm;
    Claw claw;
    private double MAX_POS = 0.9, MIN_POS = 0.7;
    public Intake(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
//        slider.init(opMode.hardwareMap);
//        arm.init(opMode.hardwareMap);
//        claw.init(opMode.hardwareMap);
        slider1 = opMode.hardwareMap.get(Servo.class, "intake1");
        slider2 = opMode.hardwareMap.get(Servo.class, "intake2");
        slider1.setPosition(0);
        slider2.setPosition(0);
    }

    public void extend (Gamepad gamepad){
        if(gamepad.a){
            slider1.setPosition(MAX_POS);
            slider2.setPosition(MAX_POS);
        }
        if(gamepad.b){
            slider1.setPosition(MIN_POS);
            slider2.setPosition(MIN_POS);
        }
    }

    public void keyBind(Gamepad gamepad){
        slider.keyBind(gamepad);
        arm.keyBind(gamepad);
        claw.keyBind(gamepad);
    }
}

