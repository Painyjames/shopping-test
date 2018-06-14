import sbt.Keys.libraryDependencies

lazy val shoppingTest = (project in file(".")).settings(
  Seq(
    name := "shopping-test",
    version := "1.0.0",
    scalaVersion := "2.12.3",
    libraryDependencies := Seq(
      "org.scalatest"                %%  "scalatest"                    % "3.0.3"
    )
  )
)
