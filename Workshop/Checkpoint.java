public interface Checkpoint {
    String getCheckpointId();
    String getLocationName();
    double getDistanceFromLast();
    double getExpectedDuration();
    double getActualDuration();
    boolean isCritical();
    String getType();
    boolean isDelayed();
    double calculatePenalty();
}
