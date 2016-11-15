package type;

import java.util.ArrayList;

/**
 * Created by SF on 2016/10/18.
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createPetArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.createArrayList(size);
    }
}
