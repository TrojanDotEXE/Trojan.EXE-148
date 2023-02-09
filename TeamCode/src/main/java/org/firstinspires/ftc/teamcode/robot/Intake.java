package org.firstinspires.ftc.teamcode.robot;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeArm;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeClaw;
import org.firstinspires.ftc.teamcode.robot.mecanisms.IntakeSlider;

public class Intake {
    private OpMode opMode;
    public IntakeClaw intakeClaw = new IntakeClaw();
    public IntakeSlider intakeSlider = new IntakeSlider();
    public IntakeArm intakeArm = new IntakeArm();

    public Intake(@NonNull OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        intakeClaw.init(opMode.hardwareMap);
//        intakeArm.init(opMode.hardwareMap);
//        intakeSlider.init(opMode.hardwareMap);
    }

    public void keyBind(Gamepad currentGamepad, Gamepad previousGamepad){
        intakeClaw.keyBind(currentGamepad, previousGamepad);
//        intakeArm.keyBind(currentGamepad, previousGamepad);
//        intakeSlider.keyBind(currentGamepad, previousGamepad);
    }
}

