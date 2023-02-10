package org.firstinspires.ftc.teamcode.robot.mechanisms;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class ScoringArm {
    private Servo scoringArm;
    public static double MAX_POS = .65, MIN_POS = 0.05;
    public boolean triggerArm = false;

    public void init(@NonNull HardwareMap hardwareMap){
        scoringArm = hardwareMap.get(Servo.class, "scoringArm");
        scoringArm.setDirection(Servo.Direction.FORWARD);
        scoringArm.setPosition(MIN_POS);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy, int trigger){
        if(gamepad.left_bumper && !gamepadcopy.left_bumper) triggerArm = !triggerArm;
        if(triggerArm){
            scoringArm.setPosition(MAX_POS);
        }
        else if(triggerArm){
            scoringArm.setPosition(MIN_POS);
        }
        if(trigger > 1400){
            scoringArm.setPosition(MAX_POS);
        }
        else if(trigger < 100){
            scoringArm.setPosition(MIN_POS);
        }
    }

}
