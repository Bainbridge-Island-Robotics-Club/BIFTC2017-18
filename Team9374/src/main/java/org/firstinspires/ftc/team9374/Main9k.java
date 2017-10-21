package org.firstinspires.ftc.team9374;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.team9374.CSC.Robot;
import org.firstinspires.ftc.team9374.CSC.VectorD;

/**
 * Created by lego7_000 on 10/14/2017.
 */

@TeleOp(name="9k Main Opmode", group="9kMechanum")
public class Main9k extends OpMode {
    private VectorD lStick = new VectorD();
    private VectorD rStick = new VectorD();

    public Robot robot = new Robot();

    public void init() {
        robot.init(hardwareMap);
    }

    public void loop() {
        lStick.getController(gamepad1, 0);
        rStick.getController(gamepad1, 1);

        int speed = 2;
        int mode = 0;
        if (gamepad1.a) {
            speed = 1;
        } else if (gamepad1.x) {
            speed = 2;
        } else if (gamepad1.y) {
            speed = 3;
        }
        if (gamepad1.dpad_up) {
            mode = 0;
        } else if (gamepad1.dpad_left) {
            mode = 1;
        } else if (gamepad1.dpad_down) {
            mode = 2;
        } else if (gamepad1.dpad_right) {
            mode = 3;
        }
        robot.mode = mode;
        robot.setSpeed(speed);
        robot.runMotors(robot.getMotors(0, lStick, rStick));
    }
}
