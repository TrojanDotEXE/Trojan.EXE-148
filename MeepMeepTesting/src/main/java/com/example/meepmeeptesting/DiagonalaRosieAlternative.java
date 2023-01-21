package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
public class DiagonalaRosieAlternative {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(717);
        int x = 5;

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(17.008, 17.765)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 16.27)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-36, -63.117, Math.toRadians(90)))
                                        .forward(50.5)
                                        .turn(Math.toRadians(-90))
                                        .back(16)
                                        .waitSeconds(2)
                                        .splineToSplineHeading(new Pose2d(-32,-12.5, Math.toRadians(55)), Math.toRadians(70))
                                        .waitSeconds(2)
//                                .splineToSplineHeading(new Pose2d(-56.5,-12.6, Math.toRadians(0)), Math.toRadians(-200))
                                        .turn(Math.toRadians(-55))
                                        .back(24.5)
                                        .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
