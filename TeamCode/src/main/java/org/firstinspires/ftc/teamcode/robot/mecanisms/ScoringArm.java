package org.firstinspires.ftc.teamcode.robot.mecanisms;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class ScoringArm {
    private Servo arm;
    public static double MAX_POS = .6, MIN_POS = 0.05;
    public boolean armToggle = false;

    public void init(@NonNull HardwareMap hardwareMap){
        arm = hardwareMap.get(Servo.class, "scoringArm");
        arm.setDirection(Servo.Direction.FORWARD);
        arm.setPosition(MIN_POS);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad gamepadcopy, int trigger){
        if(gamepad.a && !gamepadcopy.a) armToggle = !armToggle;
        if(trigger > 1400){
            arm.setPosition(MAX_POS);
        }
        else if(trigger < 100){
            arm.setPosition(MIN_POS);
        }
    }

}
