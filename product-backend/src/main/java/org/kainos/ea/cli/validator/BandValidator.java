package org.kainos.ea.cli.validator;

import org.kainos.ea.cli.Admin;
import org.kainos.ea.exception.NameTooShortException;

public class BandValidator {
    public boolean isValidBand(Admin admin) throws NameTooShortException{
        if (admin.getName().length() > 1) {
            throw new NameTooShortException();
        }

        return true;
    }
}
