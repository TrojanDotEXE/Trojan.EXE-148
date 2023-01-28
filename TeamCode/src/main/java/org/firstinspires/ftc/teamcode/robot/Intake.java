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
    Claw claw = new Claw();
    public IntakeSlider slider;
    public IntakeArm arm = new IntakeArm();
    private double MAX_POS = 0.9, MIN_POS = 0.7;
    public Intake(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
//        slider.init(opMode.hardwareMap);
//        arm.init(opMode.hardwareMap);
        claw.init(opMode.hardwareMap);
    }

    public void keyBind(Gamepad gamepad){
//        slider.keyBind(gamepad);
//        arm.keyBind(gamepad);
        claw.keyBind(gamepad);
    }
}

