/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

import org.junit.Assert;
import org.junit.Test;

public class PasswordTest extends SDKTestCase {
    @Test
    public void testGettersOfDefaultPasswords() {
        for (Password password : service.getPasswords().values()) {
            testGettersOf(password);
        }
    }
    
    private void testGettersOf(Password password) {
        password.getClearPassword();
        password.getEncryptedPassword();
        password.getPassword();
        password.getRealm();
        password.getUsername();
    }

    @Test
    public void testPasswordCrud() {
        PasswordCollection passwords = service.getPasswords();

        String name = "sdk-test";
        String value = "sdk-test-password";
        String realm = "sdk-test-realm";

        if (passwords.containsKey(name))
            passwords.remove(name);
        Assert.assertFalse(passwords.containsKey(name));

        Password password;

        // Create a password without realm
        password = passwords.create(name, value);
        Assert.assertTrue(passwords.containsKey(name));
        Assert.assertEquals(name, password.getUsername());
        Assert.assertEquals(value, password.getClearPassword());
        Assert.assertEquals(null, password.getRealm());

        // Update the password
        password.update(new Args("password", "foobar"));
        Assert.assertTrue(passwords.containsKey(name));
        Assert.assertEquals(name, password.getUsername());
        Assert.assertEquals("foobar", password.getClearPassword());
        Assert.assertEquals(null, password.getRealm());

        passwords.remove(name);
        Assert.assertFalse(passwords.containsKey(name));

        // Create a password with a realm
        password = passwords.create(name, value, realm);
        Assert.assertTrue(passwords.containsKey(name));
        Assert.assertEquals(name, password.getUsername());
        Assert.assertEquals(value, password.getClearPassword());
        Assert.assertEquals(realm, password.getRealm());

        // Update the password
        password.update(new Args("password", "bizbaz"));
        Assert.assertTrue(passwords.containsKey(name));
        Assert.assertEquals(name, password.getUsername());
        Assert.assertEquals("bizbaz", password.getClearPassword());
        Assert.assertEquals(realm, password.getRealm());

        Assert.assertTrue(password.getEncryptedPassword().length() > 0);
        Assert.assertEquals(password.getName(), name);
        Assert.assertTrue(password.getPassword().length() > 0);
        
        password.setPassword("booyah");
        password.update();
        Assert.assertTrue(password.getPassword().length() > 0);
        
        passwords.remove(name);
        Assert.assertFalse(passwords.containsKey(name));
    }
}
