package com.vectree.billing.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Role unit test check that all works fine.
 *
 * @version 0.1
 */
public class UserTest {
    private User user = new User();

    /**
     * Test get name from User.
     */
    @Test
    public void testNotNullName() {
        assertThat(user.getUsername(), is(""));
    }

    /**
     * Test get email from User.
     */
    @Test
    public void testNotNullEmail() {
        assertThat(user.getEmail(), is(""));
    }

    /**
     * Test get password from User.
     */
    @Test
    public void testNotNullPassword() {
        assertThat(user.getPassword(), is(""));
    }

    /**
     * Test toString() is not null
     */
    @Test
    public void testToString() {
        assertThat(user.toString(), instanceOf(String.class));
    }
}
