package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class ScoringArm {
    private Servo arm;
    public static double MAX_POS = .6, MIN_POS = 0.13;
    public boolean armToggle = false;

    public void init(@NonNull HardwareMap hardwareMap){
        arm = hardwareMap.get(Servo.class, "scoringArm");
        arm.setDirection(Servo.Direction.FORWARD);
        arm.setPosition(MIN_POS);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy){
        if(gamepad.a && !gamepadcopy.a) armToggle = !armToggle;
        if(armToggle){
            arm.setPosition(MAX_POS);
        }
        else{
            arm.setPosition(MIN_POS);
        }
    }

}
