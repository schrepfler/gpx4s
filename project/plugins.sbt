addSbtPlugin("com.dwijnand"      % "sbt-dynver"      % "3.1.0")
addSbtPlugin("com.dwijnand"      % "sbt-travisci"    % "1.1.3")
addSbtPlugin("com.geirsson"      % "sbt-scalafmt"    % "1.5.1")
addSbtPlugin("de.heikoseeberger" % "sbt-header"      % "5.1.0")
addSbtPlugin("org.wartremover"   % "sbt-wartremover" % "2.3.1")
addSbtPlugin("org.scalaxb"       % "sbt-scalaxb"     % "1.7.0")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" // Needed by sbt-git
