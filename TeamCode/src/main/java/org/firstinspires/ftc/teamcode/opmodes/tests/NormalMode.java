package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(group = "Tests", name = "Test Driving [NormalMode]")
public class NormalMode extends OpMode {
    Robot robot = new Robot(this);
    Telemetry dashboardTelemetry;
    public static double x = 0.0;

    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        dashboardTelemetry = dashboard.getTelemetry();
        robot.init();
    }

    @Override
    public void start(){
        telemetry.clear();
        telemetry.update();
    }

    @Override
    public void loop() {
        robot.drivetrain.drive(gamepad1);
        dashboardTelemetry.addData("LeftForntPow: ", 5);
        dashboardTelemetry.addData("Var x: ", x);
//        robot.drivetrain.powersToTelemetry(dashboardTelemetry);

        dashboardTelemetry.update();
    }
}
