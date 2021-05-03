![Project icon](https://github.com/AeiouEnigma/lithium-forge/blob/1.16.x/dev/src/main/resources/icon.png)

# Lithium (Forge fork)
![GitHub license](https://img.shields.io/github/license/AeiouEnigma/lithium-forge.svg)

### This is Forge edition of Lithium

Lithium is a modern, general-purpose optimization mod for Minecraft which works to improve a number of systems (game physics, mob AI, block ticking, etc) with the goal of not changing any vanilla mechanics.
:warning: Though this fork is functional, things may be broken.

### Downloads

Currently, only on [release page](https://github.com/AeiouEnigma/lithium-forge/releases/latest/).

### Community
Please **DO NOT** join CaffeineMC's Discord to seek support for this fork. Forks or unofficial versions
of Lithium are not supported by the original developers. If you encounter any issues, check current issues on this repo or
make a new issue.

### Building from source

If you're hacking on the code or would like to compile a custom build of Lithium from the latest sources, you'll want
to start here.

#### Prerequisites

You will need to install JDK 8 (or newer, see below) in order to build Lithium. You can either install this through
a package manager such as [Chocolatey](https://chocolatey.org/) on Windows or [SDKMAN!](https://sdkman.io/) on other
platforms. If you'd prefer to not use a package manager, you can always grab the installers or packages directly from
[AdoptOpenJDK](https://adoptopenjdk.net/).

On Windows, the Oracle JDK/JRE builds should be avoided where possible due to their poor quality. Always prefer using
the open-source builds from AdoptOpenJDK when possible.

#### Compiling

Navigate to the directory you've cloned this repository and launch a build with Gradle using `gradlew build` (Windows)
or `./gradlew build` (macOS/Linux). If you are not using the Gradle wrapper, simply replace `gradlew` with `gradle`
or the path to it.

The initial setup may take a few minutes. After Gradle has finished building everything, you can find the resulting
artifacts in `build/libs`.

### License

Lithium is licensed under GNU LGPLv3, a free and open-source license. For more information, please see the
[license file](https://github.com/AeiouEnigma/lithium-forge/blob/1.16.x/dev/LICENSE.txt).
