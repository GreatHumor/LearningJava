package com.gh.redis;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 2:05 下午
 */
public class Zoo {
    public Animal animal;

    public Zoo() {
    }

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public static class Animal {
        public String name;
    }

    @NoArgsConstructor

    public static class Dog extends Animal {
        public String barkVolume;

        public Dog(String lacy) {
            this.barkVolume = lacy;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;
    }
}
