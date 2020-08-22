package io.github.pascalgrimaud;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("io.github.pascalgrimaud");

        noClasses()
            .that()
                .resideInAnyPackage("io.github.pascalgrimaud.service..")
            .or()
                .resideInAnyPackage("io.github.pascalgrimaud.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..io.github.pascalgrimaud.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
