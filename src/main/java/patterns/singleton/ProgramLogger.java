package patterns.singleton;

public class ProgramLogger {
    private static ProgramLogger programLogger;

    public static ProgramLogger getProgramLogger() {
        if (programLogger == null) {
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    private ProgramLogger() {

    }
}
