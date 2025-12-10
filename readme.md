### How to reproduce an error

Note: this repo uses old sbt-idea-plugin (`addSbtPlugin("org.jetbrains" % "sbt-idea-plugin" % "3.25.0")`), new one will
be used later in reproduction steps. It also uses an old Scala plugin and IDE version, because new one doesn't work with
the old sbt-idea-plugin.

1. Clone this repository
2. run `sbt clean packageArtifactZip`
3. Observe the error message _Plugin 'zzzcom.home.my-idea-plugin' requires plugin 'org.intellij.scala' to be installed_
   somewhere among logs. Check `target/searchableOptions` directory, there will be no
   `p-zzzcom.home.my-idea-plugin-searchableOptions.json` file (should be at the end of the directory listing).
4. run `sbt clean runIDE`
5. In the opened IDE, don't import any settings (click "Skip Import" if necessary). Observe _Plugin '
   zzzcom.home.my-idea-plugin' requires plugin 'org.intellij.scala' to be installed_ error popup. Don't create any
   project, and just go to Plugins → Marketplace tab. Search for Scala plugin, install it. After installation, close
   the IDE.
6. Exit sbt if necessary, run `sbt clean runIDE` (again, otherwise it'll not work)
7. There will be no error this time, and Scala plugin is installed correctly. Close that IDE.
8. Exit sbt if necessary, run `sbt clean packageArtifactZip` again. This time, there will be no _requires plugin '
   org.intellij.scala' to be installed_ error and `target/searchableOptions` directory will contain a
   `p-zzzcom.home.my-idea-plugin-searchableOptions.json` file. Note that it still returns an error, but I've already
   tried so many combinations that I gave up trying to fully mimic the real plugin behavior. It doesn't look like it's
   important for the reproduction of the main issue.
9. Update the version of sbt-idea-plugin to the latest one:
   `addSbtPlugin("org.jetbrains.scala" % "sbt-idea-plugin" % "5.1.0-RC4")`
10. Drop all local caches: `rm -rf ~/.my-idea-pluginPluginIC/` (re-indexing will take a while, sorry)
11. Repeat steps 2-8. This time, after step 8 there will be no `p-zzzcom.home.my-idea-plugin-searchableOptions.json`
    file in the `target/searchableOptions` directory. So the "fix" with the old plugin version doesn't work with the new
    one at all.
