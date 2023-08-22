package com.example.monolith;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@SpringBootTest
public abstract class BaseArchitectureTest {

    private final JavaClasses importedClasses;

    public BaseArchitectureTest() {
        importedClasses =
                new ClassFileImporter()
                        .withImportOption(
                                new com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests())
                        .importPackages(getPackageName() + "..");
    }

    protected abstract String getPackageName();

    protected abstract List<String> getAllowedPorts();

    private List<String> getAllowedImports() {
        var allowed = getBaseAllowedImports();

        Optional.ofNullable(getAllowedPorts()).ifPresent(allowed::addAll);

        return allowed;
    }

    private ArrayList<String> getBaseAllowedImports() {
        return new ArrayList<>(
                Arrays.asList(
                        "com.fasterxml..",
                        "javax.money..",
                        "org.mapstruct..",
                        "org.springframework..",
                        "org.slf4j..",
                        "org.apache.commons..",
                        "lombok..",
                        "java..",
                        "org.javamoney..",
                        "javax.money..",
                        "org.bson..",
                        getPackageName() + ".."));
    }

    @Test
    public void domainCannotImportInfrastructureTest() {
        ArchRule rule =
                noClasses()
                        .that()
                        .resideInAPackage(getPackageName() + ".domain..")
                        .should()
                        .accessClassesThat()
                        .resideInAnyPackage(getPackageName() + ".infrastructure..")
                        .allowEmptyShould(true);

        rule.check(importedClasses);
    }

    @Test
    public void domainCannotImportApplicationTest() {
        ArchRule rule =
                noClasses()
                        .that()
                        .resideInAPackage(getPackageName() + ".domain..")
                        .should()
                        .accessClassesThat()
                        .resideInAnyPackage(getPackageName() + ".application..")
                        .allowEmptyShould(true);

        rule.check(importedClasses);
    }

    @Test
    public void domainCannotImportExternalTest() {
        ArchRule rule =
                noClasses()
                        .that()
                        .resideInAPackage(getPackageName() + ".domain..")
                        .should()
                        .accessClassesThat()
                        .resideOutsideOfPackages(getBaseAllowedImports().toArray(String[]::new))
                        .allowEmptyShould(true);

        rule.check(importedClasses);
    }

    @Test
    public void applicationCannotImportInfrastructureTest() {
        ArchRule rule =
                noClasses()
                        .that()
                        .resideInAPackage(getPackageName() + ".application..")
                        .should()
                        .accessClassesThat()
                        .resideInAnyPackage(getPackageName() + ".infrastructure..")
                        .allowEmptyShould(true);

        rule.check(importedClasses);
    }

    @Test
    public void applicationCanImportOnlyPortsTest() {
        ArchRule rule =
                noClasses()
                        .that()
                        .resideInAPackage(getPackageName() + ".application..")
                        .should()
                        .accessClassesThat()
                        .resideOutsideOfPackages(getAllowedImports().toArray(String[]::new))
                        .allowEmptyShould(true);

        rule.check(importedClasses);
    }
}
