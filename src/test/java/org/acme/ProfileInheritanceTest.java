package org.acme;

import io.quarkus.runtime.configuration.ProfileManager;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestProfile(InheritanceTestProfile.class)
public class ProfileInheritanceTest {

    @Test
    void testPropertyValues() {
        assertThat(ProfileManager.getActiveProfile()).isEqualTo(InheritanceTestProfile.TEST_PROFILE);
        assertThat(getValue("key1")).isEqualTo("value1");
        assertThat(getValue("key2")).isEqualTo("value2");
        assertThat(getValue("key3")).isEqualTo("value3");
        assertThat(getValue("key4")).isEqualTo("value4");
    }

    private String getValue(String key) {
        return ConfigProvider.getConfig().getValue(key, String.class);
    }
}
