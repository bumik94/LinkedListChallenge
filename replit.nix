{ pkgs }: {
    deps = [
      pkgs.jre
      pkgs.openjdk
      pkgs.jetbrains.jdk
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}