package type;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SF on 2016/10/18.
 */
public class PetCount {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public PetCounter(){
            super(LiteralPetCreator.classPetMap());
        }
    }
}
