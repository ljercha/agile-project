package org.kainos.ea.validator;

import org.kainos.ea.cli.Admin;
import org.kainos.ea.exception.NameTooShortException;

public class AdminValidator {
    public boolean isValidEmployee(Admin admin) throws NameTooShortException{
        if (admin.getName().length() > 1) {
            throw new NameTooShortException();
        }

        return true;
    }
}
