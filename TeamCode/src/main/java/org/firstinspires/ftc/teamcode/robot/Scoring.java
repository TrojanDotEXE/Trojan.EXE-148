package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringArm;
import org.firstinspires.ftc.teamcode.robot.mecanisms.ScoringSlider;

public class Scoring {
    public OpMode opMode;
    public ScoringSlider slider = new ScoringSlider();
    public ScoringArm arm = new ScoringArm();
    public Scoring(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

        public void init(){
            slider.init(opMode.hardwareMap);
            arm.init(opMode.hardwareMap);
        }

        public void keyBind(Gamepad gamepad, Gamepad prevGamepad){
            slider.keyBind(gamepad);
            arm.keyBind(gamepad, prevGamepad, slider.getPos());
        }

//        public void getPos(){
//            slider.getPos(opMode.telemetry);
//        }
}

