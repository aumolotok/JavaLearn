package main.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return translation;
    }

    public static Subjects getByTitle(String translation){
        List<Subjects> values = Arrays.asList(Subjects.values());

        return values.stream().filter( x -> x.translation.equalsIgnoreCase(translation)).collect(Collectors.toList()).get(0);
    }


}
