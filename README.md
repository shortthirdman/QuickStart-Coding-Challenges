# Quickstart Coding Challenges

[![Java CI with Maven/Gradle](https://github.com/shortthirdman/QuickStart-Coding-Challenges/actions/workflows/ci.yml/badge.svg?event=workflow_dispatch)](https://github.com/shortthirdman/QuickStart-Coding-Challenges/actions/workflows/ci.yml)

[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/10415/badge)](https://www.bestpractices.dev/projects/10415)

![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/shortthirdman/QuickStart-Coding-Challenges)	![GitHub repo size](https://img.shields.io/github/repo-size/shortthirdman/QuickStart-Coding-Challenges)

![GitHub commit activity](https://img.shields.io/github/commit-activity/w/shortthirdman/QuickStart-Coding-Challenges)	![GitHub](https://img.shields.io/github/license/shortthirdman/QuickStart-Coding-Challenges)	![GitHub last commit](https://img.shields.io/github/last-commit/shortthirdman/QuickStart-Coding-Challenges)	![Maintenance](https://img.shields.io/maintenance/yes/2024)

All Java solutions for various challenges presented during interviews for software development positions.

- [CodeSignal](https://app.codesignal.com)
- [LeetCode](https://leetcode.com)
- [HackerRank](https://hackerrank.com)
- [Codility](https://app.codility.com)

## Requirements

- [Apache Maven 3.9.x](https://maven.apache.org/)
- [OpenJDK/Oracle Java 21](https://www.oracle.com/java/technologies/downloads/)
- [JetBrains IntelliJ IDEA (Community/Ultimate)](https://www.jetbrains.com/idea/)


## Run, Test and Code Coverage

```shell
mvn jacoco:prepare-agent clean test surefire-report:report jacoco:report
```

## Release and Tag

```shell
mvn release:update-versions -DdevelopmentVersion=1.0.1-SNAPSHOT

mvn release:prepare -Dtag=quickstart-challenges-1.0.0 -DreleaseVersion=1.0.0 -DdevelopmentVersion=1.0.1-SNAPSHOT -DdryRun=true

mvn release:perform -DconnectionUrl="scm:git:git@github.com:shortthirdman/Quickstart-Coding-Challenges.git" -Dtag=1.0.0 -DdryRun=true
```


## Contributing

[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![first-timers-only](https://img.shields.io/badge/first--timers--only-friendly-blue.svg?style=flat-square)](https://www.firsttimersonly.com/)

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

**Working on your first Pull Request?** You can learn how from this *free* series [How to Contribute to an Open Source Project on GitHub](https://kcd.im/pull-request)

## References

- [Running GitHub Actions Locally: A Complete Guide for Windows, Mac, and Linux Users](https://medium.com/debasishkumardas5/running-github-actions-locally-a-complete-guide-for-windows-mac-and-linux-users-34c45999c7cd)

- [How to test GitHub Actions locally?](https://www.browserstack.com/guide/test-github-actions-locally)

- [Getting "Skipping JaCoCo execution due to missing execution data file" upon executing JaCoCo](https://stackoverflow.com/questions/18107375/getting-skipping-jacoco-execution-due-to-missing-execution-data-file-upon-exec)

## License

[Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0)
