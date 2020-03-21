package jJavaCollections.kHashSetsChallenge;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {   // Declared as FINAL so it cannot be overridden
        if (this == obj) {                      // in any subclass, ex. Labrador class
            return true;
        }

        if (obj instanceof  Dog){
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }
}
