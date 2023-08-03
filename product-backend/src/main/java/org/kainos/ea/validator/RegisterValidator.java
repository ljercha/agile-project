package org.kainos.ea.validator;

import org.kainos.ea.cli.RequestEmployee;

public class RegisterValidator {
        // Minimum password length (you can adjust this as needed)
        private static final int minLength = 8;

        public static void validate (RequestEmployee input) throws Exception {
            String email = input.getEmail();
            String password = input.getPassword();

            if (email.contains(" ")) {
                throw new Exception("Email cannot contain whitespace.");
            }

            if (password.length() < minLength) {
                // Check if the password meets the minimum length requirement
                throw new Exception("Password must be at least " + minLength + " characters long.");
            }

            // Check if the password contains at least one lowercase letter
            if (!password.matches(".*[a-z].*")) {
                throw new Exception("Password must contain at least one lowercase letter.");
            }

            // Check if the password contains at least one uppercase letter
            if (!password.matches(".*[A-Z].*")) {
                throw new Exception("Password must contain at least one uppercase letter.");
            }

            // Check if the password contains at least one special character
            if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                throw new Exception("Password must contain at least one special character.");
            }

            // Check if the password has no whitespace
            if (password.contains(" ")) {
                throw new Exception("Password cannot contain whitespace.");
            }
        }
    }

