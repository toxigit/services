package org.exemple.project1.entities;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender,Character> {
    @Override
    public Character convertToDatabaseColumn(Gender gender) {
        if(gender==null){
            return null;
        }
        return gender.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(Character character) {
        return character.equals('M')?Gender.MALE:Gender.FEMALE;
    }
}
