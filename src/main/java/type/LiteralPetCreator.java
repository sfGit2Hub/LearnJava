package type;

import java.util.*;

/**
 * Created by SF on 2016/10/18.
 */
public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(
            Arrays.asList(Pet.class, Dog.class, Mutt.class, Cat.class, EgyptianMau.class, Manx.class)
    );

    @Override
    public List<Class<? extends Pet>> types() {
        return allTypes;
    }

    public static Map<Class<? extends Pet>, Integer> classPetMap() {
        List<Class<? extends Pet>> petClassList = allTypes;
        Map<Class<? extends Pet>, Integer> petMap = new LinkedHashMap<>();
        for (Class<? extends Pet> petClass : petClassList) {
            petMap.put(petClass, 0);
        }
        return petMap;
    }
}
