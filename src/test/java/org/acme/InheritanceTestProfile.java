package org.acme;

import io.quarkus.test.junit.QuarkusTestProfile;

public class InheritanceTestProfile implements QuarkusTestProfile {

    public static final String TEST_PROFILE = "child-profile";

    @Override
    public String getConfigProfile() {
        return TEST_PROFILE;
    }
}
