package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.util.function.Function;

public class MissileMapper implements Function<Missile, String> {
    @Override
    public String apply(Missile missile) {
        return missile.getTarget(); //questo è equivalente a m -> m.getLocation() nella lambda
    }
}
