package model;


public enum Priority {
    HIGH(3, "Critical mission tasks"),
    MEDIUM(2, "Important but not critical"), 
    LOW(1, "Optional or routine tasks");
    
    private final int level;
    private final String description;
    
    Priority(int level, String description) {
        this.level = level;
        this.description = description;
    }
    
    public int getLevel() { 
        return level; 
    }
    
    public String getDescription() { 
        return description; 
    }
}