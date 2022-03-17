package com.zrk.session;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.zrk.session");

        noClasses()
            .that()
            .resideInAnyPackage("com.zrk.session.service..")
            .or()
            .resideInAnyPackage("com.zrk.session.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.zrk.session.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
