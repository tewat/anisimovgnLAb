package tech.reliab.course.anisimov.exception;

import org.jetbrains.annotations.NotNull;

public class CouldNotWriteUsersAccountsToFile extends Exception {
    public CouldNotWriteUsersAccountsToFile(
            @NotNull String userId,
            @NotNull String filePath,
            @NotNull String errorDescription
    ) {
        super("Не удалось записать счета пользоватлея с id " + userId + " по пути " + filePath + "по следующей причине: " + errorDescription);
    }
}
