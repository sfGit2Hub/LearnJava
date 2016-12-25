package study.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by SF on 2016/10/18.
 */
public abstract class PetCreator {
    private Random random = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Pet[] createPetArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < pets.length; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public ArrayList<Pet> createArrayList(int size) {
        ArrayList<Pet> petArrayList = new ArrayList<>();
        Collections.addAll(petArrayList, createPetArray(size));
        return petArrayList;
    }
}
