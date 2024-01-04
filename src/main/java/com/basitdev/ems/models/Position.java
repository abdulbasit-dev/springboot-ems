package com.basitdev.ems.models;

public enum Position {
    MANAGER, SUPERVISOR, TEAMLEADER, MEMBER;

    public String toString() {
        return switch (this) {
            case MANAGER -> "Manager";
            case SUPERVISOR -> "Supervisor";
            case TEAMLEADER -> "TeamLeader";
            case MEMBER -> "Member";
            default -> "";
        };
    }
}
