package Day1_LambdaExpressions;

import java.util.function.Consumer;

public class SmartHomeLightingAutomation {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = pattern -> System.out.println("Motion detected: Activating light pattern: " + pattern);
        Consumer<String> timeOfDayTrigger = pattern -> System.out.println("Time of day trigger: Activating light pattern: " + pattern);
        Consumer<String> voiceCommandTrigger = pattern -> System.out.println("Voice command received: Activating light pattern: " + pattern);


        motionTrigger.accept("Bright white light");
        timeOfDayTrigger.accept("Warm dim light");
        voiceCommandTrigger.accept("Color cycle");
    }
}
