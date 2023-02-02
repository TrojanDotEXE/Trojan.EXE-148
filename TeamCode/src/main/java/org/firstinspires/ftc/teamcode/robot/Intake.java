package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeClaw;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeArm;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeSlider;

public class Intake {
    private OpMode opMode;
    public IntakeClaw intakeClaw = new IntakeClaw();
    public IntakeSlider slider = new IntakeSlider();
    public IntakeArm arm = new IntakeArm();

    public Intake(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        slider.init(opMode.hardwareMap);
        arm.init(opMode.hardwareMap);
        intakeClaw.init(opMode.hardwareMap);
    }
}

