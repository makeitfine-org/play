package io.github.koresmosto.play;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

class JavaAvoidNullCheck {

    public String method(@NotNull String arg) {
        return STR.">>> \{arg}";
    }

    public String methodLombok(@NonNull String arg) {
        method(null);
        return STR.">>> \{arg}";
    }
}
