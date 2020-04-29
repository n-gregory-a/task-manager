package ru.naumkin.tm.command;

import ru.naumkin.tm.entity.User;
import ru.naumkin.tm.util.HashGenerator;

public class UserChangePasswordCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "password-change";
    }

    @Override
    public String getDescription() {
        return "User password change.";
    }

    @Override
    public void execute() throws Exception {
        bootstrap.getView().showMessage("[PASSWORD CHANGE]");
        User user = bootstrap.getCurrentUser();
        bootstrap.getView().showMessage("Enter old password:");
        String password = bootstrap.getView().readLine();
        boolean passwordsMatch = user.getPassword().equals(HashGenerator.getHash(password));
        if (!passwordsMatch) {
            bootstrap.getView().showMessage("Password is incorrect. Password changing failed.");
            return;
        }
        bootstrap.getView().showMessage("Enter new password:");
        password = bootstrap.getView().readLine();
        user.setPassword(HashGenerator.getHash(password));
    }

}
