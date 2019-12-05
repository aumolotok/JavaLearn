package main.common;

import jdk.jfr.Description;

public enum Subjects {
    Physics("Физика", SubjectType.Tech),
    Math("Математика", SubjectType.Tech),
    InformationScience("Информатика", SubjectType.Tech),
    English("Английский", SubjectType.Social),
    Biology("Биология", SubjectType.Natural),
    History("История", SubjectType.Social);

    private String translation;

    public String getTranslation() {
        return translation;
    }

    private SubjectType type;

    public SubjectType getType(){
        return type;
    }

    private Subjects(String translation, SubjectType type){
        this.translation = translation;
        this.type = type;
    }

    public enum SubjectType {
        Tech,
        Social,
        Natural
    }
}
