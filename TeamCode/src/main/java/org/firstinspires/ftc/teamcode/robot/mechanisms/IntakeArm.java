package org.firstinspires.ftc.teamcode.robot.mechanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

@Config
public class IntakeArm {
    private DcMotorEx intakeArm;
    public static int DOWN_POS = 75, INIT_POS = 0, UP_POS =-35;
//    public static double power = 0.5;
    private boolean armToggle = false;

    public void init(@NonNull HardwareMap hardwareMap){
        intakeArm = hardwareMap.get(DcMotorEx.class, "intakeArm");
        intakeArm.setDirection(DcMotorEx.Direction.FORWARD);
        intakeArm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        intakeArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeArm.setPower(0);
    }

    public void keyBind(@NonNull Gamepad gamepad, Gamepad prevGamepad) {
        double power = -gamepad.left_stick_y;
        double max = 1;
        double min = -1;
        if ((intakeArm.getCurrentPosition() >= DOWN_POS)) {
            min = -1;
            max = 0;
        }
        if ((intakeArm.getCurrentPosition() <= UP_POS)) {
            min = 0;
            max = 1;
        }
        intakeArm.setPower(Range.clip(power, min, max));
    }
}
