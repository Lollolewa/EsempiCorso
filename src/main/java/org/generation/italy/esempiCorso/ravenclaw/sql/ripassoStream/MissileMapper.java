package org.generation.italy.esempiCorso.ravenclaw.sql.ripassoStream;

import java.util.function.Function;

public class MissileMapper implements Function<Missile, String> {
    @Override
    public String apply(Missile missile) {
        return missile.getLocation(); //questo è equivalente a m -> m.getLocation() nella lambda
    }
}
