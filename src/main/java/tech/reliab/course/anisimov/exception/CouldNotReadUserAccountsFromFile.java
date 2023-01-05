package tech.reliab.course.anisimov.exception;

import org.jetbrains.annotations.NotNull;

public class CouldNotReadUserAccountsFromFile extends Exception {
    public CouldNotReadUserAccountsFromFile(@NotNull String filePath, @NotNull String errorMessage) {
        super("Не удалось прочитать счета из фалйа " + filePath + " по причине: " + errorMessage);
    }
}
